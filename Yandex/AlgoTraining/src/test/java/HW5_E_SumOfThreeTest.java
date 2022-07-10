import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HW5_E_SumOfThreeTest {
    @Test
    public void defaultData1(){
        int targetNumber = 3;
        List<String> inputArrays = Arrays.asList("2 1 2", "2 3 1", "2 3 1");

        String expectedResult = "0 1 1";

        String myResult = HW5_E_SumOfThree.findPassingIndices(targetNumber, inputArrays);

        assertEquals(expectedResult, myResult);
    }

    @Test
    public void defaultData2(){
        int targetNumber = 10;
        List<String> inputArrays = Arrays.asList("1 5", "1 4", "1 3");

        String expectedResult = "-1";

        String myResult = HW5_E_SumOfThree.findPassingIndices(targetNumber, inputArrays);

        assertEquals(expectedResult, myResult);
    }

    @Test
    public void defaultData3(){
        int targetNumber = 5;
        List<String> inputArrays = Arrays.asList("4 1 2 3 4", "3 5 2 1", "4 5 3 2 2");

        String expectedResult = "0 1 2";

        String myResult = HW5_E_SumOfThree.findPassingIndices(targetNumber, inputArrays);

        assertEquals(expectedResult, myResult);
    }

    @Test
    public void allNumbersTooBig(){
        int targetNumber = 5;
        List<String> inputArrays = Arrays.asList("1 7", "2 789 6", "3 100 100 100");

        String expectedResult = "-1";

        String myResult = HW5_E_SumOfThree.findPassingIndices(targetNumber, inputArrays);

        assertEquals(expectedResult, myResult);
    }

}