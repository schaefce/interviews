package hashTables.eopi.Q7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * Write a function that takes as input a dictionary of English words, and
 * returns a partition of the dictionary into subsets of words that are all
 * anagrams of each other
 */
public class Anagrams {
    public static void findAnagrams(List<String> dictionary) {
        Map<String, List<String>> anagramHash = new HashMap<>();
        for (String s : dictionary) {
            char[] characters = s.toCharArray();
            Arrays.sort(characters);
            String sorted = Arrays.toString(characters);
            if (!anagramHash.containsKey(sorted)) {
                anagramHash.put(sorted, new LinkedList<String>());
            }
            anagramHash.get(sorted).add(s);
        }
        for (Map.Entry<String, List<String>> entry : anagramHash.entrySet()) {
            if (entry.getValue().size() >= 2) {
                System.out.println(Arrays.toString(entry.getValue().toArray()));
            }
        }
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("CAT");
        dict.add("DOG");
        dict.add("ROOM");
        dict.add("TIKE");
        dict.add("GOD");
        dict.add("SHA");
        dict.add("KITE");
        dict.add("KIT");
        dict.add("MODE");
        dict.add("DOME");
        dict.add("HAS");
        dict.add("ASH");
        findAnagrams(dict);
    }
}
