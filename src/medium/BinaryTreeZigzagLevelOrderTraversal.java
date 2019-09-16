package medium;

import easy.IsSameTree.TreeNode;

import java.util.ArrayList;
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
}
