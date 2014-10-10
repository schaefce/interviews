package arraysAndStrings.arrays.leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AllPermutations {
    public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if (num != null) {
            permute(num, new boolean[num.length], new LinkedList<Integer>(),
                    num.length, ret);
        }
        return ret;
    }

    private static void permute(int[] A, boolean[] used,
            LinkedList<Integer> curr, int len, List<List<Integer>> ret) {
        if (len == 0) {
            ret.add(new LinkedList<Integer>(curr));
        } else {
            for (int i = 0; i < A.length; i++) {
                if (!used[i]) {
                    curr.push(A[i]);
                    used[i] = true;
                    permute(A, used, curr, len - 1, ret);
                    used[i] = false;
                    curr.pop();
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = { { 3, 4, 2 }, { 1, 1, 3 }, { 2, 2, 2 } };
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> output = permute(nums[i]);
            System.out.printf("Input:\t%s\n", Arrays.toString(nums[i]));
            System.out.println("Output:");
            for (List<Integer> list : output) {
                System.out.printf("\t%s\n", Arrays.toString(list.toArray()));
            }
            System.out.println();
        }
    }
}
