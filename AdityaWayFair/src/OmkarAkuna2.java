import java.util.LinkedList;

public class OmkarAkuna2 {
    public static void main(String[] args) {

        int[] arr = {10, 2, -10, 5, 20};

        OmkarAkuna2 omkarAkuna = new OmkarAkuna2();
        int max_val = omkarAkuna.getTreeSum(arr, 2);
        System.out.println(max_val);

    }

    public int getTreeSum(int arr[], int k) {
        TNode root = createNArrayTree(arr, 0, k);
        LinkedList<Integer> list = new LinkedList<>();
        createSums(root, list);
        int max = 0;

        for (int i : list) {
            if (max < i)
                max = i;
        }

        return max;

    }

    private void createSums(TNode root, LinkedList<Integer> list) {

        if (root != null) {
            if (root.parent != null) {
                root.setSum(root.getVal() + root.parent.getSum());
                if (root.childNodes[0] == null)
                    list.add(root.getSum());

            }

            for (int i = 0; i < root.childNodes.length; i++) {
                createSums(root.childNodes[i], list);
            }
        }
    }

    private TNode createNArrayTree(int[] arr, int index, int k) {
        if (index >= arr.length) return null;

        TNode tNode = new TNode(arr[index], k);

        if (index == 0) tNode.setSum(arr[index]);

        for (int i = 0; i < k; i++) {
            tNode.childNodes[i] = createNArrayTree(arr, index + i, k);
            if (tNode.childNodes[i] != null)
                tNode.childNodes[i].parent = tNode;
        }

        return tNode;
    }

    class TNode {
        public int val;
        public int sum;
        public int k;
        public TNode parent;
        TNode[] childNodes = new TNode[k];

        TNode(int val, int k) {
            this.val = val;
            this.k = k;
        }

        public void setKNode(int k, TNode node) {
            childNodes[k] = node;
        }

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
    }

}
