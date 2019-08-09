package medium;

import java.math.BigInteger;

/**
 * MultiplyStrings
 *
 * @author black
 * @date 2019-08-02
 */
public class MultiplyStrings {

    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println(multiplyStrings.multiply("2498002655", "5186493004848"));
        System.out.println(BigInteger.valueOf(5186493004848L).multiply(BigInteger.valueOf(2498002655L)).toString());
    }

    public String multiply(String num1, String num2) {
        return karatsuba(num1, num2);
    }

    private String karatsuba(String num1, String num2) {
        if (num1.length() < 2 || num2.length() < 2) {
            return multiplySub(num1, num2);
        }
        int halfN = (Math.max(num1.length(), num2.length()) + 1) / 2;
        String a = getUpper(halfN, num1);
        String b = getLower(halfN, num1);
        String c = getUpper(halfN, num2);
        String d = getLower(halfN, num2);

        String x1 = karatsuba(a, c);
        String x2 = karatsuba(b, d);
        String x3 = karatsuba(add(a, b), add(c, d));
        String x4 = substract(substract(x3, x1), x2);

        StringBuilder x1MultiBuilder = new StringBuilder();
        StringBuilder x3MultiBuilder = new StringBuilder();
        x1MultiBuilder.append(x1);
        x3MultiBuilder.append(x4);
        for (int i = 0; i < halfN * 2; i++) {
            if (i < halfN) {
                x3MultiBuilder.append('0');
            }
            x1MultiBuilder.append('0');
        }
        return add(add(x1MultiBuilder.toString(), x3MultiBuilder.toString()), x2);
    }

    private String add(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int valueA = getValueAtIndex(a, i);
            int valueB = getValueAtIndex(b, j);
            int result = valueA + valueB + carry;
            carry = result / 10;
            builder.append(result % 10);
            i--;
            j--;
        }
        if (carry > 0) {
            builder.append(carry);
        }
        builder.reverse();
        boolean isStartWithZero = true;
        while (isStartWithZero) {
            if (builder.length() > 0 && builder.charAt(0) == '0') {
                builder.deleteCharAt(0);
            } else {
                break;
            }
        }
        if (builder.length() == 0) {
            builder.append('0');
        }
        return builder.toString();
    }

    private String multiplySub(String a, String b) {
        StringBuilder builder = new StringBuilder();
        String min = a.length() == 1 ? a : b;
        String max = a.length() == 1 ? b : a;
        int carry = 0;
        int value = min.charAt(0) - '0';
        for (int i = max.length() - 1; i >= 0; i--) {
            int result = (max.charAt(i) - '0') * value + carry;
            carry = result / 10;
            builder.append(result % 10);
        }
        if (carry > 0) {
            builder.append(carry);
        }
        builder.reverse();
        boolean isStartWithZero = true;
        while (isStartWithZero) {
            if (builder.length() > 0 && builder.charAt(0) == '0') {
                builder.deleteCharAt(0);
            } else {
                break;
            }
        }
        if (builder.length() == 0) {
            builder.append('0');
        }
        return builder.toString();
    }

    private String substract(String a, String b) {StringBuilder builder = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int valueA = getValueAtIndex(a, i);
            int valueB = getValueAtIndex(b, j);
            int result = valueA - valueB - carry;
            if (result < 0) {
                result += 10;
                carry = 1;
            } else {
                carry = 0;
            }
            builder.append(result);
            i--;
            j--;
        }
        builder.reverse();
        boolean isStartWithZero = true;
        while (isStartWithZero) {
            if (builder.length() > 0 && builder.charAt(0) == '0') {
                builder.deleteCharAt(0);
            } else {
                break;
            }
        }
        return builder.toString();
    }

    private static int getValueAtIndex(String str, int index) {
        if (index < 0) {
            return 0;
        }
        return str.charAt(index) - '0';
    }

    private String getUpper(int half, String num) {
        if (half >= num.length()) {
            return "0";
        }
        return num.substring(0, num.length() - half);
    }

    private String getLower(int half, String num) {
        if (half >= num.length()) {
            return num;
        }
        return num.substring(num.length() - half);
    }
}
