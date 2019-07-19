package medium;

import easy.MergeTwoSortedList.ListNode;

/**
 * SwapNodeInPairs
 *
 * @author black
 * @date 2019-07-19
 */
public class SwapNodeInPairs {

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

        ListNode node =  swapPairs(one);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode swap = null;
        ListNode nextStart = head.next.next;
        swap = head;
        head = head.next;
        head.next = swap;
        swap.next = swapPairs(nextStart);

        return head;
    }
}
