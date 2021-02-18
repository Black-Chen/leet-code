/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] results = new int[nums.length];
        int right = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                results[i] = 1;
            } else {
                results[i] = nums[i - 1] * results[i - 1]; 
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            results[i] = results[i] * right;
            right = right * nums[i];
        }
        return results;
    }
}
// @lc code=end

