package easy;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];
        HashMap<Integer, Integer> valueIndexMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int index = valueIndexMap.getOrDefault(target - nums[i], -1);
            if (index != -1 && index != i) {
                array[1] = i;
                array[0] = index;
                break;
            }
            valueIndexMap.put(nums[i], i);
        }
        return array;
    }
}
