import java.util.LinkedList;
import java.util.List;

class HashNode<U, V> {
    final U key;
    V value;
    HashNode<U, V> next;

    // defining the constructor:
    HashNode(U key, V value, HashNode<U, V> node) {
        this.key = key;
        this.value = value;
        this.next = node;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof HashNode) {
            HashNode currNode = (HashNode) obj;
            return this.key.equals(currNode.key) && this.value.equals(currNode.value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = 17 * hash + (key == null ? 0 : key.hashCode());
        hash = 17 * hash + (value == null ? 0 : value.hashCode());
        return hash;
    }

    @Override
    public String toString() {
        return "{" + this.key + ":" + this.value + "}"; // returning the toString variable function:
    }
}

class HashTable<U, V> {
    private final double threshold = 0.75;
    HashNode<U, V>[] entry; // defining my HashNode datastructure:
    int size = 0;
    private int capacity = 16; // setting the initial size to 16:

    HashTable() {
        this(16);
    }

    HashTable(int capacity) {
        this.capacity = capacity;
        this.entry = new HashNode[capacity];
    }


    public void put(U key, V value) {
        if (this.size == threshold * this.capacity) {
            // code for rehashing the values:

            HashNode<U, V>[] old = entry;
            entry = new HashNode[2 * this.capacity];
            this.size = 0;

            for (HashNode<U, V> trav : old) {
                HashNode<U, V> temp = trav;
                while (temp != null) {
                    put(temp.key, temp.value);
                }
            }
        }

        HashNode<U, V> currNode = new HashNode<>(key, value, null);
        int hash = getHashCode(currNode.key);
        int bucket = hash % getBucketSize();

        HashNode<U, V> head = this.entry[bucket];
        while (head != null && head.next != null) {
            if (head.key == currNode.key) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        if (head == null) {
            this.entry[bucket] = currNode;
            this.size++;
            return;
        }

        if (head.key.equals(currNode.key)) {
            head.value = currNode.value;
            return;
        }
        head.next = currNode;
        this.size++;
//        return;
    }

    public int getBucketSize() {
        return this.entry.length;
    }

    public int getHashCode(U key) {
        return key == null ? 0 : key.hashCode();
    }

    public V get(U key) {
        HashNode<U, V> currNode = entry[getHashCode(key) % getBucketSize()];
        while (currNode != null) {
            if (currNode.key.equals(key)) return currNode.value;
            currNode = currNode.next;
        }
        return null;
    }


    @Override
    public String toString() {
        StringBuilder sbr = new StringBuilder();

        for (HashNode<U, V> trav : entry) {
            HashNode<U, V> temp = trav;
            while (temp != null) {
                sbr.append("{" + temp.key + ":" + temp.value + "}" + "\n");
                temp = temp.next;
            }
        }

        return sbr.toString();
    }


}


public class DesignHashTable {
    public static void main(String[] args) {
        HashTable<String, Integer> map = new HashTable<>();
        map.put("Kedar", 3000);
        map.put("Kascilas", 1000);


        System.out.println(map.get("Kascilas"));

        List<Integer> temp = new LinkedList<>();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        temp.add(4);
        temp.add(5);
        temp.add(6);
        temp.add(7);
        temp.add(8);


        double index = Math.random() * (temp.size());


    }
}
