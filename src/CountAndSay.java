import java.util.HashMap;

/**
 * CountAndSay
 *
 * @author black
 * @date 2019/6/2
 */
public class CountAndSay {

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(1));
        System.out.println(countAndSay.countAndSay(4));
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return count(countAndSay(n - 1));
    }

    public String count(String source) {
        char curr = source.charAt(0);
        int count = 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < source.length(); i++) {
            curr = source.charAt(i);
            char prev = source.charAt(i - 1);
            if (curr == prev) {
                count++;
            } else {
                builder.append(count).append(prev);
                count = 1;
            }
        }
        builder.append(count).append(curr);
        return builder.toString();
    }
}
