/*
 * @lc app=leetcode id=80 lang=golang
 *
 * [80] Remove Duplicates from Sorted Array II
 */

// @lc code=start
func removeDuplicates(nums []int) int {
    if len(nums) == 0 {
		return 0
	}
	standPointer := 0
	for startPointer, endPointer := 0, 0; endPointer < len(nums); endPointer++ {
		if nums[endPointer] != nums[startPointer] {
			if endPointer - startPointer >= 2 {
				nums[standPointer] = nums[startPointer]
				standPointer++
			}
			nums[standPointer] = nums[startPointer]
			standPointer++
			startPointer = endPointer
		}
		if endPointer == len(nums) - 1 {
			if nums[endPointer] == nums[startPointer] {
				if endPointer - startPointer >= 1 {
					nums[standPointer] = nums[endPointer]
					standPointer++
				}
				nums[standPointer] = nums[endPointer]
				standPointer++
			}
		}
	}
	return standPointer
}
// @lc code=end

