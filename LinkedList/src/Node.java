public class Node {
    public int val;
    public Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }


    public void printLL(Node head) {
        Node runner = head;
        while (runner != null) {
            System.out.print(runner.val + "\t");
            runner = runner.next;
        }
    }
}
