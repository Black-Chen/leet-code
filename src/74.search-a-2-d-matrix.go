/*
 * @lc app=leetcode id=74 lang=golang
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
func searchMatrix(matrix [][]int, target int) bool {
	var result = false
	if len(matrix) == 0 {
		return result
	} else if len(matrix[0]) == 0 {
		return result
	}
	subMatrix := searchByHalf(matrix, target, 0, len(matrix) - 1)
	if subMatrix != nil {
		result = exists(subMatrix, target, 0, len(subMatrix) - 1)
	} else {
		result = false
	}
	return result
}

func searchByHalf(matrix [][]int, target int, left int, right int) []int {
	if right - left <= 1 {
		if matrix[right][0] <= target {
			return matrix[right]
		} else {
			if matrix[left][0] > target {
				return nil
			}
			return matrix[left]
		}
	} else {
		mid := (left + right) / 2
		if matrix[mid][0] > target {
			return searchByHalf(matrix, target, left, mid)
		} else {
			return searchByHalf(matrix, target, mid, right)
		}
	}
}

func exists(subMatrix []int, target int, left int, right int) bool {
	if right - left <= 1 {
		return subMatrix[left] == target || subMatrix[right] == target
	} else {
		mid := (left + right) / 2
		if subMatrix[mid] > target {
			return exists(subMatrix, target, left, mid)
		} else {
			return exists(subMatrix, target, mid, right)
		}
	}
}
// @lc code=end

