import java.util.HashMap;

/*
 * @lc app=leetcode id=532 lang=java
 *
 * [532] K-diff Pairs in an Array
 */

// @lc code=start
class Solution {
    public int findPairs(int[] nums, int k) {
        int res = 0;
        if (nums == null || nums.length == 0) {
            return res;
        }
        HashMap<Integer, Integer> numMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(nums[i])) {
                numMap.put(nums[i], numMap.get(nums[i]) + 1);
            } else {
                numMap.put(nums[i], 1);
            }
        }
        if (k == 0) {
            for (Integer times : numMap.values()) {
                if (times > 1) {
                    res += 1;
                }
            }
        } else {
            for (int i = 0; i < nums.length - 1; i++) {
                if (numMap.containsKey(nums[i])) {
                    int valMinus = nums[i] - k;
                    int valPlus = nums[i] + k;
                    if (numMap.containsKey(valMinus)) {
                        res++;
                    }
                    if (numMap.containsKey(valPlus)) {
                        res++;
                    }
                    numMap.remove(nums[i]);
                }
            }
        }
        return res;
    }
}
// @lc code=end

