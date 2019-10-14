package medium;

import easy.IsSameTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * BinaryTreeZigzagLevelOrderTraversal
 *
 * @author black
 * @date 2019-09-16
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {

    }



    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        boolean flag = true;
        List<TreeNode> lastNode = new ArrayList<>();
        List<TreeNode> currentNode = new ArrayList<>();
        List<Integer> node;
        if (root != null) {
            lastNode.add(root);
        }
        while (!lastNode.isEmpty()) {
            node = new ArrayList<>(lastNode.size());
            if (flag) {
                for (int i = 0; i < lastNode.size(); i++) {
                    TreeNode parent = lastNode.get(i);
                    node.add(parent.val);
                    if (parent.left != null) {
                        currentNode.add(parent.left);
                    }
                    if (parent.right != null) {
                        currentNode.add(parent.right);
                    }
                }
            } else {
                for (int i = lastNode.size() - 1; i >= 0; i--) {
                    TreeNode parent = lastNode.get(lastNode.size() - 1 - i);
                    node.add(lastNode.get(i).val);
                    if (parent.left != null) {
                        currentNode.add(parent.left);
                    }
                    if (parent.right != null) {
                        currentNode.add(parent.right);
                    }
                }
            }
            lastNode = currentNode;
            currentNode = new ArrayList<>();
            flag = !flag;
            result.add(node);
        }
        return result;
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        boolean flag = true;
        List<TreeNode> lastNode = new ArrayList<>();
        List<TreeNode> currentNode = new ArrayList<>();
        LinkedList<Integer> node;
        TreeNode parent;
        if (root != null) {
            lastNode.add(root);
        }
        while (!lastNode.isEmpty()) {
            node = new LinkedList<>();
            for (int i = 0; i < lastNode.size(); i++) {
                parent = lastNode.get(i);
                if (flag) {
                    node.add(parent.val);
                } else {
                    node.addFirst(parent.val);
                }
                if (parent.left != null) {
                    currentNode.add(parent.left);
                }
                if (parent.right != null) {
                    currentNode.add(parent.right);
                }

            }
            lastNode = currentNode;
            currentNode = new ArrayList<>();
            flag = !flag;
            result.add(node);
        }
        return result;
    }

    public List<List<Integer>> zigzagLevelOrder3(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode root, int depth, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        if (depth == result.size()) {
            result.add(new LinkedList<>());
        }

        LinkedList<Integer> list = (LinkedList<Integer>) result.get(depth);
        if ((depth & 1) == 0) {
            list.add(root.val);
        } else {
            list.addFirst(root.val);
        }

        dfs(root.left, depth + 1, result);
        dfs(root.right, depth + 1, result);
    }
}
