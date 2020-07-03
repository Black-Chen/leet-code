import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.isEmpty() || !wordList.contains(endWord)) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 1;
        }
        HashSet<String> steppedWords = new HashSet<>();
        HashSet<String> wordSet = new HashSet<>();
        wordSet.add(beginWord);
        boolean isFound = false;
        int depth = 1;
        while (wordList.size() != steppedWords.size()) {
            HashSet<String> newWordSet = new HashSet<>();
            List<String> remainingList = new ArrayList<>(wordList);
            remainingList.removeAll(steppedWords);
            depth++;
            for (String word : wordSet) {
                for (String remain : remainingList) {
                    int diff = 0;
                    for (int i = 0; i < word.length(); i++) {
                        if (word.charAt(i) != remain.charAt(i)) {
                            diff++;
                            if (diff > 1) {
                                break;
                            }
                        }
                        if (i == word.length() - 1) {
                            steppedWords.add(remain);
                            newWordSet.add(remain);
                        }
                    }
                }
            }
            if (newWordSet.isEmpty()) {
                break;
            }
            if (newWordSet.contains(endWord)) {
                isFound = true;
                break;
            }
            wordSet = newWordSet;
        }
        if (isFound) {
            return depth;
        }
        return 0;
    }
}
// @lc code=end

