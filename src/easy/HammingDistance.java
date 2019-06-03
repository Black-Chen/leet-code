package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * HammingDistance
 *
 * @author black
 * @date 2019/6/3
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        List<Integer> xBits = getBitsList(x);
        List<Integer> yBits = getBitsList(y);

        int distance = 0;
        List<Integer> longgerList = xBits.size() > yBits.size() ? xBits : yBits;
        List<Integer> shortterList = longgerList == xBits ? yBits : xBits;
        for (int i = longgerList.size(); i > 0; i--) {
            if (i > shortterList.size()) {
                if (longgerList.get((i - 1)) == 1) {
                    distance++;
                }
            } else {
                if (longgerList.get((i - 1)).intValue() != shortterList.get((i - 1)).intValue()) {
                    distance++;
                }
            }
        }
        return distance;
    }

    private static List<Integer> getBitsList(int x) {
        List<Integer> bits = new ArrayList<>();
        int remaining = x % 2;
        int quotient = x / 2;
        bits.add(remaining);
        while (quotient >= 1) {
            remaining = quotient % 2;
            quotient = quotient / 2;
            bits.add(remaining);
        }
        return bits;
    }
}
