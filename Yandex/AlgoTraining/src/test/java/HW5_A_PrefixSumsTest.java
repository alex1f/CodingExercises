import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HW5_A_PrefixSumsTest {
    @Test
    public void default1(){
        //input
        int[] numbers = new int[] {1,2,3,4};
        PrefixCalculator calculator = new PrefixCalculator(numbers);

        int left = 1;
        int right = 1;

        //expected
        long expectedSum = 1;

        //actual
        long myResult = calculator.calculateSegmentLength(left, right);
        assertEquals(expectedSum, myResult);
    }

    @Test
    public void default2(){
        //input
        int[] numbers = new int[] {1,2,3,4};
        PrefixCalculator calculator = new PrefixCalculator(numbers);

        int left = 1;
        int right = 2;

        //expected
        long expectedSum = 3;

        //actual
        long myResult = calculator.calculateSegmentLength(left, right);
        assertEquals(expectedSum, myResult);
    }

    @Test
    public void default3(){
        //input
        int[] numbers = new int[] {1,2,3,4};
        PrefixCalculator calculator = new PrefixCalculator(numbers);

        int left = 1;
        int right = 3;

        //expected
        long expectedSum = 6;

        //actual
        long myResult = calculator.calculateSegmentLength(left, right);
        assertEquals(expectedSum, myResult);
    }

    @Test
    public void default4(){
        //input
        int[] numbers = new int[] {1,2,3,4};
        PrefixCalculator calculator = new PrefixCalculator(numbers);

        int left = 1;
        int right = 4;

        //expected
        long expectedSum = 10;

        //actual
        long myResult = calculator.calculateSegmentLength(left, right);
        assertEquals(expectedSum, myResult);
    }

    @Test
    public void default5(){
        //input
        int[] numbers = new int[] {1,2,3,4};
        PrefixCalculator calculator = new PrefixCalculator(numbers);

        int left = 2;
        int right = 2;

        //expected
        long expectedSum = 2;

        //actual
        long myResult = calculator.calculateSegmentLength(left, right);
        assertEquals(expectedSum, myResult);
    }

    @Test
    public void default6(){
        //input
        int[] numbers = new int[] {1,2,3,4};
        PrefixCalculator calculator = new PrefixCalculator(numbers);

        int left = 2;
        int right = 3;

        //expected
        long expectedSum = 5;

        //actual
        long myResult = calculator.calculateSegmentLength(left, right);
        assertEquals(expectedSum, myResult);
    }

    @Test
    public void default7(){
        //input
        int[] numbers = new int[] {1,2,3,4};
        PrefixCalculator calculator = new PrefixCalculator(numbers);

        int left = 2;
        int right = 4;

        //expected
        long expectedSum = 9;

        //actual
        long myResult = calculator.calculateSegmentLength(left, right);
        assertEquals(expectedSum, myResult);
    }

    @Test
    public void default8(){
        //input
        int[] numbers = new int[] {1,2,3,4};
        PrefixCalculator calculator = new PrefixCalculator(numbers);

        int left = 3;
        int right = 3;

        //expected
        long expectedSum = 3;

        //actual
        long myResult = calculator.calculateSegmentLength(left, right);
        assertEquals(expectedSum, myResult);
    }

    @Test
    public void default9(){
        //input
        int[] numbers = new int[] {1,2,3,4};
        PrefixCalculator calculator = new PrefixCalculator(numbers);

        int left = 3;
        int right = 4;

        //expected
        long expectedSum = 7;

        //actual
        long myResult = calculator.calculateSegmentLength(left, right);
        assertEquals(expectedSum, myResult);
    }

    @Test
    public void default10(){
        //input
        int[] numbers = new int[] {1,2,3,4};
        PrefixCalculator calculator = new PrefixCalculator(numbers);

        int left = 4;
        int right = 4;

        //expected
        long expectedSum = 4;

        //actual
        long myResult = calculator.calculateSegmentLength(left, right);
        assertEquals(expectedSum, myResult);
    }

}