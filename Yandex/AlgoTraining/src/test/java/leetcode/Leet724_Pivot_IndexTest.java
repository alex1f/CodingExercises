package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Leet724_Pivot_IndexTest {

    @Test
    public void defaultData1(){
        int[] input = {1,7,3,6,5,6};

        int correctIndex = 3;

        Leet724_Pivot_Index calculator = new Leet724_Pivot_Index();

        int myIndex = calculator.pivotIndex(input);

        assertEquals(correctIndex, myIndex);
    }

    @Test
    public void defaultData2(){
        int[] input = {1,2,3};

        int correctIndex = -1;

        Leet724_Pivot_Index calculator = new Leet724_Pivot_Index();

        int myIndex = calculator.pivotIndex(input);

        assertEquals(correctIndex, myIndex);
    }

    @Test
    public void defaultData3(){
        int[] input = {2,1,-1};

        int correctIndex = 0;

        Leet724_Pivot_Index calculator = new Leet724_Pivot_Index();

        int myIndex = calculator.pivotIndex(input);

        assertEquals(correctIndex, myIndex);
    }

}