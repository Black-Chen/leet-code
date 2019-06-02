/**
 * LengthOfLastWord
 *
 * @author black
 * @date 2019/6/2
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("a "));
    }

    public static int lengthOfLastWord(String s) {
        int result = 0;
        if (s != null && s.length() > 0) {
            String[] array = s.split(" ");
            if (array.length > 0) {
                result = array[array.length - 1].length();
            }
        }
        return result;
    }
}
