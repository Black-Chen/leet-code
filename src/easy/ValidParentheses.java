package easy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

/**
 * easy.ValidParentheses
 *
 * @author black
 * @date 2019/6/1
 */
public class ValidParentheses {

    private static HashMap<Character, Character> pair;

    static {
        pair = new HashMap<>();
        pair.put(')', '(');
        pair.put(']', '[');
        pair.put('}', '{');
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));

    }

    public static boolean isValid(String s) {
        boolean result = false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Character value = pair.get(c);
            if (value == null) {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    stack.push(c);
                    break;
                }
                if (!value.equals(stack.pop())) {
                    stack.push(c);
                    break;
                }
            }
        }
        if (stack.empty()) {
            result = true;
        }
        return result;
    }
}
