import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import easy.IsSameTree.TreeNode;

/*
 * @lc app=leetcode id=173 lang=java
 *
 * [173] Binary Search Tree Iterator
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

    private List<Integer> values;
    private Iterator<Integer> iterator;

    public BSTIterator(TreeNode root) {
        values = new ArrayList<>();
        inOrderTraversal(root);
        iterator = values.iterator();
    }
    
    /** @return the next smallest number */
    public int next() {
        return iterator.next();
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return iterator.hasNext();
    }

    private void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            values.add(root.val);
            inOrderTraversal(root.right);
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

