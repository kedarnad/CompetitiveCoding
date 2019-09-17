

public class PartitionLinkedList {

    public static void main(String[] args) {

        PartitionLinkedList pl = new PartitionLinkedList();
        Node head = pl.BuildLinkedlistFromArray(new int[]{3, 8, 5, 10, 2, 1});
        pl.printLL(head);
        head = pl.partition(head, 5);
        System.out.println();
        pl.printLL(head);

    }

    public Node BuildLinkedlistFromArray(int[] arr) {
        Node head = null;
        Node node = null;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                head = new Node(arr[0]);
                node = head;
            } else {
                node.next = new Node(arr[i]);
                node = node.next;
            }
        }
        return head;
    }

    public void printLL(Node head) {
        Node runner = head;
        while (runner != null) {
            System.out.print(runner.val + "\t");
            runner = runner.next;
        }
    }

    public Node partition(Node node, int x) {

        Node before = null;
        Node equalsbefore = null;
        Node after = null;

        while (node != null) {
            Node next = node.next;

            if (node.val < x) {
                node.next = before;
                before = node;

            } else if (node.val > x) {
                node.next = after;
                after = node;
            } else {
                node.next = equalsbefore;
                equalsbefore = node;

            }
            node = next;
        }

        Node runner = before;
        while (runner.next != null) {
            runner = runner.next;
        }
        runner.next = equalsbefore;
        while (runner.next != null) {
            runner = runner.next;
        }
        runner.next = after;
        return before;
    }
}
