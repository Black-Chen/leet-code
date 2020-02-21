package medium;


/**
 * ReverseWordInAString
 *
 * @author black
 * @date 2020-02-21
 */
public class ReverseWordInAString {

    public static void main(String[] args) {
        String a = "a good   example";

        System.out.println(reverseWords(a));
    }

    public static String reverseWords(String s) {
        if (s == null || s.trim().length() == 0) {
            return "";
        }
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].length() > 0) {
                result.append(" ").append(words[i]);
            }
        }
        return result.toString().trim();
    }


}
