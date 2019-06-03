/**
 * ClimbingStairs
 *
 * @author black
 * @date 2019/6/3
 */
public class ClimbingStairs {

    public static void main(String[] args) {
//        System.out.println(climbStairs(2));
        System.out.println(climbStairs(45));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(6));
//        System.out.println(comb_log(24, 11));
    }

    public static int climbStairs(int n) {
        int[] memory = new int[n];

        return fibonacci(0, n, memory);
    }

    private static int fibonacci(int i, int n, int[] memory) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memory[i] > 0) {
            return memory[i];
        }
        memory[i] = fibonacci(i + 1, n, memory) + fibonacci(i + 2, n, memory);
        return memory[i];
    }
//
//    private static int comb_log(int m, int n) {
//        if (n < m - n) {
//            n = m - n;
//        }
//        int loopSize = m - n;
//        Double bigValue = 1.0d;
//        Double smallValue = 1.0d;
//        Double result = 0.0d;
//        for (int i = 0; i < loopSize; i++) {
//            bigValue = bigValue * (m - i);
//        }
//        for (int i = 1; i <= loopSize; i++) {
//            smallValue = smallValue * i;
//        }
//        result = bigValue / smallValue * 1.0d;
//        System.out.println("value 3 : " + result.intValue());
//        return result.intValue();
//    }

}
