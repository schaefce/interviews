package sortingAndSearching.ctci.Q1;

import java.util.Arrays;

/*
 * 
 */
public class MergeBIntoA {

    public static void merge(int[] A, int[] B, int lastA, int lastB) {
        int indexA = lastA - 1;
        int indexB = lastB - 1;
        int indexMerged = lastA + lastB - 1;

        while (indexB >= 0) {
            if (B[indexB] > A[indexA]) {
                A[indexMerged] = B[indexB];
                indexB--;
            } else {
                A[indexMerged] = A[indexA];
                indexA--;
            }
            indexMerged--;
        }
    }

    public static void main(String[] args) {
        int[] A = new int[40];
        int[] B = new int[20];
        for (int i = 0; i < 20; i++) {
            A[i] = i;
            B[i] = i + 2;
        }
        System.out.println(String.format("Array A: %s", Arrays.toString(A)));
        System.out.println(String.format("Array B: %s", Arrays.toString(B)));
        merge(A, B, 20, 20);
        System.out.println(String.format("Array A: %s", Arrays.toString(A)));
    }

}
