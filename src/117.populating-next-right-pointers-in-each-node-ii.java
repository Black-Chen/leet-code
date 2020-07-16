import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=117 lang=java
 *
 * [117] Populating Next Right Pointers in Each Node II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        List<Node> levelNodes = new ArrayList<Node>(6000);
        int depth = 0;
        connectByLevel(root, depth, levelNodes);
        return root;
    }

    private void connectByLevel(Node root, int depth, List<Node> levelNodes) {
        if (root == null) {
            return;
        }
        if (levelNodes.size() <= depth) {
            levelNodes.add(root);
        } else {
            levelNodes.get(depth).next = root;
            levelNodes.set(depth, root);
        }
        connectByLevel(root.left, depth + 1, levelNodes);
        connectByLevel(root.right, depth + 1, levelNodes);
    }
}
// @lc code=end

