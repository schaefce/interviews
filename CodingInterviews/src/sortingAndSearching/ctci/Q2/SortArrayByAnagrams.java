package sortingAndSearching.ctci.Q2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class SortArrayByAnagrams {
    public static void sort(String[] strings) {
        HashMap<String, LinkedList<String>> hashGrams = new HashMap<String, LinkedList<String>>();
        for (String s : strings) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (hashGrams.get(sorted) == null) {
                LinkedList<String> anagrams = new LinkedList<String>();
                anagrams.add(s);
                hashGrams.put(sorted, anagrams);
            } else {
                LinkedList<String> anagrams = hashGrams.get(sorted);
                anagrams.add(s);
            }
        }
        int i = 0;
        for (String s : hashGrams.keySet()) {
            LinkedList<String> anagrams = hashGrams.get(s);
            for (String t : anagrams) {
                strings[i] = t;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        String[] strings = new String[8];
        strings[0] = "CAT";
        strings[1] = "WAS";
        strings[2] = "TEAR";
        strings[3] = "SAW";
        strings[4] = "TIME";
        strings[5] = "MITE";
        strings[6] = "SHARE";
        strings[7] = "RATE";
        System.out.println(Arrays.toString(strings));
        sort(strings);
        System.out.println(Arrays.toString(strings));
    }
}
