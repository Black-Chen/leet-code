package medium;

import easy.MergeTwoSortedList.ListNode;

/**
 * RemoveNthNode
 *
 * @author black
 * @date 2019-07-19
 */
public class RemoveNthNode {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
//        one.next = two;
//        two.next = three;
//        three.next = four;
//        four.next = five;

        ListNode node =  removeNthFromEnd(one, 1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        if (head == null || head.next == null) {
            return null;
        }
        int count = 0;
        int currentIndex = 0;
        ListNode prev = null;
        ListNode cur = head;
        ListNode iteratorNode = head;
        while (iteratorNode != null) {
            if (currentIndex - count == n) {
                prev = cur;
                cur = prev.next;
                count++;
            }
            iteratorNode = iteratorNode.next;
            currentIndex++;
        }
        if (prev == null) {
            return head.next;
        }
        if (cur != null) {
            prev.next = cur.next;
        }
        return head;
    }
}
