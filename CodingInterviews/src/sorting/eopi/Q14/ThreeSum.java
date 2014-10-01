package sorting.eopi.Q14;

import java.util.Arrays;

/*
 * 13.14 Let A be an array of n numbers. Let t be a number, and k be an integer
 * in [1,n]. Define A to k-create t iff there exists k indices i0, i1, ..., 1k-1
 * (not necessarily distinct) such that sum(j=0 to k-1)A[ij] = t. Design an
 * algorithm that takes as input an array A and a number t and determines if A
 * 3-creates t.
 */
public class ThreeSum {
    public static boolean threeSum(int[] A, int t) {
        Arrays.sort(A);
        for (int a : A) {
            if (twoSum(A, t - a)) {
                return true;
            }
        }
        return false;
    }

    private static boolean twoSum(int[] A, int t) {
        int j = 0;
        int k = A.length - 1;
        int sum = 0;
        while (j <= k) {
            sum = A[j] + A[k];
            if (sum == t) {
                return true;
            } else if (sum < t) {
                j++;
            } else {
                k--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A = { 1, 4, 6, -2, -6, 5, 9 };
        System.out.println(Arrays.toString(A));
        System.out.println("Does A 3-create 8? " + threeSum(A, 8));
        System.out.println("Does A 3-create 0? " + threeSum(A, 0));
    }

}
