import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
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
    public ListNode rotateRight(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        if (list.size() == 0) {
            return head;
        }
        int reminder = k % list.size();
        if (reminder > 0) {
            list.get(list.size() - 1 - reminder).next = null;
            list.get(list.size() - 1).next = list.get(0);
            return list.get(list.size() - reminder);
        } else {
            return list.get(0);
        }
    }
}
// @lc code=end

