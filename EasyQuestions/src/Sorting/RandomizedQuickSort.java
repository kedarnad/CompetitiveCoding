package Sorting;

import java.util.Random;

public class RandomizedQuickSort {
    public static void main(String[] args) {
        int[] arr = {9, 0, 1, 3, 4, 5, 2, 9, 8, 7, 6, 5, 9, 1, 0, 9};
        RandomizedQuickSort rqs = new RandomizedQuickSort();
        rqs.quickSort(arr);
        for (int i : arr) System.out.print(i + " ");
    }

    /**
     * this is an implementation of randomized quicksort which is faster than the normal quicksort;
     *
     * @param A
     */


    public void quickSort(int[] A) {
        QS(A, 0, A.length - 1);
    }

    public void QS(int[] A, int left, int right) {
        if (left < right + 1) {
            int pivot = partition(A, left, right);
            QS(A, left, pivot - 1);
            QS(A, pivot + 1, right);
        }
    }

    public int getPivot(int left, int right) {
        Random rand = new Random();
        return rand.nextInt((right - left) + 1) + left;
    }

    public void swap(int[] A, int left, int right) {
        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;
    }

    public int partition(int[] A, int left, int right) {

        swap(A, left, getPivot(left, right));
        int border = left + 1;

        for (int i = border; i <= right; i++) {

            if (A[i] < A[left]) {
                swap(A, i, border++);
            }
        }
        swap(A, left, border - 1);
        return border - 1;
    }
}
