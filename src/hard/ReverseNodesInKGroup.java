package hard;

import easy.MergeTwoSortedList.ListNode;

/**
 * ReverseNodesInKGroup
 *
 * @author black
 * @date 2019-07-23
 */
public class ReverseNodesInKGroup {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ListNode node = reverseKGroup(one, 3);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int count = 1;
        ListNode current = head;
        ListNode result;
        while (current != null && count < k) {
            current = current.next;
            if (current != null) {
                count++;
            }
        }
        if (count < k) {
            return head;
        } else {
            result = current;
        }
        ListNode nextStart = current == null ? null : current.next;
        ListNode tail = head;
        ListNode prev = null;
        current = head;
        for (int i = 0; i < count; i++) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        tail.next = reverseKGroup(nextStart, k);
        return result;
    }
}
