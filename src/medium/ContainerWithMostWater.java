package medium;

/**
 * ContainerWithMostWater
 *
 * @author black
 * @date 2019-07-23
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
