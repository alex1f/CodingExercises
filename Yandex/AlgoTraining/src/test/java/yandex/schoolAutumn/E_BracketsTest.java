package yandex.schoolAutumn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class E_BracketsTest {

    @Test
    public void defaultData1(){
        String input = "a + b = b + a";

        int correctAnswer = -1;

        int myAnswer = E_Brackets.analyzeBrackets(input);

        assertEquals(correctAnswer, myAnswer);
    }

    @Test
    public void defaultData2(){
        String input = "d + {a + {b + c} = {a + b + } c + d";

        int correctAnswer = 5;

        int myAnswer = E_Brackets.analyzeBrackets(input);

        assertEquals(correctAnswer, myAnswer);
    }

    @Test
    public void defaultData3(){
        String input = "{a{{b + c} = ab + bc";

        int correctAnswer = -1;

        int myAnswer = E_Brackets.analyzeBrackets(input);

        assertEquals(correctAnswer, myAnswer);
    }

    @Test
    public void onlyOneBracketLeft(){
        String input = "{a+ bc";

        int correctAnswer = 1;

        int myAnswer = E_Brackets.analyzeBrackets(input);

        assertEquals(correctAnswer, myAnswer);
    }

    @Test
    public void onlyOneBracketRight(){
        String input = "a+}bc";

        int correctAnswer = 3;

        int myAnswer = E_Brackets.analyzeBrackets(input);

        assertEquals(correctAnswer, myAnswer);
    }

    @Test
    public void oneExtraLeftBracketA(){
        String input = "{}{}{";

        int correctAnswer = 5;

        int myAnswer = E_Brackets.analyzeBrackets(input);

        assertEquals(correctAnswer, myAnswer);
    }

    @Test
    public void oneExtraLeftBracketB(){
        String input = "{}{{}";

        int correctAnswer = 3;

        int myAnswer = E_Brackets.analyzeBrackets(input);

        assertEquals(correctAnswer, myAnswer);
    }

    @Test
    public void oneExtraLeftBracketC(){
        String input = "{{}{}";

        int correctAnswer = 1;

        int myAnswer = E_Brackets.analyzeBrackets(input);

        assertEquals(correctAnswer, myAnswer);
    }

    @Test
    public void tooManyLeftBrackets(){
        String input = "{{{{}{{}";

        int correctAnswer = -1;

        int myAnswer = E_Brackets.analyzeBrackets(input);

        assertEquals(correctAnswer, myAnswer);
    }

    @Test
    public void oneExtraRightBracketA(){
        String input = "{}{}}";

        int correctAnswer = 2;

        int myAnswer = E_Brackets.analyzeBrackets(input);

        assertEquals(correctAnswer, myAnswer);
    }

    @Test
    public void oneExtraRightBracketB(){
        String input = "{}}{}";

        int correctAnswer = 2;

        int myAnswer = E_Brackets.analyzeBrackets(input);

        assertEquals(correctAnswer, myAnswer);
    }

    @Test
    public void misalignedBracketsA(){
        String input = "}{";

        int correctAnswer = -1;

        int myAnswer = E_Brackets.analyzeBrackets(input);

        assertEquals(correctAnswer, myAnswer);
    }

    @Test
    public void misalignedBracketsB(){
        String input = "}}{{";

        int correctAnswer = -1;

        int myAnswer = E_Brackets.analyzeBrackets(input);

        assertEquals(correctAnswer, myAnswer);
    }

    @Test
    public void oneExtraRightBracketC(){
        String input = "}}}{{";

        int correctAnswer = -1;

        int myAnswer = E_Brackets.analyzeBrackets(input);

        assertEquals(correctAnswer, myAnswer);
    }

    @Test
    public void oneExtraLeftBracketD(){
        String input = "}}{{{";

        int correctAnswer = -1;

        int myAnswer = E_Brackets.analyzeBrackets(input);

        assertEquals(correctAnswer, myAnswer);
    }
}