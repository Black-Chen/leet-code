import java.math.BigInteger;

/**
 * Solution
 *
 * @author black
 * @date 2019-07-10
 */
class Solution {
    public static int solution(int A, int B) {
        // write your code in Java SE 8
        BigInteger multiResult = BigInteger.valueOf(A).multiply(BigInteger.valueOf(B));
        return byteCompute(multiResult);
    }

    private static int byteCompute(BigInteger n) {
        int count = 0;
        while (!n.equals(BigInteger.ZERO)) {
            count++;
            n = n.add(BigInteger.valueOf(-1L)).and(n);
        }
        return count;
    }

    public static String rawSolution(String S) {
        int[] occurrences = new int[26];
        for (char ch : S.toCharArray()) {
            occurrences[ch - 'a']++;
        }

        char best_char = 'a';
        int  best_res  = 0;

        for (int i = 1; i < 26; i++) {
            if (occurrences[i] >= best_res) {
                best_char = (char)((int)'a' + i);
                best_res  = occurrences[i];
            }
        }

        return Character.toString(best_char);
    }

    public static String solution(String S) {
        int[] occurrences = new int[26];
        for (char ch : S.toCharArray()) {
            occurrences[ch - 'a']++;
        }

        char best_char = 'a';
        int  best_res  = occurrences[0];

        for (int i = 1; i < 26; i++) {
            if (occurrences[i] > best_res) {
                best_char = (char)((int)'a' + i);
                best_res  = occurrences[i];
            }
        }

        return Character.toString(best_char);
    }

    public static void main(String[] args) {
        System.out.println(solution("aaaab"));
        System.out.println(solution("abbccdd"));
    }
}
