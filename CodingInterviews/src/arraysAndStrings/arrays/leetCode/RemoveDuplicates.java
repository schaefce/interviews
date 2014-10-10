package arraysAndStrings.arrays.leetCode;

import java.util.Arrays;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] A) {
        if (A.length < 2) {
            return A.length;
        }
        int k = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i - 1]) {
                A[k++] = A[i];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 2 };
        System.out.printf("Input:\t%s\n", Arrays.toString(A));
        int newLength = removeDuplicates(A);
        System.out.printf("Output:\t%s\n",
                Arrays.toString(Arrays.copyOfRange(A, 0, newLength)));

    }
}
