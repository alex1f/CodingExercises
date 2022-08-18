/*
https://leetcode.com/problems/isomorphic-strings/

205. Isomorphic Strings
Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character
while preserving the order of characters.
No two characters may map to the same character, but a character may map to itself.
*/
package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leet205_Isomorphic_Strings {
    public boolean isIsomorphic(String original, String target) {
        Map<Character, Character> originalToTargetMap = new HashMap<>();

        for (int i = 0; i < original.length(); i++){
            char originalLetter = original.charAt(i);
            char targetLetter = target.charAt(i);

            boolean mappingIsPresent = originalToTargetMap.containsKey(originalLetter);

            boolean mappingIsPresentButWrong = mappingIsPresent
                    && !originalToTargetMap.get(originalLetter).equals(targetLetter);

            boolean mappingIsOccupied = !mappingIsPresent
                    && originalToTargetMap.containsValue(targetLetter);

            if (mappingIsPresentButWrong || mappingIsOccupied) {
                return false;
            }

            originalToTargetMap.put(originalLetter, targetLetter);
            }

        return true;
        }

    }
