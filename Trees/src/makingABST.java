class TreeNode {
    int num;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int num) {
        this.num = num;
        left = null;
        right = null;
    }

}


public class makingABST {

    public static void main(String[] args) {

        makingABST mkBST = new makingABST();
        mkBST.printBST(mkBST.makeABST(new int[]{1, 2, 4, 5, 6}, 0, 4));
    }

    public TreeNode makeABST(int arr[], int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = makeABST(arr, left, mid - 1);
        node.right = makeABST(arr, mid + 1, right);
        return node;

    }

    public void printBST(TreeNode root) {

        if (root != null) {

            System.out.println(root.num);
//            System.out.println("Left");
            printBST(root.left);
//            System.out.println("right");
            printBST(root.right);

        }
    }
}
