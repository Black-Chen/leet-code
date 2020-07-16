import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node iterator = head;
        HashMap<Node, Node> nodes = new HashMap();
        while (iterator != null) {
            nodes.put(iterator, new Node(iterator.val));
            iterator = iterator.next;
        }
        iterator = head;
        while (iterator != null) {
            if (iterator.next != null) {
                nodes.get(iterator).next = nodes.get(iterator.next);
            }
            if (iterator.random != null) {
                nodes.get(iterator).random = nodes.get(iterator.random);
            }
            iterator = iterator.next;
        }
        return nodes.get(head);
    }
}
// @lc code=end

