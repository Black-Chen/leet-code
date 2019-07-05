package easy;

/**
 * SingleNumber
 *
 * @author black
 * @date 2019-07-05
 */
public class SingleNumber {

    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
