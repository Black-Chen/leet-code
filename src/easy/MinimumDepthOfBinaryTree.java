package easy;


/**
 * MinimumDepthOfBinaryTree
 *
 * @author black
 * @date 2019/6/6
 */
public class MinimumDepthOfBinaryTree {

    public static void main(String[] args) {


        IsSameTree.TreeNode a = new IsSameTree.TreeNode(3);
        IsSameTree.TreeNode b = new IsSameTree.TreeNode(9);
        IsSameTree.TreeNode c = new IsSameTree.TreeNode(20);
        IsSameTree.TreeNode d = new IsSameTree.TreeNode(15);
        IsSameTree.TreeNode e = new IsSameTree.TreeNode(7);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        System.out.println(minDepth(a));
    }

    public static int minDepth(IsSameTree.TreeNode root) {
        return findMinDepth(root, 0);
    }

    public static int findMinDepth(IsSameTree.TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        depth++;
        int leftDepth;
        int rightDepth;
        if (node.left == null && node.right == null) {
            return depth;
        } else {
            if (node.left == null) {
                return findMinDepth(node.right, depth);
            }
            if (node.right == null) {
                return findMinDepth(node.left, depth);
            }
            leftDepth = findMinDepth(node.left, depth);
            rightDepth = findMinDepth(node.right, depth);
        }
        return Math.min(leftDepth, rightDepth);
    }
}
