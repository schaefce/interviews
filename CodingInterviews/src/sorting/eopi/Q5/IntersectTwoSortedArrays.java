package eopi.sorting.Q5;

import java.util.ArrayList;
import java.util.List;

/*
 * 13.5 Given sorted arrays A and B of lengths n and m respectively, return an
 * array C containing elements common to A and B. The array C should be free of
 * duplicates. How would you perform this intersection if (1) n is about the
 * same size as m and (2) n << m?
 */

public class IntersectTwoSortedArrays {

    public static List<Integer> intersectSimilarSize(int[] A, int[] B) {
        List<Integer> C = new ArrayList<Integer>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] == B[j] && (i == 0 || A[i] != A[i - 1])) {
                C.add(A[i]);
                i++;
                j++;
            } else if (A[i] < B[j]) {
                i++;
            } else {
                j++;
            }
        }
        return C;

    }

    public static List<Integer> intersectDifferentSize(int[] A, int[] B) {
        List<Integer> C = new ArrayList<Integer>();
        for (int i = 0; i < A.length; i++) {
            if ((i == 0 || A[i] != A[i - 1]) && binarySearch(B, A[i])) {
                C.add(A[i]);
            }
        }
        return C;
    }

    private static boolean binarySearch(int[] arr, int val) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (val == arr[mid]) {
                return true;
            } else if (val > arr[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] b = { 1, 5, 6, 7, 8, 9 };
        int[] a = { 6, 7, 20, 30 };
        System.out.println(intersectSimilarSize(a, b));
        System.out.println(intersectDifferentSize(a, b));

    }
}
