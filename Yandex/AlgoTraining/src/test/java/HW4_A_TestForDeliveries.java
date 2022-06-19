import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class HW4_A_TestForDeliveries {

    @Test
    @DisplayName("example test 1")
    public void basicTestWithExampleData1(){
        //inputs
        long[] inputColorCodes = {1, 10, 1, 4,4,4,4};
        long[] inputColorValues = {5, -5, 10, -2, 3, 1, 0};

        //expected results
        long[] expectedColorCodes = {1, 4, 10};
        long[] expectedColorFrequencies = {15, 2, -5};
        Map<Long, Long> expectedFrequencies = buildMapOfExpectedFrequencies(expectedColorCodes, expectedColorFrequencies);

        //my calculated result
        Map<Long, Long> actualFrequencies = HW4_A_Deliveries.calculateColorFrequencies(inputColorCodes, inputColorValues);


        assertEquals(expectedFrequencies, actualFrequencies);

    }

    @Test
    @DisplayName("example test 2")
    public void basicTestWithExampleData2(){
        //inputs
        long[] inputColorCodes = {5, -5, 10, -5, 0};
        long[] inputColorValues = {-10000, 100_000_000_000L, 2_000_000_000_000L, -300_000_000_000L, 10_000_000_000_000L};

        //expected results
        long[] expectedColorCodes = {-5, 0, 5, 10};
        long[] expectedColorFrequencies = {-200000000000L, 10000000000000L, -10000, 2000000000000L};
        Map<Long, Long> expectedFrequencies = buildMapOfExpectedFrequencies(expectedColorCodes, expectedColorFrequencies);

        //my calculated result
        Map<Long, Long> actualFrequencies = HW4_A_Deliveries.calculateColorFrequencies(inputColorCodes, inputColorValues);


        assertEquals(expectedFrequencies, actualFrequencies);
    }

    private static Map<Long, Long> buildMapOfExpectedFrequencies(long[] keys, long[] values){
        Map<Long, Long> expectedFrequencies = new TreeMap<>();

        for (int i = 0; i < keys.length; i++){
            expectedFrequencies.put(keys[i], values[i]);
        }

        return expectedFrequencies;
    }
}
