package easy;

/**
 * easy.LongestCommonPrefix
 *
 * @author black
 * @date 2019/6/1
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[] {"dog","racecar","car"}));
    }

    public static String logestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char value = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (i == strs[j].length() || value != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean isSame = true;
        if (strs.length == 0) {
            return "";
        }
        for (int j = 0; ; j++) {
            if (j >= strs[0].length()) {
                break;
            }
            char value = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {
                if (j >= strs[i].length()) {
                    isSame = false;
                    break;
                }
                if (value != strs[i].charAt(j)) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) {
                break;
            } else {
                stringBuilder.append(value);
            }
        }

        return stringBuilder.toString();
    }
}
