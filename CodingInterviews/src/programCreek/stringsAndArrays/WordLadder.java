package programCreek.stringsAndArrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
 * Given two words (start and end), and a dictionary, find the length of
 * shortest transformation sequence from start to end, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary For example,
 * 
 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"] As
 * one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note: Return 0 if there is no such transformation sequence. All words have
 * the same length. All words contain only lowercase alphabetic characters.
 */

public class WordLadder {

    public static int getTransformationLength(String start, String end,
            Set<String> dict) {
        LinkedList<String> wordQueue = new LinkedList<String>();
        LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
        wordQueue.add(start);
        distanceQueue.add(1);
        while (!wordQueue.isEmpty()) {
            String currWord = wordQueue.pop();
            Integer currDist = distanceQueue.pop();
            System.out.println(currWord + "  " + currDist);
            if (currWord.equals(end)) {
                return currDist;
            }
            for (int i = 0; i < currWord.length(); i++) {
                char[] charArr = currWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    charArr[i] = c;
                    String newWord = new String(charArr);
                    if (dict.contains(newWord)) {
                        wordQueue.add(newWord);
                        distanceQueue.add(currDist + 1);
                        dict.remove(newWord);
                    }

                }
            }
        }
        return 0;
    }

    public static int ladderLength(String start, String end,
            HashSet<String> dict) {

        if (dict.size() == 0)
            return 0;

        LinkedList<String> wordQueue = new LinkedList<String>();
        LinkedList<Integer> distanceQueue = new LinkedList<Integer>();

        wordQueue.add(start);
        distanceQueue.add(1);

        while (!wordQueue.isEmpty()) {
            String currWord = wordQueue.pop();
            Integer currDistance = distanceQueue.pop();
            System.out.println(currWord + "  " + currDistance);

            if (currWord.equals(end)) {
                return currDistance;
            }

            for (int i = 0; i < currWord.length(); i++) {
                char[] currCharArr = currWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    currCharArr[i] = c;

                    String newWord = new String(currCharArr);
                    if (newWord.equals(end)) {
                        return currDistance + 1;
                    }
                    if (dict.contains(newWord)) {
                        wordQueue.add(newWord);
                        distanceQueue.add(currDistance + 1);
                        dict.remove(newWord);
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String[] strings = { "hot", "dot", "dog", "lot", "log" };
        HashSet<String> dict = new HashSet<String>(Arrays.asList(strings));
        System.out.println(ladderLength("hit", "cog", dict));

    }

}
