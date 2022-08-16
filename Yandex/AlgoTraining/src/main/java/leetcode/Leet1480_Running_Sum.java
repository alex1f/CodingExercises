/*
https://leetcode.com/problems/running-sum-of-1d-array/

1480. Running Sum of 1d Array
Given an array nums.
We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
Return the running sum of nums

 */

package leetcode;

public class Leet1480_Running_Sum {

    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < result.length; i++){
            result[i] = result[i-1] + nums[i];
        }
        return result;
    }
}
