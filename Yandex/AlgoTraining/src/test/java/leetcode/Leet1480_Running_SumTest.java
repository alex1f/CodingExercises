package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Leet1480_Running_SumTest {

    @Test
    public void defaultData1(){
        int[] input = new int[] {1,2,3,4};

        int[] expectedResult = new int[] {1,3,6,10};

        Leet1480_Running_Sum calculator = new Leet1480_Running_Sum();

        int[] myResult = calculator.runningSum(input);

        assertArrayEquals(expectedResult, myResult);
    }

    @Test
    public void defaultData2(){
        int[] input = new int[] {1,1,1,1,1};

        int[] expectedResult = new int[] {1,2,3,4,5};

        Leet1480_Running_Sum calculator = new Leet1480_Running_Sum();

        int[] myResult = calculator.runningSum(input);

        assertArrayEquals(expectedResult, myResult);
    }

    @Test
    public void defaultData3(){
        int[] input = new int[] {3,1,2,10,1};

        int[] expectedResult = new int[] {3,4,6,16,17};

        Leet1480_Running_Sum calculator = new Leet1480_Running_Sum();

        int[] myResult = calculator.runningSum(input);

        assertArrayEquals(expectedResult, myResult);
    }

}