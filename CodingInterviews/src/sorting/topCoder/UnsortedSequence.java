package sorting.topCoder;

import java.util.Arrays;

/*
 * We say that the sequence of numbers {s[0], s[1], s[2], ..., s[N-1]} is sorted
 * in ascending order if we have s[i] <= s[i+1] for each i between 0 and N-2,
 * inclusive.
 * 
 * For example, the sequences {1,2,3}, {1,1,1}, and {2,2,4,4,6,6} are sorted in
 * ascending order, but the sequences {1,2,1}, {7,4,6}, and {3,2,1} are not.
 * 
 * You are given the sequence of numbers as a int[] s. Your task is to order the
 * elements of this sequence into a sequence that will NOT be sorted in
 * ascending order. Find and return the lexicographically smallest sequence we
 * can obtain. If there is no possibility to get a sequence that is not sorted
 * in ascending order, return an empty int[] instead.
 * 
 * - Sequence of numbers A is lexicographically smaller than B if A contains a
 * smaller number on the first position on which they differ. - The sequence s
 * may contain duplicates. - Note that the sequence consisting of only one
 * element is always sorted.
 */

public class UnsortedSequence {
    public static int[] unsort(int[] arr) {
        Arrays.sort(arr);
        if (arr[0] == arr[arr.length - 1]) {
            return new int[0];
        }
        int i = arr.length - 2;
        while (arr[i] == arr[i + 1]) {
            i--;
        }
        int temp = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = temp;
        return arr;
    }

    public static void main(String[] args) {
        int[][] inputs = { { 1, 2 }, { 1, 2, 3 }, { 7, 2, 2 }, { 1000 },
                { 1, 1 }, { 1, 2, 4, 3 },
                { 2, 8, 5, 1, 10, 5, 9, 9, 3, 10, 5, 6, 6, 2, 8, 2, 10 } };
        for (int i = 0; i < inputs.length; i++) {
            System.out.printf("%d.\tInput:\t%s\n\tOutput:\t%s\n", i,
                    Arrays.toString(inputs[i]),
                    Arrays.toString(unsort(inputs[i])));
        }
    }

}
