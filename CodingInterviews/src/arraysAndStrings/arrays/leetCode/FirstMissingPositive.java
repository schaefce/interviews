package arraysAndStrings.arrays.leetCode;

/*
 * Given an unsorted integer array, find the first missing positive integer. For
 * example, Given [1,2,0] return 3, and [3,4,-1,1] return 2. Your algorithm
 * should run in O(n) time and uses constant space.
 */

public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int curr = A[i];
            if (curr > 0 && curr <= A.length) {
                if (A[i] != A[curr - 1]) {
                    swap(A, i, curr - 1);
                    i--;
                }
            }
        }
        int j = 0;
        while (j < A.length) {
            if (A[j] != j + 1) {
                return j + 1;
            }
            j++;
        }
        return j + 1;
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
