/*
 * @lc app=leetcode id=165 lang=java
 *
 * [165] Compare Version Numbers
 */

// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {
        int result = 0;
        String[] versions1 = version1.split("\\.");
        String[] versions2 = version2.split("\\.");
        int length = Math.max(version1.length(), version2.length());
        for (int i = 0; i < length; i++) {
            int v1 = i >= versions1.length ? 0 : Integer.valueOf(versions1[i]);
            int v2 = i >= versions2.length ? 0 : Integer.valueOf(versions2[i]);
            if (v1 > v2) {
                result = 1;
                break;
            }
            if (v1 < v2) {
                result = -1;
                break;
            }
        }
        return result;
    }
}
// @lc code=end

