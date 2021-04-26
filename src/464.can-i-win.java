/*
 * @lc app=leetcode id=464 lang=java
 *
 * [464] Can I Win
 */

// @lc code=start
class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        boolean res = false;
        if (desiredTotal <= maxChoosableInteger) {
            return true;
        }
        for (int i = 1; i < maxChoosableInteger; i++) {
            int target = i + maxChoosableInteger;
            if (target < desiredTotal) {
                int remain = desiredTotal % target;
                if (remain == 0 || remain > maxChoosableInteger) {
                    res = false;
                    break;
                } else {
                    res = true;
                }
            }
        }
        return res;
    }
}
// @lc code=end

