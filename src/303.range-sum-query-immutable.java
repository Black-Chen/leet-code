/*
 * @lc app=leetcode id=303 lang=java
 *
 * [303] Range Sum Query - Immutable
 */

// @lc code=start
class NumArray {

    private int[] dp;

    public NumArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i - 1]; 
        }
        this.dp = dp;
    }
    
    public int sumRange(int i, int j) {
        return dp[j + 1] - dp[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
// @lc code=end

