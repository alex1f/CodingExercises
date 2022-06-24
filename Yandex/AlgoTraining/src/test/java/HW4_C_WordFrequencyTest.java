import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HW4_C_WordFrequencyTest {

    @Test
    public void testOnProblemData1(){
        //input
        List<String> lines = new ArrayList<>(
                Arrays.asList(
                "hi",
                "hi",
                "what is your name",
                "my name is bond",
                "james bond",
                "my name is damme",
                "van damme",
                "claude van damme",
                "jean claude van damme"
                )
        );

        //expected result
        List<String> expectedResult = new ArrayList<>(
                Arrays.asList(
                        "damme",
                        "is",
                        "name",
                        "van",
                        "bond",
                        "claude",
                        "hi",
                        "my",
                        "james",
                        "jean",
                        "what",
                        "your"
                )
        );

        //my calculated result
        List<String> myResult = HW4_C_WordFrequency.getWordListBasedOnFrequency(lines);

        assertEquals(expectedResult, myResult);
    }

    @Test
    public void testOnProblemData2(){
        //input
        List<String> lines = new ArrayList<>(
                Arrays.asList(
                        "oh you touch my tralala",
                        "mmm my ding ding dong"

                )
        );

        //expected result
        List<String> expectedResult = new ArrayList<>(
                Arrays.asList(
                        "ding",
                        "my",
                        "dong",
                        "mmm",
                        "oh",
                        "touch",
                        "tralala",
                        "you"
                )
        );

        //my calculated result
        List<String> myResult = HW4_C_WordFrequency.getWordListBasedOnFrequency(lines);

        assertEquals(expectedResult, myResult);
    }

    @Test
    public void testOnProblemData3(){
        //input
        List<String> lines = new ArrayList<>(
                Arrays.asList(
                        "ai ai ai ai ai ai ai ai ai ai"
                )
        );

        //expected result
        List<String> expectedResult = new ArrayList<>(
                Arrays.asList(
                        "ai"
                )
        );

        //my calculated result
        List<String> myResult = HW4_C_WordFrequency.getWordListBasedOnFrequency(lines);

        assertEquals(expectedResult, myResult);
    }
}