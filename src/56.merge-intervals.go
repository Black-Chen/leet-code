/*
 * @lc app=leetcode id=56 lang=golang
 *
 * [56] Merge Intervals
 */

// @lc code=start
func merge(intervals [][]int) [][]int {
	result := make([][]int, 0)
	if (len(intervals) == 0) {
		return result
	}
	// 验证了猜想，不是按序排列的
	// 还需要合并多个interval
	result = append(result, intervals[0])
	var subResult = make([][]int, 0)
	for i, v := range intervals {
		if i == 0 {
			continue
		}
		subResult = make([][]int, 0)
		for j, in := range result {
			if v[0] <= in[1] && v[1] >= in[0] {
				if v[0] < in[0] {
					in[0] = v[0]
				}
				if v[1] > in[1] {
					in[1] = v[1]
				}
				v[0] = in[0]
				v[1] = in[1]
			} else {
				subResult = append(subResult, in)
			}
			if j == len(result) - 1 {
				subResult = append(subResult, v)
			}
		}
		result = subResult
	}
	return result
}
// @lc code=end

