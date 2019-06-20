package easy;

/**
 * easy.MergeTwoSortedList
 *
 * @author black
 * @date 2019/6/1
 */
public class MergeTwoSortedList {

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode() {}
        public ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = null;
        ListNode now = null;
        while (l1 != null || l2 != null) {
            ListNode recentNode;
            if (l1 == null) {
                recentNode = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                recentNode = l1;
                l1 = l1.next;
            } else {
                if (l1.val > l2.val) {
                    recentNode = l2;
                    l2 = l2.next;
                } else {
                    recentNode = l1;
                    l1 = l1.next;
                }
            }
            if (node == null) {
                node = recentNode;
                now = node;
            } else {
                now.next = recentNode;
                now = recentNode;
            }
        }
        return node;
    }
}
