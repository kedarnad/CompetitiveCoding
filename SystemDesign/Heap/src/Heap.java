import java.util.Arrays;

public class Heap {
    int capacity;
    int currSize;
    int[] items;
    boolean isMax = true;

    Heap(int size) {
        this.capacity = size;
        this.items = new int[this.capacity];
        this.currSize = -1;
    }

    private void siftUp() {
        int index = this.currSize;

        while (index > 0) {
            int currItem = this.items[index];
            int parent = this.items[(index - 1) / 2];


            if (currItem > parent) {
                this.items[(index - 1) / 2] = currItem;
                this.items[index] = parent;
                index = (index - 1) / 2;
            } else break;
        }
    }

    private void siftDown() {
        int k = 0;
        int l = 2 * k + 1;

        while (l <= this.currSize) {
            int r = l + 1;
            int max = l;

            if (r < this.capacity) {
                if (this.items[r] > this.items[max]) max++;
            }

            if (this.items[k] < this.items[max]) {
                int temp = this.items[max];
                this.items[max] = this.items[k];
                this.items[k] = temp;

                k = max;
                l = 2 * k + 1;
            } else
                break;
        }
    }

    public int peek() {
        if (this.currSize == -1) return -1;
        return this.items[0];
    }

    public int pop() {
        if (this.currSize == -1) return -1;

        int result = this.items[0];
        this.items[0] = this.items[this.currSize];
        this.items[currSize] = 0;
        this.currSize--;
        this.siftDown();
        return result;
    }

    public boolean add(int element) {
        if (this.currSize == this.capacity - 1) return false;
        this.items[++currSize] = element;
        this.siftUp();
        return true;
    }


    public String toString() {
        return Arrays.toString(this.items);
    }
}
