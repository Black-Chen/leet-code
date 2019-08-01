package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * FindFirstandLastPositionofElementinSortedArray
 *
 * @author black
 * @date 2019-08-01
 */
public class FindFirstandLastPositionofElementinSortedArray {

    public static void main(String[] args) {
        System.out.println(searchRange2(new int[] {1}, 2));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            List<Integer> pair = map.get(nums[i]);
            if (pair == null) {
                pair = Arrays.asList(i, i);
                map.put(nums[i], pair);
            } else {
                pair.set(1, i);
            }
        }
        List<Integer> pair = map.get(target);
        if (pair != null) {
            result[0] = pair.get(0);
            result[1] = pair.get(1);
        }
        return result;
    }

    public static int[] searchRange2(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        binarySearch(0, nums.length, target, nums, result);
        return result;
    }

    private static void binarySearch(int left, int right, int target, int[] nums, int[] result) {
        if (right - left == 1) {
            if (target != nums[left]) {
                result[0] = -1;
                result[1] = -1;
            } else {
                if (result[0] == -1) {
                    result[0] = left;
                    result[1] = left;
                } else {
                    if (left < result[0]) {
                        result[0] = left;
                    }
                    if (left > result[1]) {
                        result[1] = left;
                    }
                }
            }
        } else {
            int middle = (right + left) / 2;
            int middleValue = nums[middle];
            if (middleValue == target) {
                binarySearch(left, middle, target, nums, result);
                binarySearch(middle, right, target, nums, result);
            }
            if (middleValue < target) {
                binarySearch(middle, right, target, nums, result);
            }
            if (middleValue > target) {
                binarySearch(left, middle, target, nums, result);
            }
        }
    }
}
