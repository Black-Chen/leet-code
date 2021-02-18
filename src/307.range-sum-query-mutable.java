/*
 * @lc app=leetcode id=307 lang=java
 *
 * [307] Range Sum Query - Mutable
 */

// @lc code=start
class NumArray {

    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public void update(int i, int val) {
        this.nums[i] = val;
    }
    
    public int sumRange(int i, int j) {
        int result = 0;
        for (int start = i; start <= j; start++) {
            result += nums[start];
        }
        return result;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
// @lc code=end

