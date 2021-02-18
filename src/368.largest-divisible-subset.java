import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=368 lang=java
 *
 * [368] Largest Divisible Subset
 */

// @lc code=start
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> dp = new ArrayList<>();
        List<Integer> dp0 = new ArrayList<>();
        dp0.add(nums[0]);
        dp.add(dp0);
        List<Integer> res = dp0;
        for (int i = 1; i < nums.length; i++) {
            List<Integer> dpi = new ArrayList<>();
            dpi.add(nums[i]);
            int index = -1;
            int size = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    int dpSize = dp.get(j).size();
                    if (dpSize > size) {
                        size = dpSize;
                        index = j;
                    }
                }
            }
            if (index > -1) {
                dpi.addAll(dp.get(index));
            }
            if (dpi.size() > 1 && dpi.size() > res.size()) {
                res = dpi;
            }
            dp.add(dpi);
        }
        return res;
    }
}
// @lc code=end

