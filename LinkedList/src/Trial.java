class Wrapper {
    public Node head;
}

public class Trial {
    public static void main(String[] args) {

        Trial trial = new Trial();

        Node l1 = trial.BuildLinkedlistFromArray(new int[]{2, 3, 4, 5, 6});

        Node l2 = l1;

        Wrapper wrapper = new Wrapper();
        wrapper.head = l1;

        l1 = l1.next;

        System.out.println("l1 : " + l1.val);
        System.out.println("l2 : " + l2.val);
        System.out.println("wrappper " + wrapper.head.val);

    }

    Node BuildLinkedlistFromArray(int[] arr) {
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
}
