import java.util.Arrays;

/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int m = 1; m <= amount; m++) {
            int minValue = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                if (m - coins[i] >= 0) {
                    if (dp[m - coins[i]] == Integer.MAX_VALUE) {
                        continue;
                    }
                    minValue = Math.min(minValue, dp[m - coins[i]] + 1);
                }
            }
            dp[m] = minValue;
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }
}
// @lc code=end

