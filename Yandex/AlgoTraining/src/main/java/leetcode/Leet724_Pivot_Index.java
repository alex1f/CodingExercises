/*
https://leetcode.com/problems/find-pivot-index/

724. Find Pivot Index
Given an array of integers nums, calculate the pivot index of this array.
The pivot index is the index where the sum of all the numbers strictly to the left of the index
is equal to the sum of all the numbers strictly to the index's right.
If the index is on the left edge of the array, then the left sum is 0
because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.
*/

package leetcode;

import java.util.Arrays;

public class Leet724_Pivot_Index {
    public int pivotIndex(int[] nums) {
        //skipping first element due to the "strictly to the left/right" condition
        int rightSum = Arrays.stream(nums).skip(1).sum();

        int leftSum = 0;

        int lastIndex = nums.length-1;

        for (int i = 0; i < nums.length; i++){
            if (leftSum == rightSum){
                return i;
            }

            leftSum += nums[i];
            if (i < lastIndex) {
                rightSum -= nums[i+1];
            } else {
                rightSum = 0;
            }
        }
        return -1;
    }
}
