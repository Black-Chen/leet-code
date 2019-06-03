package easy;

/**
 * easy.AddBinary
 *
 * @author black
 * @date 2019/6/3
 */
public class AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("100", "110010"));
    }

    public static String addBinary(String a, String b) {
        int loopSize = Math.max(a.length(), b.length());
        StringBuilder builder = new StringBuilder(loopSize + 1);
        int plus = 0;
        boolean bEnd = false;
        boolean aEnd = false;
        for (int i = loopSize - 1; i >= 0; i--) {
            int aIndex = Math.min(i, a.length() - (loopSize - i));
            int bIndex = Math.min(i, b.length() - (loopSize - i));
            int aValue = 0;
            int bValue = 0;
            if (!aEnd) {
                aValue = Character.digit(a.charAt(aIndex), 10);
            }
            if (!bEnd) {
                bValue = Character.digit(b.charAt(bIndex), 10);
            }
            if (bIndex == 0) {
                bEnd = true;
            }
            if (aIndex == 0) {
                aEnd = true;
            }
            int result = aValue + bValue + plus;
            builder.append(result % 2);
            plus = result / 2;
        }
        if (plus > 0) {
            builder.append(plus);
        }
        return builder.reverse().toString();
    }
}
