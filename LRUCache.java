/**
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
    private class DoubleLinkedListNode {
        private int key;
        private int val;
        public DoubleLinkedListNode prev;
        public DoubleLinkedListNode next;

        public DoubleLinkedListNode(int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }

    private class DoubleLinkedList {
        private DoubleLinkedListNode HEAD = new DoubleLinkedListNode(-1, -1);
        private DoubleLinkedListNode TAIL = new DoubleLinkedListNode(-1, -1);

        public DoubleLinkedList() {
            HEAD.next = TAIL;
            TAIL.prev = HEAD;
        }

        public DoubleLinkedListNode getLast() {
            if (TAIL.prev != HEAD)
                return TAIL.prev;
            else
                return null;
        }

        public void remove(DoubleLinkedListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }

        public void moveToFront(DoubleLinkedListNode node) {
            node.next = HEAD.next;
            HEAD.next.prev = node;
            node.prev = HEAD;
            HEAD.next = node;
        }
    }

    private Map<Integer, DoubleLinkedListNode> map = new HashMap<Integer, DoubleLinkedListNode>();
    private DoubleLinkedList cacheList = new DoubleLinkedList();
    private int size = 0;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        int value = -1;
        if (map.containsKey(key)) {
            DoubleLinkedListNode node = map.get(key);
            cacheList.remove(node);
            cacheList.moveToFront(node);
            value = node.val;
        }
        return value;
    }

    public void set(int key, int value) {
        DoubleLinkedListNode node;
        if (map.containsKey(key)) {
            node = map.get(key);
            cacheList.remove(node);
            node.val = value;
        } else {
            if (size == capacity) {
                DoubleLinkedListNode lastNode = cacheList.getLast();
                if (lastNode != null) {
                    cacheList.remove(lastNode);
                    size--;
                    map.remove(lastNode.key);
                }
            }
            node = new DoubleLinkedListNode(key, value);
            size++;
            map.put(key, node);
        }
        cacheList.moveToFront(node);
    }
}