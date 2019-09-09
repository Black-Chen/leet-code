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
}
