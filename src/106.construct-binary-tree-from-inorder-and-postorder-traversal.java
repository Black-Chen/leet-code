import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length== 0) {
            return null;
        }
        Map<Integer, Integer> inorderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i ++) {
            inorderIndex.put(inorder[i], i);
        }
        return getRootNode(inorder, postorder, inorderIndex, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode getRootNode(int[] inorder, int[] postorder, Map<Integer, Integer> inorderIndex, int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) {
            return null;
        }
        int rootValue = postorder[pe];
        int index = inorderIndex.get(rootValue);
        TreeNode left = getRootNode(inorder, postorder, inorderIndex, is, index - 1, ps, ps + index - is - 1);
        TreeNode right = getRootNode(inorder, postorder, inorderIndex, index + 1, ie, ps + index - is, pe - 1);
        TreeNode root = new TreeNode(rootValue, left, right);
        return root;
    }
}
// @lc code=end

