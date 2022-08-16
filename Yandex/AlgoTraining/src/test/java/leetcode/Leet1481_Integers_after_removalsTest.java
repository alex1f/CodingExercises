package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Leet1481_Integers_after_removalsTest {

    @Test
    public void defaultData1(){
        int[] input = new int[] {5,5,4};
        int k = 1;

        int expectedResult = 1;

        Leet1481_Integers_after_removals analyzer = new Leet1481_Integers_after_removals();
        int myResult = analyzer.findLeastNumOfUniqueInts(input, k);

        assertEquals(expectedResult, myResult);
    }

    @Test
    public void defaultData2(){
        int[] input = new int[] {4,3,1,1,3,3,2};
        int k = 3;

        int expectedResult = 2;

        Leet1481_Integers_after_removals analyzer = new Leet1481_Integers_after_removals();
        int myResult = analyzer.findLeastNumOfUniqueInts(input, k);

        assertEquals(expectedResult, myResult);
    }

    @Test
    public void canRemoveAll(){
        int[] input = new int[] {1, 2, 3};
        int k = 3;

        int expectedResult = 0;

        Leet1481_Integers_after_removals analyzer = new Leet1481_Integers_after_removals();
        int myResult = analyzer.findLeastNumOfUniqueInts(input, k);

        assertEquals(expectedResult, myResult);
    }

    @Test
    public void cannotRemoveAnyNumberCompletely(){
        int[] input = new int[] {1, 1, 2, 2, 3, 3};
        int k = 1;

        int expectedResult = 3;

        Leet1481_Integers_after_removals analyzer = new Leet1481_Integers_after_removals();
        int myResult = analyzer.findLeastNumOfUniqueInts(input, k);

        assertEquals(expectedResult, myResult);
    }
}