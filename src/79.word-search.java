import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {

    public static boolean exist(char[][] board, String word) {
        boolean result = false;
        char[] target = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == target[0]) {
                    if (target.length == 1) {
                        return true;
                    }
                    List<String> route = new ArrayList<>();
                    route.add(i + "_" + j);
                    result = findChar(board, target, 1, route, i, j);
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return result;
    }

    private static boolean findChar(char[][] board, char[] target, int depth, List<String> route, int row, int column) {
        boolean result = false;
        int t = row - 1, b = row + 1, l = column - 1, r = column + 1;
        if (t >= 0) {
            result = getIt(board, target, depth, route, t, column);
        }
        if (!result && b <= board.length - 1) {
            result = getIt(board, target, depth, route, b, column);
        }
        if (!result && l >= 0) {
            result = getIt(board, target, depth, route, row, l);
        }
        if (!result && r <= board[0].length - 1) {
            result = getIt(board, target, depth, route, row, r);
        }
        return result;
    }

    private static boolean getIt(char[][] board, char[] target, int depth, List<String> route, int row, int column) {
        String path = row + "_" + column;
        List<String> localRoute = new ArrayList<>(route);
        if (!route.contains(path) && board[row][column] == target[depth]) {
            localRoute.add(path);
            if (depth == target.length - 1) {
                return true;
            } else {
                return findChar(board, target, depth + 1, localRoute, row, column);
            }
        } else {
            return false;
        }
    }
}
// @lc code=end

