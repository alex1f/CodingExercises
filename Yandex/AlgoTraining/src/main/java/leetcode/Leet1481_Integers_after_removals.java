/*
https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/

1481. Least Number of Unique Integers after K Removals
Given an array of integers arr and an integer k.
Find the least number of unique integers after removing exactly k elements.
 */

package leetcode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Leet1481_Integers_after_removals {
    public int findLeastNumOfUniqueInts(int[] input, int k) {
        Map<Integer, Integer> numberFrequencies = Arrays.stream(input)
                        .boxed()
                        .collect(Collectors.groupingBy(
                                        Function.identity(),
                                        Collectors.summingInt(i -> 1)));


        Map<Integer, Integer> sortedMap = numberFrequencies.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    int possibleRemovals = 0;
    for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()){
        k -= entry.getValue();
        if (k >= 0){
            possibleRemovals++;
        }

    }
        return sortedMap.size() - possibleRemovals;

    }
}
