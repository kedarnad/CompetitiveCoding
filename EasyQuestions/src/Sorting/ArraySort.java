package Sorting;

public class ArraySort {

    public static void main(String[] args) {


        int[] arr = {9, 0, 1, 3, 4, 5, 2, 9, 8, 7, 6, 5, 9, 1, 0, 9};
        ArraySort as = new ArraySort();
        as.QuickSort(arr);
        for (int i : arr) System.out.print(i + " ");
    }

    public void QuickSort(int[] arr) {
        QuickSort(arr, 0, arr.length - 1);
    }

    public void QuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            QuickSort(arr, low, pivot - 1);
            QuickSort(arr, pivot + 1, high);
        }
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int pivot_index = high;
        high--;
//        System.out.println(high);

        while (low < high) {
            while (arr[low] < pivot & low < pivot_index) {
                low++;
            }
            while (arr[high] > pivot & high > 0) {
                high--;
            }
            if (low <= high) {
                swap(arr, low, high);
//                low++;
//                high--;
            }
        }
        if (arr[low] >= arr[pivot_index])
            swap(arr, low, pivot_index);
        return low;
    }

    public void swap(int[] arr, int start, int pivot) {
        int temp = arr[start];
        arr[start] = arr[pivot];
        arr[pivot] = temp;
    }
}
