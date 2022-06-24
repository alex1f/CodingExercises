import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class HW4_B_Elections {
    public static void main(String[] args) {
        List<VoteBlock> votingResults = new ArrayList<>();
        String input;


        System.out.println("Ready to read input");

        try (BufferedReader reader = new BufferedReader(new FileReader("C:/test.txt"))){
            while ((input = reader.readLine()) != null && !input.equals("") ){
                String[] data = input.split(" ");
                VoteBlock votes = new VoteBlock(data[0], Integer.parseInt(data[1]));
                votingResults.add(votes);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("start results");
        tallyVotes(votingResults).forEach((key, value) -> System.out.println(key + " " + value));
        System.out.println("end of results");
    }

    public static Map<String, Integer> tallyVotes(List<VoteBlock> votingResults){
        return   votingResults.stream().
                collect(Collectors.groupingBy(
                        VoteBlock::getCandidate,
                        TreeMap::new,
                        Collectors.summingInt(VoteBlock::getVotes)));
    }
}



class VoteBlock{
    private String candidate;
    private int votes;

    public VoteBlock(String candidate, int votes) {
        this.candidate = candidate;
        this.votes = votes;
    }

    public String getCandidate() {
        return candidate;
    }

    public int getVotes() {
        return votes;
    }
}
