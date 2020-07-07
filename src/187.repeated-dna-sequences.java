import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode id=187 lang=java
 *
 * [187] Repeated DNA Sequences
 */

// @lc code=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        HashSet<String> subs = new HashSet<>();
        if (s == null) {
            return result;
        }
        for (int start = 0, end = start + 10; end <= s.length(); start++, end++) {
            String sub = s.substring(start, end);
            if (subs.contains(sub) && !result.contains(sub)) {
                result.add(sub);
            } else {
                subs.add(sub);
            }
        }
        return result;
    }
}
// @lc code=end

