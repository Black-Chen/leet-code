package easy;

/**
 * SymmetricTree
 *
 * @author black
 * @date 2019/6/3
 */
public class SymmetricTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(4);
        TreeNode h = new TreeNode(3);
        a.left = b;
        a.right = c;
        b.left = e;
        b.right = f;
        c.left = g;
        c.right = h;
        System.out.println(isSymmetric(a));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return isLeftRightEquals(root.left, root.right);
    }

    public static boolean isLeftRightEquals(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        }
        boolean isLeftEquals = isLeftRightEquals(left.left, right.right);
        if (isLeftEquals) {
            boolean isRightEquals = isLeftRightEquals(left.right, right.left);
            if (isRightEquals) {
                return left.val == right.val;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
