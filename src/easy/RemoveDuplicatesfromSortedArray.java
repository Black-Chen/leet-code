package easy;

import java.util.HashSet;

/**
 * easy.RemoveDuplicatesfromSortedArray
 *
 * @author black
 * @date 2019/6/1
 */
public class RemoveDuplicatesfromSortedArray {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 2}));
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public static int removeDuplicates(int[] nums) {
        int size = 0;
        if (nums.length > 0) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[size]) {
                    continue;
                } else {
                    size++;
                    nums[size] = nums[i];
                    for (int j = size; j < i; j++) {
                        nums[j] = nums[i];
                    }
                }
            }
        }
        return size + 1;
    }
}
