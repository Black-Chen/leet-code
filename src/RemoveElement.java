/**
 * RemoveElement
 *
 * @author black
 * @date 2019/6/2
 */
public class RemoveElement {

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3,2,2,3}, 3));
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int size = 0;
        if (nums.length > 0) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == val) {
                    continue;
                } else {
                    nums[size] = nums[i];
                    size++;
                }
            }
        }
        return size;
    }
}
