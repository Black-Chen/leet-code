/*
 * @lc app=leetcode id=304 lang=java
 *
 * [304] Range Sum Query 2D - Immutable
 */

// @lc code=start
class NumMatrix {

    private int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        int tmp = 0;
        if (row2 < row1) {
            tmp = row1;
            row1 = row2;
            row2 = tmp;
        }
        if (col2 < col1) {
            tmp = col1;
            col1 = col2;
            col2 = tmp;
        }
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                res += matrix[i][j];
            }
        }
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

