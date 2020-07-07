import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import easy.IsSameTree.TreeNode;

/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        bfs(Arrays.asList(root), result);
        return result;
    }

    private void bfs(List<TreeNode> lastLevel, List<Integer> result) {
        if (lastLevel.size() > 0) {
            result.add(lastLevel.get(0).val);
            List<TreeNode> thisLevel = new ArrayList<>();
            for (TreeNode node : lastLevel) {
                if (node.right != null) {
                    thisLevel.add(node.right);
                }
                if (node.left != null) {
                    thisLevel.add(node.left);
                }
            }
            bfs(thisLevel, result);
        }
        
    }

    private void dfs(TreeNode root, List<Integer> result, int depth) {
        if (root == null) {
            return;
        }
        if (result.size() < depth) {
            result.add(root.val);
        }
        dfs(root.right, result, depth + 1);
        dfs(root.left, result, depth + 1);
    }
}
// @lc code=end

