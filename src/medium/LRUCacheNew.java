package medium;

import java.util.HashMap;

/**
 * LRUCacheNew
 *
 * @author black
 * @date 2019-09-07
 */
public class LRUCacheNew {

    public static void main(String[] args) {
        LRUCacheNew cache = new LRUCacheNew(2);
        cache.put(2,1);
        cache.put(3,2);
        cache.get(3);
        cache.get(2);
        cache.put(4,3);
        cache.get(2);
        cache.get(3);
        cache.get(4);
    }

    public class CacheNode {
        Integer key;
        Integer value;
        CacheNode pre;
        CacheNode next;

        public CacheNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    int size;
    HashMap<Integer, CacheNode> set;
    CacheNode head;
    CacheNode tail;

    public LRUCacheNew(int size) {
        this.size = size;
        this.set = new HashMap(size);
        this.head = null;
        this.tail = null;
    }

    public void put(Integer key, Integer value) {
        CacheNode current = set.get(key);
        if (current == null) {
            current = new CacheNode(key, value);
            if (set.size() == size) {
                set.remove(tail.key);
                if (set.isEmpty()) {
                    head = current;
                    tail = current;
                } else {
                    tail = tail.pre;
                    tail.next = null;

                    head.pre = current;
                    current.next = head;
                    head = current;
                }
            } else {
                if (head == null) {
                    head = current;
                    tail = current;
                } else {
                    head.pre = current;
                    current.next = head;
                    head = current;
                    if (set.size() == 1) {
                        head.next = tail;
                    }
                }
            }
            set.put(key, current);
        } else {
            current.value = value;
            updateNode(current);
        }
    }

    public Integer get(Integer key) {
        CacheNode current = set.get(key);
        if (current != null) {
            updateNode(current);
            return current.value;
        }
        return null;
    }

    private void updateNode(CacheNode current) {
        if (current != head) {
            if (current.next != null) {
                current.next.pre = current.pre;
            }
            if (current.pre != null) {
                current.pre.next = current.next;
                if (current.next == null) {
                    tail = current.pre;
                }
            }
            head.pre = current;
            current.next = head;
            current.pre = null;
            head = current;
        }
    }
}
