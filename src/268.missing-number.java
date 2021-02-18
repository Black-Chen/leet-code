/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        int result = 0;
        int[] exists = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            exists[nums[i]] = 1;
        }
        for (int j = 0; j < exists.length; j++) {
            if (exists[j] == 0) {
                result = j;
                break;
            }
        }
        return result;
    }
}
// @lc code=end

