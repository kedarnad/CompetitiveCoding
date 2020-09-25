import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class LRUNode<T, U> {
    /**
     * Defining a LRUNode for the doubly linked list:
     */

    T key;
    U value;
    LRUNode<T, U> prev;
    LRUNode<T, U> next;

    public LRUNode() {
    }

    public LRUNode(T key, U value) {
        this.key = key;
        this.value = value;
    }
}


class LRUCache<K, V> {
    Map<K, LRUNode<K, V>> map;
    LRUNode<K, V> head;
    LRUNode<K, V> tail;
    /**
     * Defining a driver class of the working module of LRU cache:
     */
    private int capacity;

    //defining a constructor :

    LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        this.head = new LRUNode<>();
        this.tail = new LRUNode<>();

        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
    }


    public void add(LRUNode<K, V> node) {
        /**
         * Defining an add method
         */

        LRUNode<K, V> prev = this.tail.prev;
        prev.next = node;
        node.next = tail;
        tail.prev = node;
        node.prev = prev;
        return;
    }

    public void remove(LRUNode<K, V> node) {
        /**
         * Defining a remove method.
         */

        LRUNode<K, V> prev = node.prev;
        LRUNode<K, V> next = node.next;
        prev.next = next;
        next.prev = prev;
        return;
    }

    public void put(K key, V value) {
        // adding a function that returns a put value of the generics return type:

        LRUNode<K, V> node = this.map.get(key);
        if (node != null) {
            remove(node);
            node.value = value;
            add(node);
        } else {
            node = new LRUNode<>();
            node.key = key;
            node.value = value;
            if (map.size() == this.capacity) {
                map.remove(this.head.next.key);
                remove(this.head.next);
            }
            add(node);
            map.put(key, node);
        }
    }

    public V get(K key) {
        /**
         * getting the value of the hashmap from the list :
         */

        LRUNode<K, V> tempNode = this.map.get(key);
        if (tempNode == null)
            return null;
        else {
            remove(tempNode);
            add(tempNode);
            return tempNode.value;
        }
//        return tempNode.value;
    }


    public String toString() {
        String result = "";
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<K, V> me = (Map.Entry<K, V>) iter.next();
            LRUNode<K, V> temp = (LRUNode<K, V>) me.getValue();
            result += "Key : " + me.getKey() + " Value : " + temp.value + "\n";
        }
        return result;
    }
}


public class LeastRecentlyUsed {

    private LRUCache<Integer, Integer> lru;

    public LeastRecentlyUsed(int size) {
        this.lru = new LRUCache<>(size);
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> lru = new LRUCache<>(3);


        lru.put(2, 4);
        lru.put(3, 5);
        lru.put(5, 4);

        System.out.println(lru);


        lru.put(7, 9);
        lru.put(8, 10);
        System.out.println(lru);

        System.out.println(lru.get(7));
        System.out.println(lru);


        LRUCache<String, String> lru2 = new LRUCache<>(3);
        lru2.put("hello", "world");
        lru2.put("hello", "hi");
        System.out.println(lru2);

    }


}
