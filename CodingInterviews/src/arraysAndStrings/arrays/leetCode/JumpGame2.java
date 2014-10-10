package arraysAndStrings.arrays.leetCode;

import java.util.Arrays;

public class JumpGame2 {
    public static int jump(int[] A) {
        int coverage = 0, maxCoverage = 0, jumps = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > coverage) {
                coverage = maxCoverage;
                jumps++;
            }
            maxCoverage = Math.max(maxCoverage, A[i] + i);
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[][] A = { { 1, 2, 1, 1, 1 }, { 1, 2, 3 }, { 2, 3, 1, 1, 4 } };
        for (int i = 0; i < A.length; i++) {
            System.out.printf("Input:\t%s\nOutput:\t%d\n",
                    Arrays.toString(A[i]), jump(A[i]));
        }
    }
}
