import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.HashMap;

/*
 * @lc app=leetcode id=436 lang=java
 *
 * [436] Find Right Interval
 */

// @lc code=start
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[] res = new int[intervals.length];
        if (intervals.length == 1) {
            res[0] = -1;
            return res;
        }
        ArrayList<Integer> starts = new ArrayList<>();
        HashMap<Integer, Integer> startIndexMap = new HashMap();
        for (int i = 0; i < intervals.length; i++) {
            starts.add(intervals[i][0]);
            startIndexMap.put(intervals[i][0], i);
        }
        starts.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        int maxStarts = starts.get(intervals.length - 1);
        for (int i = 0; i < intervals.length; i++) {
            int end = intervals[i][1];
            if (end <= maxStarts) {
                int targetIndex = binarySearch(starts, 0, intervals.length - 1, end);
                res[i] = startIndexMap.get(starts.get(targetIndex));
            } else {
                res[i] = -1;
            }
        }
        return res;
    }

    private int binarySearch(List<Integer> starts, int leftIndex, int rightIndex, int target) {
        if (leftIndex >= rightIndex) {
            return leftIndex;
        }
        int mid = (leftIndex + rightIndex) / 2;
        int val = starts.get(mid);
        if (val == target) {
            return mid;
        } else if (val > target) {
            return binarySearch(starts, leftIndex, mid, target);
        } else {
            return binarySearch(starts, mid + 1, rightIndex, target);
        }
    }
}
// @lc code=end

