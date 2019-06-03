package easy;

import java.util.Arrays;

/**
 * MergeSortedArray
 *
 * @author black
 * @date 2019/6/3
 */
public class MergeSortedArray {

    public static void main(String[] args) {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
