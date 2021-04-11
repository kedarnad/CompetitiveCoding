
public class Driver {
    public static void main(String[] args) {
        Heap hp = new Heap(5);
        hp.add(1);
        hp.add(2);
        hp.add(3);
        hp.add(4);
        hp.add(5);
//        System.out.println(hp);
        System.out.println(hp.pop());
        System.out.println(hp.pop());
        System.out.println(hp.pop());
        System.out.println(hp.pop());
        System.out.println(hp.pop());


    }
}
