package medium;

/**
 * ZigZagConversion
 *
 * @author black
 * @date 2019-06-24
 */
public class ZigZagConversion {

    public static void main(String[] args) {
        System.out.println(convert("A", 1));
    }

    public static String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows == 0 || numRows == 1) {
            return s;
        }
        if (numRows > s.length()) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int index = i;
            int value = i;
            builder.append(s.charAt(i));
            while (index < s.length()) {
                value = numRows - 1 - value;
                if (value != 0) {
                    index += value * 2;
                    if (index >= s.length()) {
                        break;
                    }
                    builder.append(s.charAt(index));
                }
            }
        }
        return builder.toString();
    }
}
