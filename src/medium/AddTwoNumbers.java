package medium;

import easy.MergeTwoSortedList.ListNode;

/**
 * AddTwoNumbers
 *
 * @author black
 * @date 2019/6/20
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(4);

        node.next = node1;
        node1.next = node2;

        node3.next = node4;
        node4.next = node5;

        System.out.println(addTwoNumbers(node, node3));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean isLtTen = false;
        int val = 0;
        ListNode node = new ListNode();
        ListNode lastNode;
        if (l1 != null || l2 != null) {
            if (l1 != null) {
                val += l1.val;
            }
            if (l2 != null) {
                val += l2.val;
            }
            if (val >= 10) {
                node.val = val - 10;
                isLtTen = true;
            }
            lastNode = node;
        } else {
            return node;
        }
        l1 = getCurrentNode(l1);
        l2 = getCurrentNode(l2);
        while (l1 != null || l2 != null) {
            isLtTen = calcNodeVal(l1, l2, lastNode, isLtTen);
            l1 = getCurrentNode(l1);
            l2 = getCurrentNode(l2);
            lastNode = lastNode.next;
        }
        if (isLtTen) {
            lastNode.next = new ListNode(1);
        }
        return node;
    }

    private static ListNode getCurrentNode(ListNode node) {
        return node != null ? node.next : null;
    }

    private static boolean calcNodeVal(ListNode l1, ListNode l2, ListNode lastNode, boolean isLtTen) {
        ListNode node = new ListNode();
        int val = 0;
        if (l1 != null) {
            val += l1.val;
        }
        if (l2 != null) {
            val += l2.val;
        }
        if (isLtTen) {
            val += 1;
        }
        if (val >= 10) {
            node.val = val - 10;
            isLtTen = true;
        } else {
            isLtTen = false;
        }
        lastNode.next = node;
        return isLtTen;
    }
}
