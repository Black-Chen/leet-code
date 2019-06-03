package easy;

/**
 * easy.MaximumSubarray
 *
 * @author black
 * @date 2019/6/2
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-1,1,2,1}));
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[] {-2,3,1,3}));
        System.out.println(maxSubArray(new int[] {-2,1}));
    }

    public static int maxSubArray(int[] nums) {
        int result = nums[0];
        int recent = result;
        for (int i = 1; i < nums.length; i++) {
            int sum = recent + nums[i];
            int big = Math.max(nums[i], sum);
            if (big >= result) {
                result = big;
            }
            if (sum < big) {
                if (nums[i] >= 0) {
                    recent = nums[i];
                } else {
                    recent = 0;
                }
            } else {
                recent = sum;
            }
        }

        return result;
    }
}
