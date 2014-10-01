package sorting.programCreek;

import java.util.Arrays;

public class QuickSort {

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);

    }

    private static void sort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int j = partition(arr, lo, hi);
            sort(arr, lo, j);
            sort(arr, j + 1, hi);
        }
    }

    private static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo + (hi - lo) / 2];
        int i = lo;
        int j = hi;
        while (i < j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        return j;

    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 7, 3, 10, 40, 1, -1, 4 };
        System.out.println("Unsorted: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));
    }

}
