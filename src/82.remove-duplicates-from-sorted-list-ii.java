import easy.MergeTwoSortedList.ListNode;

/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode c = head;
        ListNode s = null;
        ListNode l = null;
        boolean hasDuplicate = false;
        while (c != null) {
            if (c.next != null) {
                if (c.val == c.next.val) {
                    if (s == null) {
                        s = l;
                    }
                    hasDuplicate = true;
                } else {
                    if (hasDuplicate) {
                        l = s;
                        if (s == null) {
                            head = c.next;
                        } else {
                            s.next = c.next;
                            s = null;
                        }
                        hasDuplicate = false;
                    } else {
                        l = c;
                    }
                }
            }
            c = c.next;
        }
        if (hasDuplicate) {
            if (s != null) {
                s.next = null;
            } else {
                head = null;
            }
        }

        return head;
    }
}
// @lc code=end

