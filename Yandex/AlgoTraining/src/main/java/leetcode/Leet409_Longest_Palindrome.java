/*
https://leetcode.com/problems/longest-palindrome/

409. Longest Palindrome
Given a string s which consists of lowercase or uppercase letters,
return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
*/


package leetcode;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Leet409_Longest_Palindrome {
    public int longestPalindrome(String input) {
        Map<String, Long> letterFrequencies =
                Stream.of(input.split("")).
                        collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int maxPalindromeLength = 0;
        int bonusForOddCount = 0;
        for (Long count : letterFrequencies.values()){
            if (count % 2 == 0){
                maxPalindromeLength += count;
            } else {
                bonusForOddCount = 1;
                maxPalindromeLength += count - 1;
            }
        }
        return maxPalindromeLength + bonusForOddCount;
    }
}
