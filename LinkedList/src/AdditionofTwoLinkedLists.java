

public class AdditionofTwoLinkedLists {

    public static void main(String[] args) {
        AdditionofTwoLinkedLists al = new AdditionofTwoLinkedLists();
        Node l1 = al.BuildLinkedlistFromArray(new int[]{7, 1, 6});
        Node l2 = al.BuildLinkedlistFromArray(new int[]{5, 9, 2});
        Node result = al.AddUpTwoLinkedLists(l1, l2, 0);
        al.printLL(result);
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

//
//     Node AddUpTwoLinkedLists(Node l1, Node l2, int carry){
//        if(l1==null && l2==null && carry==0) return null;
//
//        Node result = new Node(0);
//        int value= carry;
//
//        if(l1!=null){
//            value+=l1.val;
//        }
//
//        if(l2!=null){
//            value+=l2.val;
//        }
//
//        result.val= value%10;
//        carry= value/10;
//
//        Node more=null;
//
//        if(l1!=null || l2!=null) more =  AddUpTwoLinkedLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carry);
//
//
//        if(more==null && carry==1)
//            result.next= new Node(1);
//        else
//            result.next= more;
//
//        return result;
//    }

    public void printLL(Node head) {
        Node runner = head;
        while (runner != null) {
            System.out.print(runner.val + "\t");
            runner = runner.next;
        }
    }

    Node AddUpTwoLinkedLists(Node l1, Node l2) {
        return AddUpTwoLinkedLists(l1, l2, 0);
    }

    Node AddUpTwoLinkedLists(Node l1, Node l2, int carry) {

        if (l1 == null && l2 == null && carry == 0) return null;
        int result = 0;

        if (l1 != null) {
            result += l1.val;
        }

        if (l2 != null) {
            result += l2.val;
        }

        result += carry;
        Node resultll = new Node(result % 10);
        resultll.next = AddUpTwoLinkedLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, result / 10);
        return resultll;
    }
}
