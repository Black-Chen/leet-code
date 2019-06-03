package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * KeybordRow
 *
 * @author black
 * @date 2019/6/3
 */
public class KeyboardRow {
    private static HashSet<Character> ROW_1 = new HashSet<>(Arrays.asList('q','w','e','r','t','y','u','i','o','p','Q','W','E','R','T','Y','U','I','O','P'));
    private static HashSet<Character> ROW_2 = new HashSet<>(Arrays.asList('a','s','d','f','g','h','j','k','l','A','S','D','F','G','H','J','K','L'));
    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            char first = words[i].charAt(0);
            int row = getRow(first);
            boolean canAdd = true;
            for (int j = 1; j < words[i].length(); j++) {
                if (row != getRow(words[i].charAt(j))) {
                    canAdd = false;
                    break;
                }
            }
            if (canAdd) {
                result.add(words[i]);
            }
        }
        return result.toArray(new String[result.size()]);
    }

    private static int getRow(char c) {
        if (ROW_1.contains(c)) {
            return 1;
        } else if (ROW_2.contains(c)) {
            return 2;
        } else {
            return 3;
        }
    }
}
