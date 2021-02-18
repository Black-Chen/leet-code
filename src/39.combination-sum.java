import java.util.*;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        Arrays.sort(candidates);
        getResult(candidates, target, 0, set, result);
        return result;
    }

    private void getResult(int[] candidates, int target, int index, List<Integer> set, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(set));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            set.add(candidates[i]);
            getResult(candidates, target - candidates[i], i, set, result);
            set.remove(set.size() - 1);
        }
    }
}
// @lc code=end

