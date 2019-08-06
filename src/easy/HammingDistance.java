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

    public static void main(String[] args) {
        System.out.println(hammingDistanceNew(1, 4));
    }

    public static int hammingDistanceNew1(int x, int y) {
        int count = 0;
        while (x != 0 || y != 0) {
            if ((x & 1) != (y & 1)) {
                count++;
            }
            x = x >> 1;
            y = y >> 1;
        }
        return count;
    }

    public static int hammingDistanceNew(int x, int y) {
        int count = 0;
        while (x != 0 || y != 0) {
            int digitx = x & 1;
            int digity = y & 1;
            if (x == 0) {
                if (digity != 0) {
                    count++;
                }
                y = y >> 1;
                continue;
            }
            if (y == 0) {
                if (digitx != 0) {
                    count++;
                }
                x = x >> 1;
                continue;
            }
            if (digitx != digity) {
                count++;
            }
            x = x >> 1;
            y = y >> 1;
        }
        return count;
    }

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
