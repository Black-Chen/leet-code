package medium;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * LetterCombinationsOfPhoneNumber
 *
 * @author black
 * @date 2019-08-06
 */
public class LetterCombinationsOfPhoneNumber {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23456789"));
    }

    private static char[][] phoneNumber = new char[][] {
            {},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r', 's'},
            {'t','u', 'v'},
            {'w','x', 'y', 'z'}
    };

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.trim().length() == 0) {
            return result;
        }
        Pair<int[], Integer> pair = calcIndex(digits);
        int[] indexes = pair.getKey();
        Integer loopSize = pair.getValue();
        StringBuilder[] builders = new StringBuilder[loopSize];
        int index = 0;
        for (int i = 0; i < indexes.length; i++) {
            index = 0;
            loopSize = loopSize / phoneNumber[indexes[i]].length;
            while (index < builders.length) {
                for (int j = 0; j < phoneNumber[indexes[i]].length; j++) {
                    for (int k = 0; k < loopSize; k++) {
                        builders[index] = builders[index] == null ? new StringBuilder() : builders[index];
                        builders[index].append(phoneNumber[indexes[i]][j]);
                        index++;
                    }
                }
            }
        }
        for (int i = 0; i < builders.length; i++) {
            result.add(builders[i].toString());
        }
        return result;
    }

    private static Pair<int[], Integer> calcIndex(String digits) {
        int[] indexes = new int[digits.length()];
        Integer result = 1;
        for (int i = 0; i < digits.length(); i++) {
            indexes[i] = digits.charAt(i) - '0' - 1;
            if (phoneNumber[indexes[i]].length > 0) {
                result *= phoneNumber[indexes[i]].length;
            }
        }
        return new Pair<>(indexes, result);
    }
}
