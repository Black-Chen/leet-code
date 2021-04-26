/*
 * @lc app=leetcode id=443 lang=java
 *
 * [443] String Compression
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {
        int res = 0;
        if (chars == null || chars.length == 0) {
            return res;
        }
        int stepedIndex = 0;
        char current = chars[stepedIndex];
        res = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != current) {
                int minus = i - stepedIndex;
                if (minus > 1) {
                    String str = String.valueOf(minus);
                    for (int j = 0; j < str.length(); j++) {
                        chars[res] = str.charAt(j);
                        res++;
                    }
                }
                stepedIndex = i;
                current = chars[stepedIndex];
                chars[res] = current;
                res++;
            } else if (i == chars.length - 1) {
                int minus = i - stepedIndex + 1;
                if (minus > 1) {
                    String str = String.valueOf(minus);
                    for (int j = 0; j < str.length(); j++) {
                        chars[res] = str.charAt(j);
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end

