/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        boolean result = false;
        int[] stept = new int[nums.length];
        stept[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            if (stept[i] != 1) {
                break;
            }
            for (int j = i + nums[i]; j > i; j--) {
                if (j >= stept.length - 1) {
                    stept[stept.length - 1] = 1;
                    break;
                }
                if (stept[j] == 1) {
                    break;
                }
                stept[j] = 1;
            }
            if (stept[stept.length - 1] == 1) {
                result = true;
                break;
            }
        }
        return result;
    }
}
// @lc code=end

