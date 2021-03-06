import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HW4_D_ElectionResultsTest {


    @Test
    public void testWithSampleData1() {
        //input
        List<OnePartyStats> results = Arrays.asList(
                new OnePartyStats(1, "Party One", 100000),
                new OnePartyStats(2, "Party Two", 200000),
                new OnePartyStats(3, "Party Three", 400000)
        );

        int totalMandates = 450;

        //expected results
        int[] mandates = new int[] {64, 129, 257};


        //my calculated results
        List<OnePartyStats> myResults = HW4_D_ElectionResults.processRawVotingResults(results, totalMandates);

        //check
        for (int i = 0; i < mandates.length; i++){
            assertEquals(mandates[i], myResults.get(i).getMandates());
        }
    }

    @Test
    public void testWithSampleData2() {
        //input
        List<OnePartyStats> results = Arrays.asList(
                new OnePartyStats(1, "Party number one", 100),
                new OnePartyStats(2, "Partytwo", 100)
        );

        int totalMandates = 450;

        //expected results
        int[] mandates = new int[] {225, 225};


        //my calculated results
        List<OnePartyStats> myResults = HW4_D_ElectionResults.processRawVotingResults(results, totalMandates);

        //check
        for (int i = 0; i < mandates.length; i++){
            assertEquals(mandates[i], myResults.get(i).getMandates());
        }
    }

    @Test
    public void testWithSampleData3() {
        //input
        List<OnePartyStats> results = Arrays.asList(
                new OnePartyStats(1, "Party number one", 449),
                new OnePartyStats(2, "Partytwo", 1)
        );

        int totalMandates = 450;

        //expected results
        int[] mandates = new int[] {449, 1};


        //my calculated results
        List<OnePartyStats> myResults = HW4_D_ElectionResults.processRawVotingResults(results, totalMandates);

        //check
        for (int i = 0; i < mandates.length; i++){
            assertEquals(mandates[i], myResults.get(i).getMandates());
        }
    }

    @Test
    public void testOnlyOneParty() {
        //input
        List<OnePartyStats> results = Arrays.asList(
                new OnePartyStats(1, "Party number one", 449)
        );

        int totalMandates = 450;

        //expected results
        int[] mandates = new int[] {450};


        //my calculated results
        List<OnePartyStats> myResults = HW4_D_ElectionResults.processRawVotingResults(results, totalMandates);

        //check
        for (int i = 0; i < mandates.length; i++){
            assertEquals(mandates[i], myResults.get(i).getMandates());
        }
    }

    @Test
    public void testThreePartiesWithOneVoteEach() {
        //input
        List<OnePartyStats> results = Arrays.asList(
                new OnePartyStats(1, "Party number one", 1),
                new OnePartyStats(1, "Party number two", 1),
                new OnePartyStats(1, "Party number three", 1)
        );

        int totalMandates = 450;

        //expected results
        int[] mandates = new int[] {150, 150, 150};


        //my calculated results
        List<OnePartyStats> myResults = HW4_D_ElectionResults.processRawVotingResults(results, totalMandates);

        //check
        for (int i = 0; i < mandates.length; i++){
            assertEquals(mandates[i], myResults.get(i).getMandates());
        }
    }

    @Test
    public void testOnePartyGetsZeroVotes() {
        //input
        List<OnePartyStats> results = Arrays.asList(
                new OnePartyStats(1, "Party number one", 1),
                new OnePartyStats(1, "Party number two", 1),
                new OnePartyStats(1, "Party number three", 1),
                new OnePartyStats(1, "Party number four", 0)
        );

        int totalMandates = 450;

        //expected results
        int[] mandates = new int[] {150, 150, 150, 0};


        //my calculated results
        List<OnePartyStats> myResults = HW4_D_ElectionResults.processRawVotingResults(results, totalMandates);

        //check
        for (int i = 0; i < mandates.length; i++){
            assertEquals(mandates[i], myResults.get(i).getMandates());
        }
    }

    @Test
    public void testOnePartyGetsMoreVotesAndTwoPartiesGetEqualNumbers() {
        //input
        List<OnePartyStats> results = Arrays.asList(
                new OnePartyStats(1, "Party number one", 400),
                new OnePartyStats(1, "Party number two", 100),
                new OnePartyStats(1, "Party number three", 100)
        );

        int totalMandates = 450;

        //expected results
        int[] mandates = new int[] {300, 75, 75};


        //my calculated results
        List<OnePartyStats> myResults = HW4_D_ElectionResults.processRawVotingResults(results, totalMandates);

        //check
        for (int i = 0; i < mandates.length; i++){
            assertEquals(mandates[i], myResults.get(i).getMandates());
        }
    }

    @Test
    public void allPartiesGetZeroVotes() {
        //input
        List<OnePartyStats> results = Arrays.asList(
                new OnePartyStats(1, "Party number one", 0),
                new OnePartyStats(1, "Party number two", 0)
        );

        int totalMandates = 450;

        //expected results
        int[] mandates = new int[] {225, 225};


        //my calculated results
        List<OnePartyStats> myResults = HW4_D_ElectionResults.processRawVotingResults(results, totalMandates);

        //check
        for (int i = 0; i < mandates.length; i++){
            assertEquals(mandates[i], myResults.get(i).getMandates());
        }
    }

}