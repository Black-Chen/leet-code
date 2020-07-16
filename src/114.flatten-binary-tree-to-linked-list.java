import easy.IsSameTree.TreeNode;

/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
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
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        getLastNode(root);
    }

    public TreeNode getLastNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode lastNode = getLastNode(root.left);
        TreeNode right = root.right;
        if (lastNode != null) {
            root.right = root.left;
        } else {
            lastNode = root;
        }
        root.left = null;
        TreeNode rightLast = getLastNode(right);
        if (rightLast != null) {
            lastNode.right = right;
            lastNode.left = null;
            return rightLast;
        }
        return lastNode;
    }
}
// @lc code=end

