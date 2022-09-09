package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Leet704_Binary_SearchTest {
    private Leet704_Binary_Search numberFinder = new Leet704_Binary_Search();


    @Test
    public void defaultData1(){
        int[] input = {-1,0,3,5,9,12};
        int target = 9;

        int correctAnswer = 4;

        int myAnswer = numberFinder.search(input, target);

        assertEquals(correctAnswer, myAnswer);
    }

    @Test
    public void defaultData2(){
        int[] input = {-1,0,3,5,9,12};
        int target = 2;

        int correctAnswer = -1;

        int myAnswer = numberFinder.search(input, target);

        assertEquals(correctAnswer, myAnswer);
    }

    @Test
    public void justOneNumberInArrayAndItIsTheTarget(){
        int[] input = {9};
        int target = 9;

        int correctAnswer = 0;

        int myAnswer = numberFinder.search(input, target);

        assertEquals(correctAnswer, myAnswer);
    }

    @Test
    public void justOneNumberInArrayAndItIsNotTheTarget(){
        int[] input = {9};
        int target = 5;

        int correctAnswer = -1;

        int myAnswer = numberFinder.search(input, target);

        assertEquals(correctAnswer, myAnswer);
    }

    @Test
    public void onlyNegativeNumbers(){
        int[] input = {-10, -8, -6, -4};
        int target = 5;

        int correctAnswer = -1;

        int myAnswer = numberFinder.search(input, target);

        assertEquals(correctAnswer, myAnswer);
    }

    @Test
    public void onlyNegativeNumbers2(){
        int[] input = {-10, -8, -6, -4};
        int target = -8;

        int correctAnswer = 1;

        int myAnswer = numberFinder.search(input, target);

        assertEquals(correctAnswer, myAnswer);
    }
}