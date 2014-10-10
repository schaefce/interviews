package sorting.programCreek;

import java.util.Arrays;

public class QuickSort {

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);

    }

    private static void sort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int j = partition(arr, lo, hi);
            sort(arr, lo, j - 1);
            sort(arr, j + 1, hi);
        }
    }

    private static int partition(int[] arr, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        int pivotValue = arr[mid];
        int i = lo;
        int j = hi + 1;
        swap(arr, i, mid);

        while (i < j) {
            while (arr[++i] < pivotValue) {
                if (i == hi)
                    break;
            }
            while (arr[--j] > pivotValue) {
                if (lo == j)
                    break;
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
        }
        swap(arr, lo, j);
        return j;

    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }

    public static void main(String[] args) {
        int[] arr = { -1, 2, 5, 3, 40, 1, 10, 7, 10, -1, 4, 10 };
        System.out.println("Unsorted: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));
    }

}
