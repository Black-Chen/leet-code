package medium;

import java.util.LinkedList;

/**
 * LRUCache
 *
 * @author black
 * @date 2019/6/3
 */
public class LRUCache {

    private int capacity;

    private class Node {
        private int key;
        private int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node> cacheList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheList = new LinkedList<>();
    }

    public int get(int key) {
        for (Node node : cacheList) {
            if (node.key == key) {
                cacheList.remove(node);
                cacheList.addFirst(node);
                return node.value;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        boolean contains = false;
        for (Node node : cacheList) {
            if (node.key == key) {
                cacheList.remove(node);
                cacheList.addFirst(new Node(key, value));
                contains = true;
                break;
            }
        }
        if (!contains) {
            cacheList.addFirst(new Node(key, value));
        }
        if (cacheList.size() > capacity) {
            cacheList.removeLast();
        }
    }
}
