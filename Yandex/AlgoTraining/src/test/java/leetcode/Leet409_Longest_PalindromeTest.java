package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Leet409_Longest_PalindromeTest {

    @Test
    public void defaultData1(){
        String input = "abccccdd";

        int expectedPalindromeLength = 7;

        Leet409_Longest_Palindrome stringAnalyzer = new Leet409_Longest_Palindrome();

        int myPalindromeLength = stringAnalyzer.longestPalindrome(input);

        assertEquals(expectedPalindromeLength, myPalindromeLength);
    }

    @Test
    public void defaultData2(){
        String input = "a";

        int expectedPalindromeLength = 1;

        Leet409_Longest_Palindrome stringAnalyzer = new Leet409_Longest_Palindrome();

        int myPalindromeLength = stringAnalyzer.longestPalindrome(input);

        assertEquals(expectedPalindromeLength, myPalindromeLength);
    }

    @Test
    public void allLettersAreTheSame(){
        String input = "aaaaa";

        int expectedPalindromeLength = 5;

        Leet409_Longest_Palindrome stringAnalyzer = new Leet409_Longest_Palindrome();

        int myPalindromeLength = stringAnalyzer.longestPalindrome(input);

        assertEquals(expectedPalindromeLength, myPalindromeLength);
    }

    @Test
    public void allLettersAreDifferent(){
        String input = "abcd";

        int expectedPalindromeLength = 1;

        Leet409_Longest_Palindrome stringAnalyzer = new Leet409_Longest_Palindrome();

        int myPalindromeLength = stringAnalyzer.longestPalindrome(input);

        assertEquals(expectedPalindromeLength, myPalindromeLength);
    }

    @Test
    public void evenNumberOfEachLetter(){
        String input = "aabbcdcd";

        int expectedPalindromeLength = 8;

        Leet409_Longest_Palindrome stringAnalyzer = new Leet409_Longest_Palindrome();

        int myPalindromeLength = stringAnalyzer.longestPalindrome(input);

        assertEquals(expectedPalindromeLength, myPalindromeLength);
    }

    @Test
    public void evenNumberOfEachLetterWithUppercase(){
        String input = "aabbcDcDdd";

        int expectedPalindromeLength = 10;

        Leet409_Longest_Palindrome stringAnalyzer = new Leet409_Longest_Palindrome();

        int myPalindromeLength = stringAnalyzer.longestPalindrome(input);

        assertEquals(expectedPalindromeLength, myPalindromeLength);
    }
}