package medium;

import easy.IsSameTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * BinaryTreeLevelOrderTraversal
 *
 * @author black
 * @date 2019-09-09
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root != null) {
            List<TreeNode> lastNode = new ArrayList<>();
            List<TreeNode> currentNode = new ArrayList<>();
            List<Integer> lastList;
            lastNode.add(root);
            while (!lastNode.isEmpty()) {
                lastList = new ArrayList<>();
                for (TreeNode last : lastNode) {
                    lastList.add(last.val);
                    if (last.left != null) {
                        currentNode.add(last.left);
                    }
                    if (last.right != null) {
                        currentNode.add(last.right);
                    }
                }
                lists.add(lastList);
                lastNode = currentNode;
                currentNode = new ArrayList<>();
            }
        }
        return lists;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs(root, 0, lists);
        return lists;
    }

    private void dfs(TreeNode root, int depth, List<List<Integer>> lists) {
        if (root == null) {
            return;
        }
        if (depth == lists.size()) {
            lists.add(new ArrayList<Integer>());
        }
        lists.get(depth).add(root.val);
        dfs(root.left, depth + 1, lists);
        dfs(root.right, depth + 1, lists);
    }
}
