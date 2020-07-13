/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] results = new int[s.length() + 1];
        results[s.length()] = 1;
        results[s.length() - 1] = chars[s.length() - 1] == '0' ? 0 : 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (chars[i] == '0') {
                results[i] = 0;
            } else if ((chars[i] - '0') * 10 + (chars[i + 1] - '0') < 27) {
                results[i] = results[i + 1] + results[i + 2];
            } else {
                results[i] = results[i + 1];
            }
        }
        return results[0];
    }
}
// @lc code=end

