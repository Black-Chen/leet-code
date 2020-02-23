package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * RestoreIPAddresses
 *
 * @author black
 * @date 2020-02-23
 */
public class RestoreIPAddresses {

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("0000"));
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() > 12) {
            return result;
        }
        for (int i = 1; i < s.length() - 2; i++) {
            String a = s.substring(0, i);
            if (isValid(a)) {
                for (int j = i + 1; j < s.length() - 1; j++) {
                    String b = s.substring(i, j);
                    if (isValid(b)) {
                        for (int k = j + 1; k < s.length(); k++) {
                            String c = s.substring(j, k);
                            if (isValid(c)) {
                                String d = s.substring(k);
                                if (isValid(d)) {
                                    StringBuilder builder = new StringBuilder();
                                    builder.append(a).append(".").append(b)
                                            .append(".").append(c)
                                            .append(".").append(d);
                                    result.add(builder.toString());
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    private static boolean isValid(String address) {
        Integer ip = Integer.valueOf(address);
        if (address.startsWith("0") && address.length() > 1) {
            return false;
        }
        return ip >= 0 && ip <= 255;
    }
}
