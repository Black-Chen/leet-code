package easy;

import easy.MergeTwoSortedList.ListNode;

import java.util.HashSet;

/**
 * IntersectionofTwoLinkedLists
 *
 * @author black
 * @date 2019-08-01
 */
public class IntersectionofTwoLinkedLists {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        HashSet<ListNode> existNode = new HashSet<>();
        ListNode target = null;
        while (headA != null) {
            existNode.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (existNode.contains(headB)) {
                target = headB;
                break;
            }
            headB = headB.next;
        }
        return target;
    }
}
