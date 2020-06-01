/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int i = 0;
        int count = 0, target = n * n;
        while (count < target) {
            for (i = l; i <= r; i++) {
                matrix[t][i] = ++count;
            }
            t++;
            for (i = t; i <= b; i++) {
                matrix[i][r] = ++count;
            }
            r--;
            for (i = r; i >= l; i--) {
                matrix[b][i] = ++count;
            }
            b--;
            for (i = b; i >= t; i--) {
                matrix[i][l] = ++count;
            }
            l++;
        }
        return matrix;
    }
}
// @lc code=end

