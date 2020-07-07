/*
 * @lc app=leetcode id=430 lang=java
 *
 * [430] Flatten a Multilevel Doubly Linked List
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        subNode(head);
        return head;
    }

    private Node subNode(Node head) {
        Node current = head;
        while (current != null) {
            if (current.child != null) {
                Node tail = subNode(current.child);
                tail.next = current.next;
                if (current.next != null) {
                    current.next.prev = tail;    
                }
                current.child.prev = current;
                current.next = current.child;
                current.child = null;
                current = tail;
            }
            if (current.next != null) {
                current = current.next;
            } else {
                break;
            }
        }
        return current;
    }
}
// @lc code=end

