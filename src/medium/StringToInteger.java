package medium;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/**
 * StringToInteger
 *
 * @author black
 * @date 2019-07-12
 */
public class StringToInteger {

    public static void main(String[] args) {

    }

    public int myAtoi(String str) {
        String value;
        if (str == null || (value = str.trim()).length() == 0) {
            return 0;
        }
        List<Character> validStartChar = Arrays.asList('+', '-', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        StringBuilder builder = new StringBuilder();
        boolean negative = false;

        char firstChar = value.charAt(0);
        boolean isStartWithoutZero = false;
        if (!validStartChar.contains(firstChar)) {
            return 0;
        } else {
            if (!Character.isDigit(firstChar)) {
                if (firstChar == '-') {
                    negative = true;
                    builder.append(firstChar);
                }
            } else {
                if (firstChar != '0') {
                    builder.append(firstChar);
                    isStartWithoutZero = true;
                }
            }
        }
        for (int i = 1; i < value.length(); i++) {
            char c = value.charAt(i);
            if (Character.isDigit(c)) {
                if (isStartWithoutZero) {
                    builder.append(c);
                } else {
                    if (c != '0') {
                        isStartWithoutZero = true;
                        builder.append(c);
                    } else {
                        continue;
                    }
                }
            } else {
                break;
            }
        }

        if (builder.length() == 0
                || (negative && builder.length() == 1)) {
            return 0;
        }
        if (!negative && builder.length() > 10) {
            return Integer.MAX_VALUE;
        }
        if (negative && builder.length() > 11) {
            return Integer.MIN_VALUE;
        }
        Long minValue = Long.valueOf(Integer.MIN_VALUE);
        Long maxValue = Long.valueOf(Integer.MAX_VALUE);
        Long target = Long.valueOf(builder.toString());
        if (target.compareTo(minValue) <= 0) {
            return Integer.MIN_VALUE;
        }
        if (target.compareTo(maxValue) >= 0) {
            return Integer.MAX_VALUE;
        }
        return target.intValue();
    }
}
