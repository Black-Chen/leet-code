package medium;

import java.util.Arrays;
import java.util.List;

/**
 * Integer2Roman
 *
 * @author black
 * @date 2019-07-23
 */
public class Integer2Roman {

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    private static List<Integer> list = Arrays.asList(1000, 100, 10, 1);

    public static String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        for (Integer value : list) {
            int c = num / value;
            if (c == 0) {
                continue;
            }
            if (c == 9) {
                switch (value) {
                    case 1000 : builder.append("MMMMMMMMM"); break;
                    case 100 : builder.append("CM"); break;
                    case 10 : builder.append("XC"); break;
                    case 1 : builder.append("IX"); break;
                }
            } else if (c >= 5) {
                int d = c - 5;
                switch (value) {
                    case 1000 : builder.append("MMMMM"); break;
                    case 100 : builder.append("D"); break;
                    case 10 : builder.append("L"); break;
                    case 1 : builder.append("V"); break;
                }
                appendData(builder, value, d);
            } else if (c == 4) {
                switch (value) {
                    case 1000 : builder.append("MMMM"); break;
                    case 100 : builder.append("CD"); break;
                    case 10 : builder.append("XL"); break;
                    case 1 : builder.append("IV"); break;
                }
            } else {
                appendData(builder, value, c);
            }
            num = num - c * value;
            if (num == 0) {
                break;
            }
        }

        return builder.toString();
    }

    private static void appendData(StringBuilder builder, Integer value, int c) {
        for (int i = 0; i < c; i++) {
            switch (value) {
                case 1000 : builder.append("M"); break;
                case 100 : builder.append("C"); break;
                case 10 : builder.append("X"); break;
                case 1 : builder.append("I"); break;
            }
        }
    }
}
