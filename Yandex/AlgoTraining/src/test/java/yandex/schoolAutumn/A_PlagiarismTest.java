package yandex.schoolAutumn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class A_PlagiarismTest {

    @Test
    public void defaultData1(){
        String input = "CLOUD";

        String suspect = "CUPID";

        String correctVerdict = "PSIIP";

        String myEvaluation = A_Plagiarism.findPlagiarism(input, suspect);


        assertEquals(correctVerdict, myEvaluation);
    }

    @Test
    public void defaultData2(){
        String input = "ALICE";

        String suspect = "ELIBO";

        String correctVerdict = "SPPII";

        String myEvaluation = A_Plagiarism.findPlagiarism(input, suspect);


        assertEquals(correctVerdict, myEvaluation);
    }

    @Test
    public void defaultData3(){
        String input = "ABCBCYA";

        String suspect = "ZBBACAA";

        String correctVerdict = "IPSSPIP";

        String myEvaluation = A_Plagiarism.findPlagiarism(input, suspect);


        assertEquals(correctVerdict, myEvaluation);
    }

    @Test
    public void lengthOneSame(){
        String input = "A";

        String suspect = "A";

        String correctVerdict = "P";

        String myEvaluation = A_Plagiarism.findPlagiarism(input, suspect);


        assertEquals(correctVerdict, myEvaluation);
    }

    @Test
    public void lengthOneDifferent(){
        String input = "A";

        String suspect = "B";

        String correctVerdict = "I";

        String myEvaluation = A_Plagiarism.findPlagiarism(input, suspect);


        assertEquals(correctVerdict, myEvaluation);
    }

    @Test
    public void lengthTwoFullPlagiarism(){
        String input = "AB";

        String suspect = "AB";

        String correctVerdict = "PP";

        String myEvaluation = A_Plagiarism.findPlagiarism(input, suspect);


        assertEquals(correctVerdict, myEvaluation);
    }

    @Test
    public void lengthTwoNoPlagiarism(){
        String input = "AB";

        String suspect = "CD";

        String correctVerdict = "II";

        String myEvaluation = A_Plagiarism.findPlagiarism(input, suspect);


        assertEquals(correctVerdict, myEvaluation);
    }

    @Test
    public void lengthTwoLetterPlacesSwitched(){
        String input = "AB";

        String suspect = "BA";

        String correctVerdict = "SS";

        String myEvaluation = A_Plagiarism.findPlagiarism(input, suspect);


        assertEquals(correctVerdict, myEvaluation);
    }

    @Test
    public void oneLetterDifferentOtherLetterPlacesSwitched(){
        String input = "ABC";

        String suspect = "BZA";

        String correctVerdict = "SIS";

        String myEvaluation = A_Plagiarism.findPlagiarism(input, suspect);


        assertEquals(correctVerdict, myEvaluation);
    }
}