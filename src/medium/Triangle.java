package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Triangle
 *
 * @author black
 * @date 2019-09-16
 */
public class Triangle {

    public static void main(String[] args) {
        List<List<Integer>> test = Arrays.asList(Arrays.asList(2));
        System.out.println(bottomToTop(test));
    }

    public static int bottomToTop(List<List<Integer>> triangle) {
        int[] sum = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                sum[j] = Math.min(sum[j], sum[j + 1]) + triangle.get(i).get(j);
            }
        }
        return sum[0];
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int total = 0;
        if (triangle == null || triangle.isEmpty()) {
            return total;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        List<Integer> lastMin = new ArrayList<>(triangle.size());
        lastMin.addAll(triangle.get(0));
        int lastSum = 0;
        int currentValue = 0;
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get((i)).size(); j++) {
                if (j - 1 < 0) {
                    lastSum = triangle.get(i).get(j) + lastMin.get(j);
                    if (i == triangle.size() - 1) {
                        total = lastSum;
                    }
                } else if (j == lastMin.size()) {
                    total = Math.min(total, lastSum);
                    currentValue = triangle.get(i).get(j) + lastMin.get(j - 1);
                    lastMin.set(j - 1, lastSum);
                    lastSum = currentValue;
                } else {
                    total = Math.min(total, lastSum);
                    currentValue = Math.min(triangle.get(i).get(j) + lastMin.get(j - 1), triangle.get(i).get(j) + lastMin.get(j));
                    lastMin.set(j - 1, lastSum);
                    lastSum = currentValue;
                }
            }
            total = Math.min(total, lastSum);
            lastMin.add(lastSum);
            lastSum = 0;
        }
        return total;
    }
}
