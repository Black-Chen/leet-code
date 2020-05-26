/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    matrix[i][j] = 1;
                    continue;
                }
                int a = i - 1 < 0 ? 0 : i - 1;
                int b = j - 1 < 0 ? 0 : j - 1;
                matrix[i][j] = matrix[a][j] + matrix[i][b];
            }
        }
        return matrix[m - 1][n - 1];
    }
}
// @lc code=end

