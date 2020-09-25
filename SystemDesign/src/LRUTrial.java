import java.util.HashMap;
import java.util.Map;

class LRU_node1 {
    int key;
    int val;
    LRU_node1 prev;
    LRU_node1 next;

    LRU_node1() {

    }
}

public class LRUTrial {
    // making a doubly linkedList
    LRU_node1 head;
    LRU_node1 tail;
    Map<Integer, LRU_node1> map;
    int size;

    LRUTrial(int size) { // defining the search strategy for the LRU cache
        head = new LRU_node1();
        tail = new LRU_node1();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        this.size = size;
    }

    public static void main(String[] args) {
        LRUTrial lru = new LRUTrial(3);

        lru.put(1, 3);
        lru.put(2, 14);
        lru.put(3, 9);
        System.out.println(lru);
        lru.put(4, 16);
        System.out.println(lru);
    }

    public int get(int key) {
        LRU_node1 node = map.get(key);

        if (node == null) {
            return -1;
        } else {
            remove(node);
            add(node);
            return node.val;
        }
    }


    // making an auxilary add and remove operations:

    public void put(int key, int val) {
        LRU_node1 node = map.get(key);
        if (node == null) {
            node = new LRU_node1();
            node.key = key;
            node.val = val;
//            map.put(key, node);

            if (map.size() == this.size) {
                LRU_node1 temp = this.head.next;
                map.remove(temp.key);
                remove(temp);
            }

            map.put(key, node);
            add(node);
        } else {
            remove(node);
            node.key = key;
            node.val = val;
            map.put(key, node);
            add(node);
        }
    }

    public void remove(LRU_node1 node) {
        LRU_node1 prev = node.prev;
        LRU_node1 next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void add(LRU_node1 node) {
        LRU_node1 parent = tail.prev;
        parent.next = node;
        node.prev = parent;
        node.next = tail;
        tail.prev = node;

    }

    public String toString() {
        System.out.println("Current Buffer : ");
        String result = "";
        LRU_node1 temp = this.head;
        temp = temp.next;
        while (temp != this.tail) {
            result += "key:" + temp.key + " val:" + temp.val + "\n";
            temp = temp.next;

        }
        return result;
    }

}
