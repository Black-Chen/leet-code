package medium;

/**
 * SortColors
 *
 * @author black
 * @date 2019-08-19
 */
public class SortColors {

    public static void main(String[] args) {

    }

    public void sortColors(int[] nums) {
        int[] array = new int[3];
        for (int i = 0; i < nums.length; i++) {
            array[nums[i]]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < array[0]) {
                nums[i] = 0;
            } else if (i < array[0] + array[1]) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
