package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * MergeSortedArray
 *
 * @author black
 * @date 2019/6/3
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = new int[] {0,0,3,0,0,0,0,0,0};
        merge1(nums1, 3, new int[] {-1,1,1,1,2,3}, 6);
        System.out.println(nums1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
        }
        LinkedList<Integer> swapList = new LinkedList<Integer>();
        int i = 0;
        int j = 0;
        for (int index = 0; index < nums1.length; index++) {
            if (j >= n && i < m) {
                if (swapList.size() > 0) {
                    if (swapList.peekFirst() <= nums1[i]) {
                        swapList.add(nums1[i]);
                        nums1[index] = swapList.peekFirst();
                        swapList.removeFirst();
                        i++;
                        continue;
                    }
                }
                nums1[index] = nums1[i];
                i++;
                continue;
            }
            if (i >= m && j < n) {
                if (swapList.size() > 0) {
                    if (swapList.peekFirst() <= nums2[j]) {
                        nums1[index] = swapList.peekFirst();
                        swapList.removeFirst();
                        continue;
                    }
                }
                nums1[index] = nums2[j];
                j++;
                continue;
            }
            if (i >= m && j >= n) {
                if (swapList.size() > 0) {
                    nums1[index] = swapList.peekFirst();
                    swapList.removeFirst();
                    continue;
                }
            }
            int value1 = nums1[i];
            int value2 = nums2[j];
            if (value1 > value2) {
                if (swapList.size() > 0) {
                    if (swapList.peekFirst() <= value2) {
                        swapList.add(value1);
                        nums1[index] = swapList.peekFirst();
                        swapList.removeFirst();
                        i++;
                        continue;
                    }
                }
                nums1[index] = value2;
                swapList.add(value1);
                i++;
                j++;
            } else {
                if (swapList.size() > 0) {
                    if (swapList.peekFirst() <= value1) {
                        swapList.add(value1);
                        nums1[index] = swapList.peekFirst();
                        swapList.removeFirst();
                        i++;
                        continue;
                    }
                }
                nums1[index] = value1;
                i++;
            }
        }
    }
}
