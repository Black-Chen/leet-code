package easy;

/**
 * MaximumDepthOfBinaryTree
 *
 * @author black
 * @date 2019/6/5
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {

    }

    public static int maxDepth(SymmetricTree.TreeNode root) {
        if (root == null) {
            return 0;
        }
        return calculateDepth(root, 1);
    }

    public static int calculateDepth(SymmetricTree.TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        int leftDepth = node.left == null ? depth : calculateDepth(node.left, depth + 1);
        int rightDepth = node.right == null ? depth : calculateDepth(node.right, depth + 1);
        return Math.max(leftDepth, rightDepth);
    }
}
