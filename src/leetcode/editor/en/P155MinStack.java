//Design a stack that supports push, pop, top, and retrieving the minimum elemen
//t in constant time. 
//
// 
// push(x) -- Push element x onto stack. 
// pop() -- Removes the element on top of the stack. 
// top() -- Get the top element. 
// getMin() -- Retrieve the minimum element in the stack. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//Output
//[null,null,null,null,-3,null,0,-2]
//
//Explanation
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin(); // return -3
//minStack.pop();
//minStack.top();    // return 0
//minStack.getMin(); // return -2
// 
//
// 
// Constraints: 
//
// 
// Methods pop, top and getMin operations will always be called on non-empty sta
//cks. 
// 
// Related Topics Stack Design 
// 👍 4676 👎 430

package leetcode.editor.en;

import java.util.Stack;

//java:Min Stack
public class P155MinStack{
    //leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    private Stack<Integer> valueStack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        valueStack = new Stack();
        minStack = new Stack();
    }
    
    public void push(int x) {
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            int min = Math.min(minStack.peek(), x);
            minStack.push(min);
        }
        valueStack.push(x);
    }
    
    public void pop() {
        valueStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return valueStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}