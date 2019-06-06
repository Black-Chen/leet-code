package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    public static List<List<Integer>> levelOrderBottom(IsSameTree.TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        generate(root, result, 0);
        Collections.reverse(result);

        return result;
    }

    public static void generate(IsSameTree.TreeNode node, List<List<Integer>> result, int depth) {
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
}
