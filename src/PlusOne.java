import java.util.ArrayList;
import java.util.List;

/**
 * PlusOne
 *
 * @author black
 * @date 2019/6/3
 */
public class PlusOne {

    public static void main(String[] args) {
        System.out.println(plusOne(new int[] {9}));
    }

    public static int[] plusOne(int[] digits) {
        List<Integer> result = new ArrayList<>(digits.length + 1);
        int plus = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int value = digits[i] + plus;
            if (i == digits.length - 1) {
                value += 1;
            }
            plus = value / 10;
            int data = value % 10;
            result.add(data);
        }
        if (plus > 0) {
            result.add(plus);
        }
        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(result.size() - 1 - i);
        }
        return array;
    }
}
