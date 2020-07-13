/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < result) {
                result = nums[i];
                break;
            }
        }
        return result;
    }
}
// @lc code=end

