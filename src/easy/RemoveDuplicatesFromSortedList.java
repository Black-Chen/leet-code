package easy;

/**
 * easy.RemoveDuplicatesFromSortedList
 *
 * @author black
 * @date 2019/6/3
 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {

    }

    public static MergeTwoSortedList.ListNode deleteDuplicates(MergeTwoSortedList.ListNode head) {
        MergeTwoSortedList.ListNode node = head;
        if (head != null) {
            int value = head.val;
            while (head.next != null) {
                if (value == head.next.val) {
                    head.next = head.next.next;
                    continue;
                } else {
                    value = head.next.val;
                    head = head.next;
                }
            }
        }
        return node;
    }
}
