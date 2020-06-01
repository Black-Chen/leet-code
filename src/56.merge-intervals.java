import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if (intervals.length == 0) {
            return result.toArray(new int[][] {});
        }
        result.add(intervals[0]);
        List<int[]> subResult;
        for (int i = 1; i < intervals.length; i++) {
            subResult = new ArrayList<>();
            for (int[] value : result) {
                if (intervals[i][0] <= value[1] && intervals[i][1] >= value[0]) {
                    if (intervals[i][0] < value[0]) {
                        value[0] = intervals[i][0];
                    }
                    if (intervals[i][1] > value[1]) {
                        value[1] = intervals[i][1];
                    }
                    intervals[i] = value;
                } else {
                    subResult.add(value);
                }
            }
            subResult.add(intervals[i]);
            result = subResult;
        }

        return result.toArray(new int[][] {});
    }
}
// @lc code=end

