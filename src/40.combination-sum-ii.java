import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        getResult(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    private void getResult(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> set) {
        if (target == 0) {
            result.add(new ArrayList<>(set));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            set.add(candidates[i]);
            getResult(candidates, target - candidates[i], i + 1, result, set);
            set.remove(set.size() - 1);
        }
    }
}
// @lc code=end

