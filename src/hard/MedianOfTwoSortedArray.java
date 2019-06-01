package hard;

/**
 * MedianOfTwoSortedArray
 *
 * @author black
 * @date 2019/3/20
 */
public class MedianOfTwoSortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0.0d;
        if (nums1.length == 0) {
            return getMedian4Array(nums2);
        }
        if (nums2.length == 0) {
            return getMedian4Array(nums1);
        }
        int targetHigh = -1;
        int targetLow = -1;
        int lengthSum = nums1.length + nums2.length;
        int remaining = (lengthSum) % 2;
        int quotient = lengthSum / 2;
        if (remaining > 0) {
            targetHigh = quotient + 1;
            targetLow = quotient + 1;
        } else {
            targetHigh = quotient;
            targetLow = quotient - 1;
        }

        int[] swap;
        if (nums1[nums1.length - 1] > nums2[nums2.length - 1]) {
            swap = nums1;
            nums1 = nums2;
            nums2 = swap;
        }
        Median medianLow = getMedian(nums1);
        Median medianHigh = getMedian(nums2);
        if (medianHigh.value >= medianLow.value) {
            medianHigh.nowTarget = medianHigh.index + medianLow.index + 1;
        } else {
            //for (int i = medianLow.) {}
        }

//        while (median2.nowTarget > targetHigh) {
//            int value = nums2[median2.index - 1];
//            if (nums2[median2.index - 1] > median1.value) {
//                median2.value = value;
//                median2.index = median2.index - 1;
//                median2.nowTarget = median2.nowTarget - 1;
//            } else {
//
//            }
//        }


        return result;
    }

    private Median getMedian(int[] nums) {
        int result = nums.length / 2;
        if (nums.length % 2 == 0) {
            return new Median(nums[result], result);
        } else {
            return new Median(nums[result + 1], result + 1);
        }
    }

    private double getMedian4Array(int[] nums) {
        int result = nums.length / 2;
        if (nums.length % 2 == 0) {
            return (nums[result - 1] + nums[result]) / 2.0d;
        } else {
            return nums[result + 1];
        }
    }

    class Median {
        int value;
        int index;
        int nowTarget;

        public Median(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
