package easy;

import easy.IsSameTree.TreeNode;
/**
 * PathSum
 *
 * @author black
 * @date 2019/6/6
 */
public class PathSum {

    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
