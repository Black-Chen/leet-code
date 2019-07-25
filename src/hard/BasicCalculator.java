package hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * BasicCalculator
 *
 * @author black
 * @date 2019-07-25
 */
public class BasicCalculator {

    public static void main(String[] args) {
        System.out.println(calculate("1 + 1"));
        System.out.println(calculate(" 2-1 + 2 "));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    private static Map<Character, Integer> operatorPriorityMap;
    private static Character parenthesesLeft = '(';
    private static Character parenthesesRight = ')';

    static {
        operatorPriorityMap = new HashMap<>();
        operatorPriorityMap.put('+', 1);
        operatorPriorityMap.put('-', 1);
        operatorPriorityMap.put('*', 2);
        operatorPriorityMap.put('/', 2);
    }

    public static int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> oper = new Stack<>();
        StringBuilder num = new StringBuilder();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!operatorPriorityMap.containsKey(ch)) {
                if (ch == ' ') {
                    continue;
                } else if (ch == parenthesesLeft) {
                    oper.push(ch);
                } else if (ch == parenthesesRight) {
                    int val = Integer.valueOf(num.toString());
                    num = new StringBuilder();
                    while (parenthesesLeft != oper.peek()) {
                        val = calc(oper.pop(), nums.pop(), val);
                    }
                    oper.pop();
                    num.append(val);
                } else {
                    num.append(ch);
                }
            } else {
                int val = Integer.valueOf(num.toString());
                num = new StringBuilder();
                int priority = operatorPriorityMap.get(ch);
                int lastPriority = oper.isEmpty() ? 0 : operatorPriorityMap.getOrDefault(oper.peek(), 0);
                if (priority > lastPriority) {
                    oper.push(ch);
                    nums.push(val);
                } else {
                    val = calc(oper.pop(), nums.pop(), val);
                    oper.push(ch);
                    nums.push(val);
                }
            }
        }
        result = Integer.valueOf(num.toString());
        while (!oper.isEmpty()) {
            result = calc(oper.pop(), nums.pop(), result);
        }

        return result;
    }

    private static int calc(char ch, int val1, int val2) {
        int result = 0;
        switch (ch) {
            case '+' : result = val1 + val2; break;
            case '-' : result = val1 - val2; break;
            case '*' : result = val1 * val2; break;
            case '/' : result = val1 / val2; break;
        }
        return result;
    }
}
