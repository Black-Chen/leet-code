package easy;

public class Palindrome {

    public boolean isPalindrome(int x) {
        boolean isPalindrome = true;
        String value = String.valueOf(x);
        int midIndex = value.length() % 2 == 0 ? value.length() / 2 : value.length() / 2 + 1;
        int end = value.length() - 1;
        for (int i = 0; i < midIndex; i++) {
            char startC = value.charAt(i);
            char endC = value.charAt(end - i);
            if (startC != endC) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
}
