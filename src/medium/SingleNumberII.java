package medium;

/**
 * SingleNumberII
 *
 * @author black
 * @date 2019-07-22
 */
public class SingleNumberII {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,3}));
    }

    public static int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] digits = new int[33];
        for (int i = 0; i < nums.length; i++) {
            long value = nums[i];
            int count = 0;
            if (value < 0) {
                value = -value;
                digits[32] += 1;
            }
            while (value != 0) {
                if ((value & 1) == 1) {
                    digits[count]++;
                }
                value = value >> 1;
                count++;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (digits[i] % 3 == 1) {
                result += 1 << i;
            }
        }
        if (digits[32] % 3 == 1) {
            result = -result;
        }
        return result;
    }
}
