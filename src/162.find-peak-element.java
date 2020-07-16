/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        for (int i = 0, j = i + 1, k = i - 1; i < nums.length; i++,j++,k++) {
            if (isIndexLargerThan(i, j, nums) && isIndexLargerThan(i, k, nums)) {
                return i;
            }
        }
        return 0;
    }

    private boolean isIndexLargerThan(int index, int target, int[] nums) {
        if (target < 0 || target == nums.length) {
            return true;
        }
        return nums[index] > nums[target];
    }
}
// @lc code=end

