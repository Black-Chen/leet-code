/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        } else if (matrix[0].length == 0) {
            return false;
        }
        int[] subMatrix = searchSub(matrix, target, 0, matrix.length - 1);
        if (subMatrix == null) {
            return false;
        } else {
            return exists(subMatrix, target, 0, subMatrix.length - 1);
        }
    }

    private int[] searchSub(int[][] matrix, int target, int i, int j) {
        if (j - i <= 1) {
            if (matrix[j][0] <= target) {
                return matrix[j];
            } else {
                if (matrix[i][0] > target) {
                    return null;
                } else {
                    return matrix[i];
                }
            }
        } else {
            int mid = (i + j) / 2;
            if (matrix[mid][0] > target) {
                return searchSub(matrix, target, i, mid);
            } else {
                return searchSub(matrix, target, mid, j);
            }
        }
    }

    private boolean exists(int[] subMatrix, int target, int i, int j) {
        if (j - i <= 1) {
            return subMatrix[i] == target || subMatrix[j] == target;
        } else {
            int mid = (i + j) / 2;
            if (subMatrix[mid] > target) {
                return exists(subMatrix, target, i, mid);
            }
            return exists(subMatrix, target, mid, j);
        }
    }
}
// @lc code=end

