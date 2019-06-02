/**
 * SearchInsertPosition
 *
 * @author black
 * @date 2019/6/2
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
//        System.out.println(searchInsert(new int[] {1,3,5,6}, 5));
//        System.out.println(searchInsert(new int[] {1,3,5,6}, 2));
        System.out.println(searchInsert(new int[] {2,3,5,6,9}, 7));
        System.out.println(searchInsert(new int[] {1,4,6,7,8,9}, 6));
    }

    public static int searchInsert(int[] nums, int target) {
        int index = 0;
        int start = 0;
        int end = nums.length - 1;
        int halfIndex;
        boolean isIndexFounded = false;
        if (nums.length > 0) {
            while (end > start) {
                halfIndex = (start + end + 1) / 2;
                int value = nums[halfIndex];
                if (value == target) {
                    index = halfIndex;
                    isIndexFounded = true;
                    break;
                }
                if (value < target) {
                    start = halfIndex + 1;
                    continue;
                }
                if (value > target) {
                    end = halfIndex - 1;
                    continue;
                }
            }
            if (!isIndexFounded) {
                if (end <= 0) {
                    if (nums[start] >= target) {
                        index = start;
                    } else {
                        index = start + 1;
                    }
                } else if (start >= nums.length - 1) {
                    if (nums[end] >= target) {
                        index = end;
                    } else {
                        index = end + 1;
                    }
                } else {
                    if (nums[start] >= target) {
                        index = start;
                    } else {
                        index = start + 1;
                    }
                }
            }
        }
        return index;
    }
}
