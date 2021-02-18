/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int res = 0;
        if (nums == null || nums.length == 0) {
            return res;
        }
        int max = nums[0], min = nums[0];
        res = max;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                max = Math.max(nums[i], max * nums[i]);
                min = Math.min(nums[i], min * nums[i]);
                res = Math.max(max, res);
            } else {
                int tmp = max;
                max = Math.max(nums[i], min * nums[i]);
                min = Math.min(nums[i], tmp * nums[i]);
                res = Math.max(max, res);
            }
        }
        
        return res;
    }
}
// @lc code=end

