import java.util.LinkedList;

public class OmkarAkuna {
    public static void main(String[] args) {
        int[] arr = {10, 2, -10, 5, 20};

        int[] arr1 = {3, -4, -3, -5, 0};

        OmkarAkuna omkarAkuna = new OmkarAkuna();
        int max_val = omkarAkuna.getTreeSum(arr1);
        System.out.println(max_val);
    }

    public int getTreeSum(int[] arr) {
        TNode root = createMinBinTree(arr);
//       printBST(root);
        LinkedList<Integer> list = new LinkedList<>();
        createSums(root, list);
        System.out.println(list);

        int max = 0;

        for (int i : list) {
            if (max < i)
                max = i;
        }

        return max;
    }

    public void createSums(TNode root, LinkedList<Integer> list) {

        if (root != null) {
            if (root.parent != null) {
                root.setSum(root.getVal() + root.parent.getSum());
                if (root.left == null && root.right == null)
                    list.add(root.getSum());

            }
            createSums(root.left, list);
            createSums(root.right, list);
        }

    }

    public void printBST(TNode root) {

        if (root != null) {

            System.out.println(root.val);
//            System.out.println("Left");
            printBST(root.left);
//            System.out.println("right");
            printBST(root.right);

        }
    }


    public TNode createMinBinTree(int[] arr) {
        return createMinBinTree(arr, 0);
    }

    public TNode createMinBinTree(int[] arr, int index) {
        if (index >= arr.length) return null;

        TNode tNode = new TNode();
        tNode.setVal(arr[index]);
        if (index == 0)
            tNode.setSum(arr[index]);

        tNode.left = createMinBinTree(arr, index + 1);
        tNode.right = createMinBinTree(arr, index + 2);
        if (tNode.right != null)
            tNode.right.parent = tNode;
        if (tNode.left != null)
            tNode.left.parent = tNode;
        return tNode;
    }

    class TNode {


        public TNode left = null;
        public TNode right = null;

        public TNode parent = null;
        public int sum = 0;
        public int val = 0;


//    TNode(int sum){
//        this.sum=sum;
//    }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }

        public TNode getLeft() {
            return left;
        }

        public void setLeft(TNode left) {
            this.left = left;
        }


        public TNode getRight() {
            return right;
        }

        public void setRight(TNode right) {
            this.right = right;
        }
    }

}
