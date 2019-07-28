package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GroupAngrams
 *
 * @author black
 * @date 2019-07-26
 */
public class GroupAngrams {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[] {"ado","lea"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return lists;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int size = str.length();
            int[] val = new int[26];
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < size; i++) {
                val[str.charAt(i) - 'a']++;
            }
            for (int i = 0; i < val.length; i++) {
                if (val[i] > 0) {
                    key.append('#').append(i).append('#').append(val[i]);
                }
            }
            List<String> same = map.getOrDefault(key.toString(), new ArrayList<>());
            if (same.size() == 0) {
                map.put(key.toString(), same);
            }
            same.add(str);
        }
        lists.addAll(map.values());
        return lists;
    }
}
