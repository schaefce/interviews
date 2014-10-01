package searching.eopi.Q2;

import java.util.Arrays;

/*
 * 11.2 Design an efficient algorithm that takes a sorted array A and a key k
 * and finds the index of the first occurrence of an element larger than k;
 * return -1 if every element is less than or equal to k
 */

public class FirstLargerThanK {
    public static int findFirstLarger(int[] A, int k) {
        int l = 0;
        int r = A.length - 1;
        int res = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (A[m] > k) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;

    }

    public static void printFirstLarger(int[] A, int k) {
        int i = findFirstLarger(A, k);
        if (i > -1) {
            System.out.println(String.format(
                    "First element larger than %d: %d", k, A[i]));
        } else {
            System.out.println(String.format("No element larger than %d", k));
        }
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(Arrays.toString(A));
        printFirstLarger(A, 7);
        printFirstLarger(A, 11);
    }
}
