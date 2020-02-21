package easy;

/**
 * easy.SqrtX
 *
 * @author black
 * @date 2019/6/3
 */
public class SqrtX {

    public static void main(String[] args) {
        System.out.println(mySqrt(9));
        System.out.println(mySqrt1(2147395599));
    }

    public static int mySqrt(int x) {
        return ((Double)Math.sqrt(Double.valueOf(x))).intValue();
    }

    public static int mySqrt2(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 0;
        int right = x;
        int value = x / 2;
        while (true) {
            if (value > x / value) {
                right = value;
                value = (left + right) / 2;
            } else {
                if ((value + 1) > x /  (value + 1)) {
                    break;
                } else {
                    left = value;
                    value = (left + right) / 2;
                }
            }
        }
        return value;
    }

    public static int mySqrt1(int x) {
        if (x <= 0) {
            return 0;
        }

        int a = 1, b = x;
        while (a < b) {
            int mid = (a + b) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            } else if (mid > x / mid) {
                b = mid;
            } else {
                a = mid + 1;
            }
        }
        return a;
    }
}
