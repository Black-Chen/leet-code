package medium;

/**
 * Pow
 *
 * @author black
 * @date 2019-07-24
 */
public class Pow {

    public static void main(String[] args) {
        System.out.println(Math.pow(2, -3) == myPow(2, -3));
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0.0d || x == 1.0d || n == 1) {
            return x;
        }
        if (x == -1.0d) {
            int remain = n % 2;
            return remain > 0 ? -x : x;
        }
        if (n < 0) {
            x = 1/x;
            n = -n;
        }
        return pow(x, n - 1, x);
    }

    private static double pow(double x, int n, double lastResult) {
        double result = lastResult;
        if (n > 0) {
            result = pow(x, n - 1, lastResult * x);
        }
        return result;
    }
}
