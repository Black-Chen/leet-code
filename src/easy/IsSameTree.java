package easy;

/**
 * IsSameTree
 *
 * @author black
 * @date 2019/6/3
 */
public class IsSameTree {


    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(2);
        a.left = b;
        a.right = c;
        d.right = e;
        System.out.println(isSameTree(a, d));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        } else {
            boolean isLeftSame = isSameTree(p.left, q.left);
            if (isLeftSame) {
                return isSameTree(p.right, q.right);
            } else {
                return false;
            }
        }
    }
}
