/*
 * @lc app=leetcode id=59 lang=golang
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
func generateMatrix(n int) [][]int {
	var t, l, r, b = 0, 0, n - 1, n - 1
	var count, target = 0, n * n
	var i = 0
	var matrix = make([][]int, n)
	for k := 0; k < n; k++ {
		matrix[k] = make([]int, n)
	}
	for {
		for i = l; i <= r; i++ {
			count++
			matrix[t][i] = count
		}
		t++
		for i = t; i <= b; i++ {
			count++
			matrix[i][r] = count
		}
		r--
		for i = r; i >= l; i-- {
			count++
			matrix[b][i] = count
		}
		b--
		for i = b; i >= t; i-- {
			count++
			matrix[i][l] = count
		}
		l++
		if count >= target {
			break
		}
	}
	return matrix
}
// @lc code=end

