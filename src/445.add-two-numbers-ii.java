import java.util.*;


/*
 * @lc app=leetcode id=445 lang=java
 *
 * [445] Add Two Numbers II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        int ll1 = countLength(n1);
        int ll2 = countLength(n2);
        if (ll2 > ll1) {
            n1 = l2;
            n2 = l1;
            int tmp = ll1;
            ll1 = ll2;
            ll2 = tmp;
        }

        ListNode current = null;
        List<ListNode> nodes = new ArrayList<>(ll1);
        for (int i = 0; i < ll1; i++) {
            if (i + ll2 < ll1) {
                if (current == null) {
                    current = new ListNode(n1.val);
                } else {
                    current.next = new ListNode(n1.val);
                    current = current.next;
                }
            } else {
                if (current == null) {
                    current = new ListNode(n1.val + n2.val);
                } else {
                    current.next = new ListNode(n1.val + n2.val);
                    current = current.next;
                }
                n2 = n2.next;
            }
            nodes.add(current);
            n1 = n1.next;
        }

        int remaining = 0;
        for (int i = nodes.size() - 1; i >= 0; i--) {
            nodes.get(i).val = nodes.get(i).val + remaining;
            remaining = nodes.get(i).val / 10;
            nodes.get(i).val = nodes.get(i).val % 10;
        }
        current = nodes.get(0);
        if (remaining > 0) {
            current = new ListNode(remaining);
            current.next = nodes.get(0);
        }
        return current;
    }

    private int countLength(ListNode n) {
        int length = 0;
        while (n != null) {
            length++;
            n = n.next;
        }
        return length;
    }
}
// @lc code=end

