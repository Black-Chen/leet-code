import java.util.LinkedList;

/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        if (nums == null || nums.length == 0 || k <= 0) {
            return result;
        }
        LinkedList<Integer> maxQueue = new LinkedList();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!maxQueue.isEmpty() && nums[maxQueue.peekLast()] <= nums[i]) {
                maxQueue.pollLast();
            }
            maxQueue.addLast(i);
            if (maxQueue.peekFirst() <= i - k) {
                maxQueue.pollFirst();
            }
            if (i >= k - 1) {
                result[count] = nums[maxQueue.peekFirst()];
                count++;
            }
        }

        return result;
    }
}
// @lc code=end

