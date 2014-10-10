package arraysAndStrings.arrays.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * For example, [1,1,2] have the following unique permutations: [1,1,2],
 * [1,2,1], and [2,1,1].
 */
public class UniquePermutations {
    public static List<List<Integer>> permuteUnique(int[] num) {
        Map<Integer, Integer> freqs = new HashMap<Integer, Integer>();
        for (int a : num) {
            if (!freqs.containsKey(a)) {
                freqs.put(a, 1);
            } else {
                freqs.put(a, freqs.get(a) + 1);
            }
        }
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        uniquePerm(num.length, freqs, new LinkedList<Integer>(), ret);
        return ret;
    }

    private static void uniquePerm(int len, Map<Integer, Integer> freqs,
            LinkedList<Integer> curr, List<List<Integer>> ret) {
        if (len == 0) {
            ret.add(new LinkedList<Integer>(curr));
        } else {
            for (Map.Entry<Integer, Integer> entry : freqs.entrySet()) {
                int key = entry.getKey();
                int prev = entry.getValue();
                if (prev == 0) {
                    continue;
                } else {
                    freqs.put(key, prev - 1);
                    curr.push(key);
                    uniquePerm(len - 1, freqs, curr, ret);
                    curr.pop();
                    freqs.put(key, prev);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = { { 3, 4, 2 }, { 1, 1, 3 }, { 2, 2, 2 } };
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> output = permuteUnique(nums[i]);
            System.out.printf("Input:\t%s\n", Arrays.toString(nums[i]));
            System.out.println("Output:");
            for (List<Integer> list : output) {
                System.out.printf("\t%s\n", Arrays.toString(list.toArray()));
            }
            System.out.println();
        }
    }
}
