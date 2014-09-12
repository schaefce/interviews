package eopi.searching.Q3;

/*
 * 11.3 Design an efficient algorithm that takes a sorted array A of distinct
 * integers, and returns an index i such that A[i] = i or indicate that no such
 * index exists by returning -1.
 */

public class FindIndexMatchesValue {

    public static int findIndexMatchesValue(int[] A) {
        int l = 0;
        int r = A.length - 1;
        int mid, val;
        while (l <= r) {
            mid = (l + r) / 2;
            val = A[mid];
            if (val == mid) {
                return mid;
            } else if (val < mid) { // A[i] < i
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] hasMatch = { -5, -4, 0, 3, 7, 10 };
        int[] noMatch = { -10, 2, 3, 4, 5 };
        assert (findIndexMatchesValue(hasMatch) != -1);
        assert (findIndexMatchesValue(noMatch) == -1);
    }

}
