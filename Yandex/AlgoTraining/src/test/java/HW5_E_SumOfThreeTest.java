import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HW5_E_SumOfThreeTest {
    @Test
    public void defaultData1(){
        int targetNumber = 3;
        List<int[]> inputArrays = Arrays.asList(new int[]{1, 2}, new int[]{3, 1}, new int[]{3, 1});

        String expectedResult = "0 1 1";

        String myResult = HW5_E_SumOfThree.findPassingIndices(targetNumber, inputArrays);

        assertEquals(expectedResult, myResult);
    }

    @Test
    public void defaultData2(){
        int targetNumber = 10;
        List<int[]> inputArrays = Arrays.asList(new int[]{5}, new int[]{4}, new int[]{3});

        String expectedResult = "-1";

        String myResult = HW5_E_SumOfThree.findPassingIndices(targetNumber, inputArrays);

        assertEquals(expectedResult, myResult);
    }

    @Test
    public void defaultData3(){
        int targetNumber = 5;
        List<int[]> inputArrays = Arrays.asList(new int[]{1, 2, 3, 4}, new int[]{5, 2, 1}, new int[]{5, 3, 2, 2});

        String expectedResult = "0 1 2";

        String myResult = HW5_E_SumOfThree.findPassingIndices(targetNumber, inputArrays);

        assertEquals(expectedResult, myResult);
    }

}