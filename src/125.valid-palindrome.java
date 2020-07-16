import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        boolean result = true;
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char start = s.charAt(i);
            char end = s.charAt(j);
            if ((start < 'a' || start > 'z') && (start < '0' || start > '9')) {
                i++;
                continue;
            }
            if ((end < 'a' || end > 'z') && (end < '0' || end > '9')) {
                j--;
                continue;
            }
            if (start != end) {
                result = false;
                break;
            }
            i++;
            j--;
        }
        return result;
    }
}
// @lc code=end

