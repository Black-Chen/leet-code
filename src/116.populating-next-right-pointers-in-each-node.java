import org.graalvm.compiler.graph.Node;

/*
 * @lc app=leetcode id=116 lang=java
 *
 * [116] Populating Next Right Pointers in Each Node
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
        Node[] levelNodes = new Node[12];
        int depth = 0;
        connectByLevel(root, depth, levelNodes);
        return root;
    }

    private void connectByLevel(Node root, int depth, Node[] levelNodes) {
        if (root == null) {
            return;
        }
        Node lastNode = levelNodes[depth];
        if (lastNode != null) {
            lastNode.next = root;
        }
        levelNodes[depth] = root;
        connectByLevel(root.left, depth + 1, levelNodes);
        connectByLevel(root.right, depth + 1, levelNodes);
    }
}
// @lc code=end

