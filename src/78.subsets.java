import java.util.*;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        for (int i = 0; i <= nums.length; i++) {
            getResult(nums, i, 0, result, new ArrayList<>());
        }
        return result;
    }

    private void getResult(int[] nums, int step, int index, List<List<Integer>> result, List<Integer> set) {
        if (step == 0) {  
            result.add(new ArrayList<>(set));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            set.add(nums[i]);
            getResult(nums, step - 1, i + 1, result, set);
            set.remove(set.size() - 1);
        }
    }
}
// @lc code=end

