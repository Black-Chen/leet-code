/*
 * @lc app=leetcode id=55 lang=golang
 *
 * [55] Jump Game
 */

// @lc code=start
func canJump(nums []int) bool {
	var stept = make([]int, len(nums))
	var flag = false
	stept[0] = 1
	for i, v := range nums {
		if stept[i] != 1 {
			break
		}
		for j := i + v; j > i; j-- {
			if j >= len(nums) - 1 {
				stept[len(nums) - 1] = 1
				break
			}
			if stept[j] == 1 {
				break
			}
			stept[j] = 1
		}
		if stept[len(nums) - 1] == 1 {
			flag = true
		}
	}
	return flag
}
// @lc code=end

