package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Leet392_SubsequenceTest {

    @Test
    public void defaultData1(){
        String candidate = "abc";
        String target = "ahbgdc";

        boolean correctVerdict = true;

        Leet392_Subsequence stringAnalyzer = new Leet392_Subsequence();

        boolean myResult = stringAnalyzer.isSubsequence(candidate, target);

        assertEquals(correctVerdict, myResult);
    }

    @Test
    public void defaultData2(){
        String candidate = "axc";
        String target = "ahbgdc";

        boolean correctVerdict = false;

        Leet392_Subsequence stringAnalyzer = new Leet392_Subsequence();

        boolean myResult = stringAnalyzer.isSubsequence(candidate, target);

        assertEquals(correctVerdict, myResult);
    }

    @Test
    public void defaultData3(){
        String candidate = "ab";
        String target = "baab";

        boolean correctVerdict = true;

        Leet392_Subsequence stringAnalyzer = new Leet392_Subsequence();

        boolean myResult = stringAnalyzer.isSubsequence(candidate, target);

        assertEquals(correctVerdict, myResult);
    }

    @Test
    public void emptyStrings(){
        String candidate = "";
        String target = "";

        boolean correctVerdict = true;

        Leet392_Subsequence stringAnalyzer = new Leet392_Subsequence();

        boolean myResult = stringAnalyzer.isSubsequence(candidate, target);

        assertEquals(correctVerdict, myResult);
    }

    @Test
    public void candidateIsEmpty(){
        String candidate = "";
        String target = "tre";

        boolean correctVerdict = true;

        Leet392_Subsequence stringAnalyzer = new Leet392_Subsequence();

        boolean myResult = stringAnalyzer.isSubsequence(candidate, target);

        assertEquals(correctVerdict, myResult);
    }

    @Test
    public void targetIsEmpty(){
        String candidate = "red";
        String target = "";

        boolean correctVerdict = false;

        Leet392_Subsequence stringAnalyzer = new Leet392_Subsequence();

        boolean myResult = stringAnalyzer.isSubsequence(candidate, target);

        assertEquals(correctVerdict, myResult);
    }
}