package medium;

/**
 * CountingBits
 *
 * @author black
 * @date 2019-09-18
 */
public class CountingBits {

    public static void main(String[] args) {

    }

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}
