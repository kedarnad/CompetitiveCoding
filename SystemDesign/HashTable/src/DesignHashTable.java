import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.hash;

class HashNode<U, V> {
    U key;
    V value;
    Node next;

    HashNode(U key, V value, Node node) {
        this.key = key;
        this.value = value;
        this.next = node;
    }
}


public class DesignHashTable {
    public static void main(String[] args) {
        HashNode<Integer, Integer> hnode = new HashNode<Integer, Integer>(3, 2, null);

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


        System.out.println(hash(index));
        System.out.println(temp.hashCode());

    }
}
