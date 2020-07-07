import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */

// @lc code=start
class Solution {

    public String largestNumber(int[] nums) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                StringBuilder builder1 = new StringBuilder().append(o1).append(o2);
                StringBuilder builder2 = new StringBuilder().append(o2).append(o1);
                return builder2.compareTo(builder1);
            }
        };
        List<String> numStr = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            numStr.add(String.valueOf(nums[i]));
        }

        numStr.sort(comparator);

        if (numStr.get(0).startsWith("0")) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        for (String str : numStr) {
            builder.append(str);
        }
        return builder.toString();
    }
}
// @lc code=end

