package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Leet121_Best_TimeTest {

    @Test
    public void defaultData1(){
        int[] input = {7,1,5,3,6,4};

        int expectedProfit = 5;

        Leet121_Best_Time profitAnalyzer = new Leet121_Best_Time();

        int myProfit = profitAnalyzer.maxProfit(input);

        assertEquals(expectedProfit, myProfit);
    }

    @Test
    public void defaultData2(){
        int[] input = {7,6,4,3,1};

        int expectedProfit = 0;

        Leet121_Best_Time profitAnalyzer = new Leet121_Best_Time();

        int myProfit = profitAnalyzer.maxProfit(input);

        assertEquals(expectedProfit, myProfit);
    }

    @Test
    public void spikes(){
        int[] input = {1,6,2,6,1};

        int expectedProfit = 5;

        Leet121_Best_Time profitAnalyzer = new Leet121_Best_Time();

        int myProfit = profitAnalyzer.maxProfit(input);

        assertEquals(expectedProfit, myProfit);
    }

    @Test
    public void onlyOneDataPoint(){
        int[] input = {1};

        int expectedProfit = 0;

        Leet121_Best_Time profitAnalyzer = new Leet121_Best_Time();

        int myProfit = profitAnalyzer.maxProfit(input);

        assertEquals(expectedProfit, myProfit);
    }

    @Test
    public void allZeroes(){
        int[] input = {0, 0, 0};

        int expectedProfit = 0;

        Leet121_Best_Time profitAnalyzer = new Leet121_Best_Time();

        int myProfit = profitAnalyzer.maxProfit(input);

        assertEquals(expectedProfit, myProfit);
    }

    @Test
    public void allPricesAreTheSame(){
        int[] input = {10000, 10000, 10000};

        int expectedProfit = 0;

        Leet121_Best_Time profitAnalyzer = new Leet121_Best_Time();

        int myProfit = profitAnalyzer.maxProfit(input);

        assertEquals(expectedProfit, myProfit);
    }
}