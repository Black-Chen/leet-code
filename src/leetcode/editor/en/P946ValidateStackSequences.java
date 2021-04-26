//Given two sequences pushed and popped with distinct values, return true if and
// only if this could have been the result of a sequence of push and pop operation
//s on an initially empty stack. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//Output: true
//Explanation: We might do the following sequence:
//push(1), push(2), push(3), push(4), pop() -> 4,
//push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
// 
//
// 
// Example 2: 
//
// 
//Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//Output: false
//Explanation: 1 cannot be popped before 2.
// 
// 
// 
//
// 
// Constraints: 
//
// 
// 0 <= pushed.length == popped.length <= 1000 
// 0 <= pushed[i], popped[i] < 1000 
// pushed is a permutation of popped. 
// pushed and popped have distinct values. 
// 
// Related Topics Stack 
// 👍 1605 👎 35

package leetcode.editor.en;

import java.util.Queue;
import java.util.Stack;

//java:Validate Stack Sequences
public class P946ValidateStackSequences{
    public static void main(String[] args){
        Solution solution = new P946ValidateStackSequences().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null && popped == null) {
            return true;
        }
        if (pushed == null && popped != null) {
            return false;
        }
        if (popped == null && pushed != null) {
            return false;
        }
        if (popped.length != pushed.length) {
            return false;
        }
        Stack<Integer> cache = new Stack<>();
        boolean res = true;
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            if (pushed[i] != popped[j]) {
                cache.push(pushed[i]);
            } else {
                j++;
                while (!cache.isEmpty() && j < popped.length) {
                    if (cache.peek() != popped[j]) {
                        break;
                    }
                    j++;
                    cache.pop();
                }
            }
        }
        while (!cache.isEmpty() && j < popped.length) {
            if (cache.pop() != popped[j]) {
                return false;
            }
            j++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}