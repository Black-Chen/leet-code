import easy.MergeTwoSortedList.ListNode;

/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        boolean result = false;
        if (head == null) {
            return result;
        }
        ListNode step1 = head;
        ListNode step2 = head.next;
        while (step1 != null && step2 != null) {
            if (step1 == step2) {
                result = true;
                break;
            }
            step1 = step1.next;
            if (step2.next != null) {
                step2 = step2.next.next;
            } else {
                break;
            }
        }
        return result;
    }
}
// @lc code=end

