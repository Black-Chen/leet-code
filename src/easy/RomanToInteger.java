package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * easy.RomanToInteger
 *
 * @author black
 * @date 2019/6/1
 */
public class RomanToInteger {

    private static final HashMap<Character, Integer> romanMap;
    private static final List<Character> romans = Arrays.asList('M','D','C','L','X','V','I');

    static {
        romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("MDCCCLXXXIV"));
    }

    public static int romanToInt(String s) {
        HashMap<Character, List<Integer>> charIndexMap = new HashMap<>(romans.size());
        List<Integer> processedIndex = new ArrayList<>(s.length());
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            List<Integer> index = charIndexMap.getOrDefault(c, new ArrayList<>());
            index.add(i);
            charIndexMap.put(c, index);
        }
        for (int j = romans.size() - 1; j >= 0; j--) {
            char c = romans.get(j);
            List<Integer> index = charIndexMap.getOrDefault(c, new ArrayList<>());
            for (int i = index.size() - 1; i >= 0; i--) {
                int ind = index.get(i);
                if (processedIndex.contains(ind)) {
                    continue;
                }
                int value = romanMap.get(c);
                int next = ind + 1;
                if (next >= s.length()) {
                    result += value;
                    processedIndex.add(ind);
                    continue;
                }
                int nextValue = romanMap.get(s.charAt(next));
                if (!processedIndex.contains(next)) {
                    if (nextValue > value) {
                        result += nextValue - value;
                        processedIndex.add(next);
                        processedIndex.add(ind);
                        continue;
                    } else {
                        for (int k = ind + 1; k < s.length(); k++) {
                            if (!processedIndex.contains(k)) {
                                int val = romanMap.get(s.charAt(k));
                                result += val;
                                processedIndex.add(k);
                            } else {
                                break;
                            }
                        }
                        result += value;
                        processedIndex.add(ind);
                        continue;
                    }
                }
                result += value;
                processedIndex.add(ind);
            }
        }

        return result;
    }
}
