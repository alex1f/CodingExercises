import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HW5_D_BracketsTest {
    @Test
    public void defaultData1(){
        String input = "(())()";

        String expectedResult = "YES";

        String myResult = HW5_D_Brackets.analyzeBrackets(input);

        assertEquals(expectedResult, myResult);
    }

    @Test
    public void defaultData2(){
        String input = "(()))()";

        String expectedResult = "NO";

        String myResult = HW5_D_Brackets.analyzeBrackets(input);

        assertEquals(expectedResult, myResult);
    }

    @Test
    public void onlyLeftBrackets(){
        String input = "((((";

        String expectedResult = "NO";

        String myResult = HW5_D_Brackets.analyzeBrackets(input);

        assertEquals(expectedResult, myResult);
    }

    @Test
    public void onlyRightBrackets(){
        String input = "))))";

        String expectedResult = "NO";

        String myResult = HW5_D_Brackets.analyzeBrackets(input);

        assertEquals(expectedResult, myResult);
    }

    @Test
    public void alternatingBrackets(){
        String input = "()()()";

        String expectedResult = "YES";

        String myResult = HW5_D_Brackets.analyzeBrackets(input);

        assertEquals(expectedResult, myResult);
    }

    @Test
    public void alternatingWithLeftFirst(){
        String input = ")()()(";

        String expectedResult = "NO";

        String myResult = HW5_D_Brackets.analyzeBrackets(input);

        assertEquals(expectedResult, myResult);
    }

    @Test
    public void allRightBracketsAtTheEnd(){
        String input = "(((())))";

        String expectedResult = "YES";

        String myResult = HW5_D_Brackets.analyzeBrackets(input);

        assertEquals(expectedResult, myResult);
    }

    @Test
    public void severalNests(){
        String input = "((())()())";

        String expectedResult = "YES";

        String myResult = HW5_D_Brackets.analyzeBrackets(input);

        assertEquals(expectedResult, myResult);
    }

}