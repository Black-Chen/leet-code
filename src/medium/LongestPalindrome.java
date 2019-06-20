package medium;

import java.util.HashSet;

/**
 * LongestPalindrome
 *
 * @author black
 * @date 2019/6/20
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ac"));
//        System.out.println(longestPalindrome("aaaa"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int targetLength = s.length();
        String result = null;
        while (targetLength > 0) {
            int loopSize = s.length() - targetLength;
            if (loopSize == 0) {
                if (isPalindrome(s)) {
                    return s;
                }
            } else {
                for (int i = 0; i <= loopSize; i++) {
                    result = s.substring(i, s.length() + i - loopSize);
                    if (isPalindrome(result)) {
                        return result;
                    }
                }
            }
            targetLength--;
        }
        return null;
    }

    private static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        char[] chars = str.toCharArray();
        boolean result = true;
        while (i <= j) {
            if (chars[i] != chars[j]) {
                result = false;
                break;
            }
            i++;
            j--;
        }
        return result;
    }
}
