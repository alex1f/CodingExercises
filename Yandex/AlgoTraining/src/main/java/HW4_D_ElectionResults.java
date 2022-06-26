import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HW4_D_ElectionResults {
    private static int partyId = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:/input.txt"));
        List<OnePartyStats> results = readVotingResults(reader);

        int totalMandates = 450;
        processRawVotingResults(results, totalMandates);

        results.forEach(result -> System.out.println(result.getPartyName() + " " + result.getMandates()));
    }

    public static List<OnePartyStats> processRawVotingResults(List<OnePartyStats> rawResults, int totalMandates){
        long totalVotes = rawResults.stream().mapToLong(OnePartyStats::getVotes).sum();
        double firstElectoralQuotient = (double) totalVotes / totalMandates;

        int allocatedMandates = 0;

        for (OnePartyStats entry : rawResults){
            entry.setMandates( (int) (entry.getVotes() / firstElectoralQuotient));
            entry.setVoteRemainder( (int) (entry.getVotes() % firstElectoralQuotient));
            allocatedMandates += entry.getMandates();
        }

        if (allocatedMandates < totalMandates){
            int mandatesToAllocate = totalMandates - allocatedMandates;
            rawResults.sort(Comparator.comparing(OnePartyStats::getVoteRemainder).thenComparing(OnePartyStats::getVotes).reversed());
            int i = 0;
            while (mandatesToAllocate > 0){
                int currentMandates = rawResults.get(i).getMandates();
                rawResults.get(i).setMandates(currentMandates + 1);
                mandatesToAllocate--;
                i++;
            }
        }

        rawResults.sort(Comparator.comparing(OnePartyStats::getPartyId));
        return rawResults;
    }


    static List<OnePartyStats> readVotingResults(BufferedReader reader) throws IOException{
        List<OnePartyStats> votingResults = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null){
            votingResults.add(getRawDataFromInputLine(line));
        }

        return votingResults;
    }

    private static OnePartyStats getRawDataFromInputLine (String line){
        String[] lineComponents = line.split(" ");
        int lastElement = lineComponents.length-1;
        String rawVotes = lineComponents[lastElement];
        int numberOfSymbolsForVotesWithSpace = rawVotes.length() + 1;
        int endPointForSubString = line.length() - numberOfSymbolsForVotesWithSpace;

        String partyName = line.substring(0, endPointForSubString);
        int votes = Integer.parseInt(rawVotes);
        int partyId = getNextPartyId();

        return new OnePartyStats(partyId, partyName, votes);
    }

    private static int getNextPartyId(){
        return partyId++;
    }

}

class OnePartyStats {
    private final int partyId;
    private final String partyName;
    private final long votes;
    private int mandates;
    private int voteRemainder;

    public OnePartyStats(int partyId, String partyName, int votes) {
        this.partyId = partyId;
        this.partyName = partyName;
        this.votes = votes;
    }

    public void setMandates(int mandates) {
        this.mandates = mandates;
    }

    public void setVoteRemainder(int voteRemainder) {
        this.voteRemainder = voteRemainder;
    }

    public int getPartyId() {
        return partyId;
    }

    public String getPartyName() {
        return partyName;
    }

    public long getVotes() {
        return votes;
    }

    public int getMandates() {
        return mandates;
    }

    public int getVoteRemainder() {
        return voteRemainder;
    }
}
