/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int[] result = new int[] {0};
        if (grid.length > 0) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '1') {
                        result[0]++;
                        dfs(grid, i, j);
                    }    
                }
            }
        }
        return result[0];
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i > grid.length - 1 || j > grid[0].length - 1 || i < 0 || j < 0) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid, i, j - 1);
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j + 1);
        }
    }
}
// @lc code=end

