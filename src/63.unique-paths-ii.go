/*
 * @lc app=leetcode id=63 lang=golang
 *
 * [63] Unique Paths II
 */

// @lc code=start
func uniquePathsWithObstacles(obstacleGrid [][]int) int {
	var m, n = len(obstacleGrid), len(obstacleGrid[0])
    for i, v := range obstacleGrid {
		for j, k := range v {
			if k == 1 {
				obstacleGrid[i][j] = 0
				continue
			}
			if i == 0 && j == 0 {
				obstacleGrid[i][j] = 1
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
			obstacleGrid[i][j] = obstacleGrid[a][b] + obstacleGrid[c][d]
		}
	}
	return obstacleGrid[m - 1][n - 1]
}
// @lc code=end

