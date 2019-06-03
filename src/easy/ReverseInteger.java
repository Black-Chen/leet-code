package easy;

public class ReverseInteger {

    public int reverse(int x) {
        String str = String.valueOf(x);
        StringBuilder builder = new StringBuilder(str.length());
        int endIndex = 0;
        if (x < 0) {
            endIndex = 1;
            builder.append("-");
        }
        boolean start = true;
        for (int i = str.length(); i > endIndex; i--) {
            char c = str.charAt(i - 1);
            if (start) {
                start = false;
                if (c == '0') {
                    continue;
                }
            }
            builder.append(c);
        }
        Long reverseValue = 0L;
        if (builder.length() > 0) {
            reverseValue = Long.valueOf(builder.toString());
        }
        if (reverseValue > Integer.MAX_VALUE || reverseValue < Integer.MIN_VALUE) {
            reverseValue = 0L;
        }

        return reverseValue.intValue();
    }
}
