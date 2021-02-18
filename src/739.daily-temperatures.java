import java.util.Stack;

/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            if (stack.empty()) {
                stack.push(i);
                continue;
            }
            while (!stack.empty() && T[stack.peek()] < T[i]) {
                result[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }

        return result;
    }
}
// @lc code=end

