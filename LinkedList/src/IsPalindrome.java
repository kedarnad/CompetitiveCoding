//import GraphSearch.BFSDFS;
//
//import java.util.Stack;
//
//class Result{
//    public Node node;
//    public boolean result;
//
//    Result(Node node, boolean result){
//        this.node=node;
//        this.result=result;
//    }
//}
//
//public class IsPalindrome {
//
//    Node BuildLinkedlistFromArray(int[] arr){
//        Node head=null;
//        Node node=null;
//        for(int i=0; i <arr.length; i++){
//            if(i==0){
//                head=new Node(arr[0]);
//                node=head;
//            }
//            else{
//                node.next=new Node(arr[i]);
//                node= node.next;
//            }
//        }
//        return head;
//    }
//
//    public void printLL(Node head){
//        Node runner= head;
//        while(runner!=null){
//            System.out.print(runner.val+"\t");
//            runner=runner.next;
//        }
//    }
//
//
//    boolean isPalindromeIterativeApproach(Node list){
//        if(list==null) return true;
//
//        if(list.next==null) return true;
//        Node fast=list;
//        Node slow=list;
//
//        Stack<Integer> stack = new Stack<>();
//
//        while(fast!=null &&
//                fast.next!= null){
//            stack.push(slow.val);
//
//            slow=slow.next;
//            fast=fast.next.next;
//        }
//
//        if(fast==null){ //The linkedlist is odd lengthed
//            slow=slow.next;
//        }
//
//        while(stack.empty()){
//            int top = stack.pop();
//            if(top!=slow.val) return false;
//            slow=slow.next;
//        }
//
//        return true;
//    }
//
//
//    boolean isPalindromeRecursiveApproach(Node head){
//        int length = calculateListLength(head);
//        Result result = isPalindromeRecursiveApproach(head, length);
//        return result.result;
//    }
//
////    Result isPalindromeRecursiveApproach(Node head,int length){
////
////
////
////    }
//
//
//
//    int calculateListLength(Node head){
//
//        if(head==null) return 0;
//        if(head.next==null) return 1;
//        int k =0;
//
//        Node fast= head;
//        while(fast!=null ){
//            k++;
//            fast=fast.next;
//
//        }
//
//        return k;
//
//    }
//
//
//    public static void main(String[] args) {
//        IsPalindrome ispal = new IsPalindrome();
//        Node head = ispal.BuildLinkedlistFromArray(new int[]{2,3,3,2});
//
//        System.out.println(ispal.isPalindromeIterativeApproach(head));
//    }
//
//}
