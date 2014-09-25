package programCreek.stringsAndArrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 */

public class WordBreak {

    public static boolean canSegment(String str, Set<String> dict) {
        boolean[] memo = new boolean[str.length() + 1];
        memo[0] = true;
        for (int i = 0; i < str.length(); i++) {
            if (!memo[i]) {
                continue;
            }
            for (String s : dict) {
                int len = s.length();
                int end = i + len;
                if (end > memo.length) {
                    continue;
                }
                if (memo[end]) {
                    continue;
                }
                if (str.substring(i, end).equals(s)) {
                    memo[end] = true;
                }
            }
        }
        return memo[str.length()];
    }

    public static LinkedList<String> doSegment(String str, Set<String> dict) {
        LinkedList<String> segments = new LinkedList<String>();
        int[] memo = new int[str.length() + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        for (int i = 0; i < str.length(); i++) {
            if (memo[i] == -1) {
                continue;
            }
            for (String s : dict) {
                int len = s.length();
                int end = i + len;
                if (end > memo.length) {
                    continue;
                }
                if (memo[end] != -1) {
                    continue;
                }
                if (str.substring(i, end).equals(s)) {
                    memo[end] = i;
                }
            }
        }
        System.out.println(Arrays.toString(memo));
        if (memo[str.length()] != -1) {
            int end = str.length();
            int startWord = memo[end];
            while (startWord > 0) {
                System.out.println(startWord + " " + end);
                segments.addFirst(str.substring(startWord, end));
                end = startWord;
                startWord = memo[end];
            }
            segments.addFirst(str.substring(0, end));
        }
        return segments;

    }

    public static void printString(LinkedList<String> list) {
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<String>();
        dict.add("programcree");
        dict.add("program");
        dict.add("creek");
        assert (canSegment("programcreek", dict));
        assert (!canSegment("creeker", dict));
        printString(doSegment("programcreek", dict));
    }

}
