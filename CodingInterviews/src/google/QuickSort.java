package google;

import java.util.Arrays;

public class QuickSort {
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int left, int right) {
        if (left >= right)
            return;
        int index = partition(array, left, right);
        sort(array, left, index - 1);
        sort(array, index, right);
    }

    public static int partition(int[] array, int left, int right) {
        int pivot = array[(left + right) / 2];
        while (left <= right) {
            // find element on left that should be on right
            while (array[left] < pivot)
                left++;
            // find element on right that should be on left
            while (array[right] > pivot)
                right--;
            if (left < right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left; // array[0...left] < array[left] < array[left... end]
    }

    public static void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = { -1, 2, 5, 7, 3, 10, 40, 1, 7, -1, 4, 10 };
        System.out.println("Unsorted: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));
    }
}
