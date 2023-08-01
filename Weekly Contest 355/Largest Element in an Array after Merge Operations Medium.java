// You are given a 0-indexed array nums consisting of positive integers.
// You can do the following operation on the array any number of times:
// Choose an integer i such that 0 <= i < nums.length - 1 and nums[i] <= nums[i + 1]. 
// Replace the element nums[i + 1] with nums[i] + nums[i + 1] and delete the element nums[i] from the array.
// Return the value of the largest element that you can possibly obtain in the final array.

// Example 1:

// Input: nums = [2,3,7,9,3]
// Output: 21
// Explanation: We can apply the following operations on the array:
// - Choose i = 0. The resulting array will be nums = [5,7,9,3].
// - Choose i = 1. The resulting array will be nums = [5,16,3].
// - Choose i = 0. The resulting array will be nums = [21,3].
// The largest element in the final array is 21. It can be shown that we cannot obtain a larger element.

// problem link - https://leetcode.com/problems/largest-element-in-an-array-after-merge-operations/description/

class Solution {
    public long maxArrayValue(int[] nums) {
        int n = nums.length;
        long max = nums[0];
        long nums1[] = new long[n];
        for (int k = 0; k < n; k++) {
            nums1[k] = nums[k];
        }
        int i = n - 2;
        int j = n - 1;
        while (i >= 0) {
            if (nums1[i] <= nums1[j]) {
                nums1[j] = nums1[i] + nums1[j];
                nums1[i] = -1;
                i--;
            } else {
                j = i;
                i--;
            }
        }
        for (int r = 0; r < n; r++) {
            max = Math.max(nums1[r], max);
        }
        return max;
    }
}