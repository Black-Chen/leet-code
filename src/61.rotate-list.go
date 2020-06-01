/*
 * @lc app=leetcode id=61 lang=golang
 *
 * [61] Rotate List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func rotateRight(head *ListNode, k int) *ListNode {
	list := make([]*ListNode, 0)
	count := 0
	for {
		if head != nil {
			list = append(list, head)
			head = head.Next
			count++
		} else {
			break
		}
	}
	if count == 0 {
		return head
	}
	reminder := k % count
	if reminder > 0 {
		list[count - 1 - reminder].Next = nil
		list[count - 1].Next = list[0]
		return list[count - reminder]
	} else {
		return list[0]
	}
}
// @lc code=end

