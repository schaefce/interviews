package hashTables.leetCode;

import java.util.HashMap;

/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. set(key, value) - Set or insert the
 * value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new
 * item.
 */

public class LRUCache {
    private int capacity;
    private int count;
    private CacheNode head;
    private CacheNode tail;
    private HashMap<Integer, CacheNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.head = new CacheNode(0, 0);
        this.tail = new CacheNode(0, 0);
        head.next = tail;
        tail.prev = head;
        this.map = new HashMap<Integer, CacheNode>();

    }

    public int get(int key) {
        if (map.containsKey(key)) {
            CacheNode n = map.get(key);
            moveNodeToEnd(n);
            return n.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            updateNode(map.get(key), value);
        } else {
            createAndInsertNode(key, value);
        }
    }

    private void updateNode(CacheNode n, int value) {
        n.value = value;
        moveNodeToEnd(n);
    }

    private void createAndInsertNode(int key, int value) {
        CacheNode n = new CacheNode(key, value);
        insertNode(n);
        map.put(key, n);
    }

    private void insertNode(CacheNode n) {
        setNodeAsEnd(n);
        if (count == capacity) {
            map.remove(head.next.key);
            removeNode(head.next);
        }
        count++;
    }

    private void moveNodeToEnd(CacheNode n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        setNodeAsEnd(n);
    }

    private void removeNode(CacheNode n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        count--;
    }

    private void setNodeAsEnd(CacheNode n) {
        n.prev = tail.prev;
        n.next = tail;
        tail.prev.next = n;
        tail.prev = n;
    }

    class CacheNode {
        CacheNode prev;
        CacheNode next;
        int key;
        int value;

        CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
