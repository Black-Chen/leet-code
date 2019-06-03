/**
 * SqrtX
 *
 * @author black
 * @date 2019/6/3
 */
public class SqrtX {

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }

    public static int mySqrt(int x) {
        return ((Double)Math.sqrt(Double.valueOf(x))).intValue();
    }
}
