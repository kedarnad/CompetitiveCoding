public class RotateLinkedList {

    public static void main(String[] args) {
        RotateLinkedList rl = new RotateLinkedList();
        Node head = rl.BuildLinkedlistFromArray(new int[]{3, 2, 1});
        rl.printLL(head);
        System.out.println();
        head = rl.reverse(head);
        rl.printLL(head);

        System.out.println();

        head = rl.rev(head);
        rl.printLL(head);
    }

    public void printLL(Node head) {
        Node runner = head;
        while (runner != null) {
            System.out.print(runner.val + "\t");
            runner = runner.next;
        }
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

    Node reverse(Node head) {

        return reverseHelp(head, null);
    }

    Node reverseHelp(Node head, Node runner) {
        if (head == null) return runner;
        else {

            Node temp = head;
            head = head.next;
            temp.next = runner;
            runner = temp;
            return reverseHelp(head, runner);
        }

    }

    Node rev(Node head) {
        if (head == null || head.next == null) return head;

        Node temp = head.next;
        Node revNode = rev(temp);
        revNode.next = head;
        head.next = null;
        return revNode;
    }
}
