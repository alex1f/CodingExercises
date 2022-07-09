import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HW5_B_MaxSumTest {

    @Test
    public void defaultData1(){
        //input
        int[] numbers = new int[]{1, 2, 3, 4};

        //expected
        long expectedSum = 10;

        //actual
        long calculatedSum = HW5_B_MaxSum.findLongestSegment(numbers);

        assertEquals(expectedSum, calculatedSum);
    }

    @Test
    public void defaultData2(){
        //input
        int[] numbers = new int[]{5, 4, -10, 4};

        //expected
        long expectedSum = 9;

        //actual
        long calculatedSum = HW5_B_MaxSum.findLongestSegment(numbers);

        assertEquals(expectedSum, calculatedSum);
    }

    @Test
    public void onlyOneElement(){
        //input
        int[] numbers = new int[]{6};

        //expected
        long expectedSum = 6;

        //actual
        long calculatedSum = HW5_B_MaxSum.findLongestSegment(numbers);

        assertEquals(expectedSum, calculatedSum);
    }

    @Test
    public void allZeroes(){
        //input
        int[] numbers = new int[]{0, 0, 0};

        //expected
        long expectedSum = 0;

        //actual
        long calculatedSum = HW5_B_MaxSum.findLongestSegment(numbers);

        assertEquals(expectedSum, calculatedSum);
    }

    @Test
    public void onlyOnePositiveNumber(){
        //input
        int[] numbers = new int[]{-6, 5, -100};

        //expected
        long expectedSum = 5;

        //actual
        long calculatedSum = HW5_B_MaxSum.findLongestSegment(numbers);

        assertEquals(expectedSum, calculatedSum);
    }

    @Test
    public void onlyNegativeNumbers(){
        //input
        int[] numbers = new int[]{-6, -1, -100};

        //expected
        long expectedSum = -1;

        //actual
        long calculatedSum = HW5_B_MaxSum.findLongestSegment(numbers);

        assertEquals(expectedSum, calculatedSum);
    }

    @Test
    public void onlyNegativeNumbersWithOneZero(){
        //input
        int[] numbers = new int[]{-6, 0, -100};

        //expected
        long expectedSum = 0;

        //actual
        long calculatedSum = HW5_B_MaxSum.findLongestSegment(numbers);

        assertEquals(expectedSum, calculatedSum);
    }

    @Test
    public void allZeroesWithOnePositive(){
        //input
        int[] numbers = new int[]{0, 6, 0};

        //expected
        long expectedSum = 6;

        //actual
        long calculatedSum = HW5_B_MaxSum.findLongestSegment(numbers);

        assertEquals(expectedSum, calculatedSum);
    }

}