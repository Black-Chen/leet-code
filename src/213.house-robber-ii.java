/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(maxRob(nums, 0, nums.length - 1),
        maxRob(nums, 1, nums.length));
    }

    private int maxRob(int[] nums, int start, int end) {
        int dp0 = 0;
        int dp1 = 0;
        int result = 0;
        for (int i = start; i < end; i++) {
            result = dp0 + nums[i];
            result = Math.max(dp1, result);
            dp0 = dp1;
            dp1 = result;
        }
        return result;
    }
}
// @lc code=end

