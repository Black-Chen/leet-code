import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() <= k || queue.peek() < nums[i]) {
                queue.add(nums[i]);
            }
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int flag = nums[right];
        int j = left;
        for (int i = left; i < right; i++) {
            if (nums[i] >= flag) {
                swap(nums, i, j++);
            }
        }
        swap(nums, right, j);
        quickSort(nums, left, j - 1);
        quickSort(nums, j + 1, right);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

