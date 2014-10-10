package arraysAndStrings.arrays.leetCode;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutive {
    public int longestConsecutive(int[] num) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        for (int i = 0; i < num.length; i++) {
            if (map.containsKey(num[i]))
                continue;
            int lo = num[i];
            int hi = num[i];

            if (map.containsKey(num[i] - 1)) {
                lo = map.get(num[i] - 1);
            }
            if (map.containsKey(num[i] + 1)) {
                hi = map.get(num[i] + 1);
            }
            max = (hi - lo + 1) > max ? hi - lo + 1 : max;
            map.put(num[i], num[i]);
            map.put(lo, hi);
            map.put(hi, lo);
        }
        return max;
    }
}