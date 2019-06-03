package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * FizzBuzz
 *
 * @author black
 * @date 2019/6/3
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            StringBuilder builder = new StringBuilder();
            if (i % 3 == 0) {
                builder.append("Fizz");
            }
            if (i % 5 == 0) {
                builder.append("Buzz");
            }
            if (builder.length() == 0) {
                builder.append(i);
            }
            result.add(builder.toString());
        }
        return result;
    }
}
