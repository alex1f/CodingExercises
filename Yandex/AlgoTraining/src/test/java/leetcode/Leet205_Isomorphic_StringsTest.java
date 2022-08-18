package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Leet205_Isomorphic_StringsTest {

    @Test
    public void defaultData1(){
        String original = "egg";
        String target = "add";

        boolean correctVerdict = true;

        Leet205_Isomorphic_Strings stringAnalyzer = new Leet205_Isomorphic_Strings();

        boolean myResult = stringAnalyzer.isIsomorphic(original, target);

        assertEquals(correctVerdict, myResult);
    }

    @Test
    public void defaultData2(){
        String original = "foo";
        String target = "bar";

        boolean correctVerdict = false;

        Leet205_Isomorphic_Strings stringAnalyzer = new Leet205_Isomorphic_Strings();

        boolean myResult = stringAnalyzer.isIsomorphic(original, target);

        assertEquals(correctVerdict, myResult);
    }

    @Test
    public void defaultData3(){
        String original = "paper";
        String target = "title";

        boolean correctVerdict = true;

        Leet205_Isomorphic_Strings stringAnalyzer = new Leet205_Isomorphic_Strings();

        boolean myResult = stringAnalyzer.isIsomorphic(original, target);

        assertEquals(correctVerdict, myResult);
    }

    @Test
    public void myNotIsomorphic(){
        String original = "aba";
        String target = "cde";

        boolean correctVerdict = false;

        Leet205_Isomorphic_Strings stringAnalyzer = new Leet205_Isomorphic_Strings();

        boolean myResult = stringAnalyzer.isIsomorphic(original, target);

        assertEquals(correctVerdict, myResult);
    }

}