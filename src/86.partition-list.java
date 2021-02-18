import easy.MergeTwoSortedList.ListNode;

/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
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
    public ListNode partition(ListNode head, int x) {
        ListNode current = head;
        ListNode last = null;
        ListNode lastMin = null;
        while (current != null) {
            if (current.val < x) {
                if (lastMin == null) {
                    if (last != null) {
                        last.next = current.next;
                        current.next = head;
                        head = current;
                    }
                    lastMin = current;
                } else {
                    last.next = current.next;
                    current.next = lastMin.next;
                    lastMin.next = current;
                    lastMin = current;
                }
            }
            last = current;
            current = current.next;
        }

        return head;
    }
}
// @lc code=end

