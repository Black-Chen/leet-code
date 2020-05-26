/*
 * @lc app=leetcode id=62 lang=golang
 *
 * [62] Unique Paths
 */

// @lc code=start
func uniquePaths(m int, n int) int {
	matrix := make([][]int, m)
	for k := 0; k < m; k++ {
		matrix[k] = make([]int, n)
	}
	matrix[0][0] = 0
	for i, v := range matrix {
		for j, _ := range v {
			if i == 0 && j == 0 {
				matrix[i][j] = 1
				continue
			}
			var a, b = i - 1, j;
			var c, d = i, j - 1;
			if a < 0 {
				a = 0
			}
			if d < 0 {
				d = 0
			}
			matrix[i][j] = matrix[a][b] + matrix[c][d]
		}
	}
	return matrix[m - 1][n - 1]
}
// @lc code=end

