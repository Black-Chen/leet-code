/*
 * @lc app=leetcode id=64 lang=golang
 *
 * [64] Minimum Path Sum
 */

// @lc code=start
func minPathSum(grid [][]int) int {
    for i, _ := range grid {
		for j, _ := range grid[i] {
			if i == 0 && j == 0 {
				continue
			}
			var a, b = i - 1, j - 1
			if (a < 0) {
				grid[i][j] = grid[i][b] + grid[i][j]
			} else if (b < 0) {
				grid[i][j] = grid[a][j] + grid[i][j]
			} else if (grid[a][j] > grid[i][b]) {
				grid[i][j] = grid[i][b] + grid[i][j]
			} else {
				grid[i][j] = grid[a][j] + grid[i][j]
			}
		}
	}
	return grid[len(grid) - 1][len(grid[0]) - 1]
}
// @lc code=end

