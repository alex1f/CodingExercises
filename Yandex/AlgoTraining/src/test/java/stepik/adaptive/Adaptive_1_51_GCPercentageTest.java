package stepik.adaptive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Adaptive_1_51_GCPercentageTest {
    @Test
    public void defaultData(){
        String input = "acggtgttat";
        double expectedPercentage = 40.0;
        double myPercentage = Adaptive_1_51_GCPercentage.analyzeSequenceForGCPercentage(input);
        assertEquals(expectedPercentage, myPercentage);
    }

    @Test
    public void randomString(){
        String input = "dfgctiuhoygp"; //3 instances, total length 14
        double expectedPercentage = 25.0;
        double myPercentage = Adaptive_1_51_GCPercentage.analyzeSequenceForGCPercentage(input);
        assertEquals(expectedPercentage, myPercentage);
    }

    @Test
    public void noTargetOccurrences(){
        String input = "aaa";
        double expectedPercentage = 0.0;
        double myPercentage = Adaptive_1_51_GCPercentage.analyzeSequenceForGCPercentage(input);
        assertEquals(expectedPercentage, myPercentage);
    }

    @Test
    public void onlyTargetOccurrences(){
        String input = "gcg";
        double expectedPercentage = 100.0;
        double myPercentage = Adaptive_1_51_GCPercentage.analyzeSequenceForGCPercentage(input);
        assertEquals(expectedPercentage, myPercentage);
    }

    @Test
    public void mixedCaseOnlyTargetOccurrences(){
        String input = "gCG";
        double expectedPercentage = 100.0;
        double myPercentage = Adaptive_1_51_GCPercentage.analyzeSequenceForGCPercentage(input);
        assertEquals(expectedPercentage, myPercentage);
    }
}