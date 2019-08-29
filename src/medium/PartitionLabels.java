package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * PartitionLabels
 *
 * @author black
 * @date 2019-08-29
 */
public class PartitionLabels {

    public static void main(String[] args) {

    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        int[] positions = new int[26];
        for (int i = 0; i < S.length(); i++) {
            positions[S.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, positions[S.charAt(i) - 'a']);
            if (i == end) {
                result.add(i - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}
