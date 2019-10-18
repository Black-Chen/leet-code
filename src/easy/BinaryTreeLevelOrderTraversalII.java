package easy;

import java.util.*;
import easy.IsSameTree.TreeNode;

/**
 * BinaryTreeLevelOrderTraversalII
 *
 * @author black
 * @date 2019/6/6
 */
public class BinaryTreeLevelOrderTraversalII {

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
        System.out.println(levelOrderBottom(a));
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        generate(root, result, 0);
        Collections.reverse(result);

        return result;
    }

    public static void generate(TreeNode node, List<List<Integer>> result, int depth) {
        List<Integer> thisLevelList = new ArrayList<>();
        if (result.size() - 1 >= depth) {
            thisLevelList = result.get(depth);
        } else {
            result.add(thisLevelList);
        }
        thisLevelList.add(node.val);
        if (node.left != null) {
            generate(node.left, result, depth + 1);
        }
        if (node.right != null) {
            generate(node.right, result, depth + 1);
        }
    }

    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        List<List<Integer>> otherList = new ArrayList<>();
        dfs(root, (LinkedList)result, 0, otherList);
        return result;
    }

    private void dfs(TreeNode root, LinkedList<List<Integer>> result, int depth, List<List<Integer>> otherList) {
        if (root == null) {
            return;
        }
        if (depth == result.size()) {
            List<Integer> level = new ArrayList<Integer>();
            otherList.add(level);
            result.addFirst(level);
        }
        otherList.get(depth).add(root.val);
        dfs(root.left, result, depth + 1, otherList);
        dfs(root.right, result, depth + 1, otherList);
    }
}
