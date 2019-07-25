import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * MSInterviewSolutionII
 *
 * @author black
 * @date 2019-07-25
 */
public class MSInterviewSolutionII {

    public static void main(String[] args) {
        System.out.println(Calculate.calculate("10+20*20/20-20"));
    }

    public static class Calculate {
        private static Map<Character, Integer> operatorPriorityMap;

        static {
            operatorPriorityMap = new HashMap<>();
            operatorPriorityMap.put('+', 1);
            operatorPriorityMap.put('-', 1);
            operatorPriorityMap.put('*', 2);
            operatorPriorityMap.put('/', 2);
        }

        public static int calculate(String str) {
            Stack<Integer> nums = new Stack<>();
            Stack<Character> oper = new Stack<>();
            StringBuilder num = new StringBuilder();
            int result = 0;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (!operatorPriorityMap.containsKey(ch)) {
                    num.append(ch);
                } else {
                    int val = Integer.valueOf(num.toString());
                    num = new StringBuilder();
                    int priority = operatorPriorityMap.get(ch);
                    int lastPriority = oper.isEmpty() ? 0 : operatorPriorityMap.get(oper.peek());
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
}
