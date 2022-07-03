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
        long calculatedSum = new SegmentCalculator().findLongestSegment(numbers);

        assertEquals(expectedSum, calculatedSum);
    }

    @Test
    public void defaultData2(){
        //input
        int[] numbers = new int[]{5, 4, -10, 4};

        //expected
        long expectedSum = 9;

        //actual
        long calculatedSum = new SegmentCalculator().findLongestSegment(numbers);

        assertEquals(expectedSum, calculatedSum);
    }


}