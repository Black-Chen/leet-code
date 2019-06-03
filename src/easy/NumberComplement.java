package easy;

/**
 * NumberComplement
 *
 * @author black
 * @date 2019/6/3
 */
public class NumberComplement {

    public int findComplement(int num) {
        int result = 0;

        int remaining = num % 2;
        int quotient = num / 2;
        int count = 0;
        if (remaining == 0) {
            result += Math.pow(2.0d, count);
        }
        while (quotient >= 1) {
            remaining = quotient % 2;
            quotient = quotient / 2;
            count++;
            if (remaining == 0) {
                result += Math.pow(2.0d, count);
            }
        }
        return result;
    }
}
