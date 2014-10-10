package arraysAndStrings.arrays.leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] num, int target) {
        int n = num.length;
        List<List<Integer>> solution = new LinkedList<List<Integer>>();
        if (num == null || n < 4) {
            return solution;
        }
        Arrays.sort(num);
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && num[i] == num[i - 1])
                continue;
            int a = num[i];
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && num[j] == num[j - 1])
                    continue;
                int b = num[j];
                int t = j + 1;
                int f = num.length - 1;
                while (t < f) {
                    int c = num[t];
                    int d = num[f];
                    int sum = a + b + c + d;
                    if (sum > target) {
                        f--;
                    } else if (sum < target) {
                        t++;
                    } else {
                        int[] nums = { a, b, c, d };
                        List<Integer> quad = new LinkedList<Integer>();
                        for (int k : nums) {
                            quad.add(k);
                        }
                        solution.add(quad);
                        do {
                            t++;
                        } while (t < f && num[t] == num[t - 1]);
                        do {
                            f--;
                        } while (t < f && num[f] == num[f + 1]);
                    }

                }
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        int[][] A = { { 0, 0, 0, 0 }, { 1, 0, -1, 0, -2, 2 } };
        int[] targ = { 0, 0 };
        for (int i = 0; i < A.length; i++) {
            System.out
                    .printf("Input: %s, %d\n", Arrays.toString(A[i]), targ[i]);
            List<List<Integer>> quads = fourSum(A[i], targ[i]);
            System.out.printf("Output: [\n");
            for (List<Integer> q : quads) {
                System.out.println("\t" + Arrays.toString(q.toArray()));
            }
            System.out.println(" \t\t]\n");
        }
    }
}
