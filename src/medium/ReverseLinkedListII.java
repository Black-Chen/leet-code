package medium;

import easy.MergeTwoSortedList.ListNode;
import javafx.util.Pair;

/**
 * ReverseLinkedListII
 *
 * @author black
 * @date 2019-09-06
 */
public class ReverseLinkedListII {

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

        ListNode node = reverseBetween(one, 1, 5);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode last = null;
        ListNode next = null;
        ListNode subStart = null;
        ListNode result = head;
        if (m == n) {
            return head;
        }
        int count = 1;
        while (head != null) {
            if (count >=m && count <= n) {
                next = head.next;
                if (count == m) {
                    subStart = head;
                }
                if (count == n) {
                    head.next = null;
                    ListNode[] pair = reverseList(subStart);
                    if (last == null) {
                        result = pair[0];
                    } else {
                        last.next = pair[0];
                    }
                    pair[1].next = next;
                    break;
                }
            } else {
                last = head;
            }
            head = head.next;
            count++;
        }
        return result;
    }

    private static ListNode[] reverseList(ListNode head) {
        ListNode tail = head;
        ListNode result = null;
        ListNode swap = null;
        ListNode last = null;
        while (head != null) {
            if (head.next == null) {
                result = head;
            }
            swap = head.next;
            head.next = last;
            last = head;
            head = swap;
        }
        return new ListNode[]{result, tail};
    }
}
