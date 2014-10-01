package sorting.programCreek;

import java.util.Arrays;

/* Sort an integer array in O(n log n) time using linear space complexity. */
public class MergeSort {

    public static void sort(int[] array) {
        int[] aux = new int[array.length];
        sort(array, aux, 0, array.length - 1);

    }

    private static void sort(int[] array, int[] aux, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(array, aux, left, mid);
            sort(array, aux, mid + 1, right);
            merge(array, aux, left, mid, right);
        }
    }

    private static void merge(int[] array, int[] aux, int left, int mid,
            int right) {
        for (int k = left; k <= right; k++) {
            aux[k] = array[k];
        }
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (aux[i] <= aux[j]) {
                array[k] = aux[i++];
            } else {
                array[k] = aux[j++];
            }
            k++;
        }
        while (i <= mid) {
            array[k++] = aux[i++];
        }

    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 7, 3, 10, 40, 1, -1, 4 };
        System.out.println("Unsorted: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));
    }

}
