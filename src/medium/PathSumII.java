package medium;

import easy.IsSameTree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * PathSumII
 *
 * @author black
 * @date 2019-06-28
 */
public class PathSumII {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(11);
        TreeNode e = new TreeNode(13);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(2);
        TreeNode i = new TreeNode(5);
        TreeNode j = new TreeNode(1);
        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        d.left = g;
        d.right = h;
        f.left = i;
        f.right = j;

        System.out.println(new PathSumII().pathSum(new TreeNode(1), 1));
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (isLeafNode(root)) {
            if (root.val == sum) {
                List<List<Integer>> list = new ArrayList<>();
                List<Integer> index = new ArrayList<>();
                list.add(index);
                index.add(root.val);
                return list;
            } else {
                return new ArrayList<>();
            }
        }
        List<List<Integer>> result = getResult(root, sum, root.val);
        if (result != null && result.size() > 0) {
            result.forEach(Collections::reverse);
        }
        return result;
    }

    private List<List<Integer>> getResult(TreeNode node, int sum, int lastSum) {
        List<List<Integer>> left = sum(node.left, sum, lastSum);
        List<List<Integer>> right = sum(node.right, sum, lastSum);
        List<List<Integer>> result = new ArrayList<>();
        addIndex(node, left, result);
        addIndex(node, right, result);
        return result;
    }

    private List<List<Integer>> sum(TreeNode node, int sum, int lastSum) {
        if (node == null) {
            return null;
        }
        if (isLeafNode(node)) {
            if (lastSum + node.val == sum) {
                List<List<Integer>> list = new ArrayList<>();
                List<Integer> index = new ArrayList<>();
                list.add(index);
                index.add(node.val);
                return list;
            } else {
                return null;
            }
        } else {
            lastSum = node.val + lastSum;
            return getResult(node, sum, lastSum);
        }
    }

    private void addIndex(TreeNode node, List<List<Integer>> left, List<List<Integer>> result) {
        if (left != null) {
            left.forEach(list -> {
                list.add(node.val);
                result.add(list);
            });
        }
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

}
