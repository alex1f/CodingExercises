/*https://leetcode.com/problems/binary-search/

704. Binary Search

Given an array of integers nums which is sorted in ascending order,
and an integer target, write a function to search target in nums.
If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.
*/


package leetcode;

public class Leet704_Binary_Search {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int middle = (right-left) / 2;

        while (true){
            int currentNUmber = nums[middle];

            if (currentNUmber == target){
                return middle;
            } else if (currentNUmber < target){
                left = middle + 1;
            } else {
                right = middle-1;
            }
            middle = left + (right - left) / 2;

            if (left > right) {
                return -1;
            }
        }
    }
}
