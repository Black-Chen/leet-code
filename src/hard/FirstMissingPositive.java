package hard;

import java.util.HashSet;

/**
 * FirstMissingPositive
 *
 * @author black
 * @date 2019-07-19
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] test = new int[] {1};
        System.out.println(firstMissingPositive2(test));
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        HashSet<Integer> positiveNums = new HashSet<>(nums.length);
        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                positiveNums.add(nums[i]);
            }
        }
        for (int i = 1; i <= positiveNums.size() + 1; i++) {
            if (!positiveNums.contains(i)) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static int firstMissingPositive2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int[] array = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                count++;
                if (nums[i] <= array.length) {
                    array[nums[i] - 1]++;
                }
            }
        }
        int result = 1 + count;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                result = i + 1;
                break;
            }
        }
        return result;
    }
}
