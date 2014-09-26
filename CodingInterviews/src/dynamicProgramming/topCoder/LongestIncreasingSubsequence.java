package dynamicProgramming.topCoder;

import java.util.Arrays;

/*
 * Statement: This is a very standard problem. Given a list of N ordered
 * integers find the longest increasing subsequence in this list. Example: If
 * the list is [16, 3, 5, 19, 10, 14, 12, 0, 15] one possible answer is the
 * subsequence [3, 5, 10, 12, 15], another is [3, 5, 10, 14, 15].
 */

public class LongestIncreasingSubsequence {
    public static int getLISLength(int[] A) {
        int[] lis = getLISArray(A);
        int best = 0;
        for (int i = 0; i < A.length; i++) {
            if (best < lis[i]) {
                best = i;
            }
        }
        return best;
    }

    public static int[] getLIS(int[] A) {
        int[] lis = getLISArray(A);
        int end = 0;
        for (int i = 1; i < A.length; i++) {
            if (lis[end] < lis[i]) {
                end = i;
            }
        }
        int[] subseq = new int[lis[end]];
        int subN = lis[end] - 1;
        subseq[subN] = A[end];
        while (lis[end] > 0) {
            int prev = end - 1;
            while (prev >= 0
                    && (A[prev] >= A[end] || lis[prev] != lis[end] - 1)) {
                prev--;
            }
            if (prev < 0) {
                break;
            }
            end = prev;
            subN--;
            subseq[subN] = A[end];
        }
        return subseq;
    }

    private static int[] getLISArray(int[] A) {
        int N = A.length;
        int[] lis = new int[N]; // lis[i] will be the LIS that ends with A[i]
        for (int i = 0; i < N; i++) {
            lis[i] = 1;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                // lis[i] = 1 + max(A[j] for 0<=j<i)
                if (lis[i] < lis[j] + 1 && A[j] < A[i]) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        return lis;

    }

    public static void main(String[] args) {
        int[] list = { 16, 3, 5, 19, 10, 14, 12, 0, 15 };
        System.out.println(Arrays.toString(list));
        System.out.println(Arrays.toString(getLIS(list)));
        System.out.println((getLISLength(list)));

    }

}
