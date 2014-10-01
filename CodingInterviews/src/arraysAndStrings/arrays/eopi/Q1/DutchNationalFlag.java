package arraysAndStrings.arrays.eopi.Q1;

/*
 * 6.1 Write a function that takes an array A and an index i into A, and
 * rearranges the elements such that all elements less than A[i] appear first,
 * followed by elements equal to A[i], followed by elements greater than A[i].
 * Your algorithm should have O(1) space complexity and O(|A|) time complexity.
 */
import java.util.Arrays;

public class DutchNationalFlag {
    public static void partition(int[] A, int index) {
        int pivot = A[index];
        int smaller = 0; // A[0... smaller-1] < pivot
        int bigger = A.length - 1; // A[bigger + 1... A.length-1] > pivot
        int runner = 0; // A[smaller...runner -1] == pivot

        // A[runner...bigger] unknown
        while (runner <= bigger) {
            // A[runner] is unknown
            if (A[runner] < pivot) {
                // swap runner into end of smaller, increase size of smaller
                swap(A, smaller++, runner++);
            } else if (A[runner] == pivot) {
                // increase size of runner group
                runner++;
            } else {
                // swap runner into beginning of bigger, increase size of bigger
                swap(A, runner, bigger--);
            }
        }
    }

    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = { 7, 9, 1, 2, 20, 3, 4, 5, 6, 7, 8, 3, 7, 10, 1, 7 };
        System.out.println(Arrays.toString(array));
        partition(array, 0);
        System.out.println(Arrays.toString(array));

    }
}
