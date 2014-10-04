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
    class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }

        public Node() {
            this.key = null;
            this.value = null;
            this.prev = null;
            this.next = null;
        }
    }

    class DoubleLinkedList<K, V> {
        public Node<K, V> HEAD = new Node<K, V>();
        public Node<K, V> TAIL = new Node<K, V>();
        private int size;

        public DoubleLinkedList() {
            HEAD.next = TAIL;
            TAIL.prev = HEAD;
            this.size = 0;
        }

        /** Add to tail */
        public void add(K key, V value) {
            Node<K, V> newNode = new Node<K, V>(key, value);
            add(newNode);
        }

        public void add(Node<K, V> newNode) {
            TAIL.prev.next = newNode;
            newNode.prev = TAIL.prev;
            newNode.next = TAIL;
            TAIL.prev = newNode;
            size++;
        }

        /** Remove Node */
        public void remove(Node<K, V> node) {
            if (node == HEAD || node == TAIL || node == null)
                return;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
            size--;
        }

        public Node<K, V> getLast() {
            return HEAD.next == TAIL ? null : HEAD.next;
        }
    }

    /**
     * Use a double linked list to maintain, because need to remove elements
     * very frequently. Single list can be used to implements queue, but queue
     * not appropriate since not support remove any. With three functions, add
     * and remove and geLast, we can maintain a LRU cache.
     */
    private DoubleLinkedList<Integer, Integer> cache;

    /**
     * Double Linked List can add and remove very quick, but can not random
     * access. So here we use a map to record the nodes.
     */
    private Map<Integer, Node<Integer, Integer>> map;
    private int capacity;

    public LRUCache(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException(
                    "Error: Illegal Argument, capacity must be positive.");
        cache = new DoubleLinkedList<Integer, Integer>();
        map = new HashMap<Integer, Node<Integer, Integer>>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node<Integer, Integer> node = map.get(key);
        cache.remove(node);
        cache.add(node);
        return node.value;
    }

    public void set(int key, int value) {
        if (!map.containsKey(key)) {
            /**
             * Design Decision: cache does not maintain size, list should
             * maintain it.
             */
            if (cache.size == capacity) {
                Node<Integer, Integer> last = cache.getLast();
                cache.remove(last);
                map.remove(last.key);
            }
            Node<Integer, Integer> newNode = new Node<Integer, Integer>(key,
                    value);
            cache.add(newNode);
            map.put(key, newNode);
        } else {
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            cache.remove(node);
            cache.add(node);
        }
    }

}