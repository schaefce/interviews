package arraysAndStrings.arrays.programCreek;

import java.util.Arrays;
import java.util.Random;

/* kth largest element in array */

public class KthLargest {

    public static int quickSelect(int[] A, int k) {
        return quickSelect(A, 0, A.length - 1, k);
    }

    private static int quickSelect(int[] A, int lo, int hi, int k) {
        if (lo < hi) {
            int pivot = partition(A, lo, hi);
            if (pivot == k) {
                return A[k];
            }
            if (pivot > k) {
                return quickSelect(A, lo, pivot, k);
            } else {
                return quickSelect(A, pivot + 1, hi, k);
            }
        }
        return Integer.MIN_VALUE;
    }

    private static int partition(int[] arr, int lo, int hi) {
        Random r = new Random();
        int pivotIndex = r.nextInt(hi - lo) + lo;
        swap(arr, lo, pivotIndex);
        System.out.println(Arrays.toString(arr));
        int pivot = arr[lo];// arr[lo + (hi - lo) / 2];
        int i = lo + 1;
        int j = hi;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(arr, i, j);
            }
        }
        swap(arr, lo, j);
        System.out.println(pivot + ":\n\t" + Arrays.toString(arr));
        return j;

    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = { 9, 3, 6, 2, 5, 8, 7, 4, 1, 10 };
        System.out.println(quickSelect(array, 5));
    }
}
