import java.util.Map;
import java.util.HashMap;
/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start
class Trie {

    private Map<Character, Map> node;

    /** Initialize your data structure here. */
    public Trie() {
        this.node = new HashMap<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Map<Character, Map> lastNode = node;
        Map<Character, Map> thisNode = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            thisNode = lastNode.get(word.charAt(i));
            if (thisNode == null) {
                thisNode = new HashMap<>();
                lastNode.put(word.charAt(i), thisNode);
            }
            lastNode = thisNode;
        }
        thisNode.put(' ', null);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Map<Character, Map> lastNode = node;
        Map<Character, Map> thisNode = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            thisNode = lastNode.get(word.charAt(i));
            if (thisNode == null) {
                return false;
            }
            lastNode = thisNode;
        }
        return thisNode.containsKey(' ');
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Map<Character, Map> lastNode = node;
        Map<Character, Map> thisNode = new HashMap<>();
        for (int i = 0; i < prefix.length(); i++) {
            thisNode = lastNode.get(prefix.charAt(i));
            if (thisNode == null) {
                return false;
            }
            lastNode = thisNode;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

