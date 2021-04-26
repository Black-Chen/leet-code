/*
 * @lc app=leetcode id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean result = false;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int rows = 0;
        int columns = matrix[0].length - 1;
        while (rows < matrix.length && columns >= 0) {
            if (matrix[rows][columns] > target) {
                columns--;
            } else if (matrix[rows][columns] < target) {
                rows++;
            } else {
                result = true;
                break;
            }
        }
        return result;
    }
}
// @lc code=end

