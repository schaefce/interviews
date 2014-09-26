package dynamicProgramming.topCoder;

import java.util.Arrays;

/*
 * A sequence of numbers is called a zig-zag sequence if the differences between
 * successive numbers strictly alternate between positive and negative. The
 * first difference (if one exists) may be either positive or negative. A
 * sequence with fewer than two elements is trivially a zig-zag sequence.
 * 
 * For example, 1,7,4,9,2,5 is a zig-zag sequence because the differences
 * (6,-3,5,-7,3) are alternately positive and negative. In contrast, 1,4,7,2,5
 * and 1,7,4,5,5 are not zig-zag sequences, the first because its first two
 * differences are positive and the second because its last difference is zero.
 * 
 * Given a sequence of integers, sequence, return the length of the longest
 * subsequence of sequence that is a zig-zag sequence. A subsequence is obtained
 * by deleting some number of elements (possibly zero) from the original
 * sequence, leaving the remaining elements in their original order.
 * 
 * Constraints: 1. Sequence contains between 1 and 50 elements, inclusive. 2.
 * Each element of sequence is between 1 and 1000, inclusive.
 */

public class LongestZigZagSubsequence {
    public static int getLASLength(int[] A) {
        int[][] las = getLASArray(A); // new int[N][2];
        int best = 1;
        for (int i = 0; i < A.length; i++) {
            best = Math.max(best, Math.max(las[i][0], las[i][1]));
        }
        return best;
    }

    public static int[] getLAS(int[] A) {
        int[][] las = getLASArray(A);
        int end = 0;
        for (int i = 1; i < A.length; i++) {
            if (Math.max(las[end][0], las[end][1]) < Math.max(las[i][0],
                    las[i][1])) {
                end = i;
            }
        }
        int diff = las[end][0] > las[end][1] ? 0 : 1;
        int[] subseq = new int[las[end][diff]];
        int subN = las[end][diff] - 1;
        subseq[subN] = A[end];

        while (las[end][diff] > 0) {
            int prev = end - 1;
            if (diff == 0) {
                while (prev >= 0
                        && (A[prev] >= A[end] || las[prev][1] != las[end][diff] - 1))
                    prev--;
            } else {
                while (prev >= 0
                        && (A[prev] <= A[end] || las[prev][0] != las[end][diff] - 1))
                    prev--;
            }
            if (prev < 0) {
                break;
            }
            end = prev;
            subN--;
            subseq[subN] = A[end];
            diff = diff == 0 ? 1 : 0;
        }
        return subseq;
    }

    private static int[][] getLASArray(int[] A) {
        int N = A.length;
        int[][] las = new int[N][2];
        for (int i = 0; i < N; i++) {
            las[i][0] = 1;
            las[i][1] = 1;
            for (int j = 0; j < N; j++) {
                if (A[i] - A[j] > 0) { // && lens[j][1] + 1 > lens[i][0]){
                    las[i][0] = Math.max(las[j][1] + 1, las[i][0]);
                } else if (A[i] - A[j] < 0) {// && lens[j][0] + 1 > lens[i][1]){
                    las[i][1] = Math.max(las[j][0] + 1, las[i][1]);
                }
            }
        }
        return las;

    }

    public static void main(String[] args) {
        int[] list = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
        System.out.println(Arrays.toString(list));
        System.out.println(Arrays.toString(getLAS(list)));
        System.out.println((getLASLength(list)));

    }

}
