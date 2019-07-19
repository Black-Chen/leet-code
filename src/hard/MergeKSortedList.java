package hard;

import easy.MergeTwoSortedList.ListNode;

/**
 * MergeKSortedList
 *
 * @author black
 * @date 2019-07-19
 */
public class MergeKSortedList {

    public static void main(String[] args) {

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode currentNode = null;
        if (lists.length == 0) {
            return head;
        }
        while (hasNext(lists)) {
            int minIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                ListNode cur = lists[i];
                if (cur != null) {
                    if (minIndex == -1) {
                        minIndex = i;
                    } else {
                        if (lists[i].val < lists[minIndex].val) {
                            minIndex = i;
                        }
                    }
                }
            }
            if (head == null) {
                head = lists[minIndex];
                currentNode = head;
            } else {
                currentNode.next = lists[minIndex];
                currentNode = currentNode.next;
            }
            lists[minIndex] = lists[minIndex].next;
        }
        return head;
    }

    private static boolean hasNext(ListNode[] lists) {
        boolean hasNext = false;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                hasNext = true;
                break;
            }
        }
        return hasNext;
    }
}
