package arraysAndStrings.strings.leetCode.wordLadderTwo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
 * Given two words (start and end), and a dictionary, find all shortest
 * transformation sequence(s) from start to end, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary For example,
 * 
 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"]
 * Return [ ["hit","hot","dot","dog","cog"], ["hit","hot","lot","log","cog"] ]
 */
public class AttemptTwo {

    public LinkedList<LinkedList<String>> findLadders(String start, String end,
            HashSet<String> dict) {
        LinkedList<LinkedList<String>> ret = new LinkedList<LinkedList<String>>();

        int minSize = ladderLength(start, end, dict);
        if (minSize != 0) {
            LinkedList<LinkedList<String>> listOfLadders = new LinkedList<LinkedList<String>>();
            LinkedList<Integer> distances = new LinkedList<Integer>();
            Set<String> used = new HashSet<String>();
            LinkedList<String> wordQueue = new LinkedList<String>();
            wordQueue.add(start);
            distances.add(1);

            listOfLadders.add(wordQueue);
            while (!listOfLadders.isEmpty()) {
                boolean finished = false;
                for (int j = 0; j < listOfLadders.size(); j++) {
                    LinkedList<String> list = listOfLadders.pop();
                    int dist = distances.pop();
                    if (finished && dist > minSize) {
                        continue;
                    }
                    String currWord = list.getLast();
                    if (currWord.equals(end) && dist == minSize) {
                        ret.add(list);
                        finished = true;
                        continue;
                    }
                    used.add(currWord);
                    if (finished && dist == minSize) {
                        continue;
                    }
                    char[] currCharArr = currWord.toCharArray();
                    for (int i = 0; i < currWord.length(); i++) {
                        char prev = currCharArr[i];
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (prev == c)
                                continue;
                            currCharArr[i] = c;
                            String newWord = new String(currCharArr);
                            if (!used.contains(newWord)
                                    && dict.contains(newWord)) {
                                LinkedList<String> newList = new LinkedList<String>(
                                        list);

                                newList.add(newWord);

                                if (newWord.equals(end) && dist + 1 == minSize) {
                                    finished = true;
                                    ret.add(newList);

                                } else if (finished && dist + 1 == minSize) {
                                    continue;
                                } else {
                                    listOfLadders.add(newList);
                                    distances.add(dist + 1);
                                }
                            }
                        }
                        currCharArr[i] = prev;

                    }
                }
                if (finished) {
                    return ret;
                }
            }
        }

        return ret;
    }

    public static int ladderLength(String start, String end,
            HashSet<String> dict) {

        if (dict.size() == 0)
            return 0;

        LinkedList<String> wordQueue = new LinkedList<String>();
        LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
        Set<String> used = new HashSet<String>();
        wordQueue.add(start);
        distanceQueue.add(1);

        while (!wordQueue.isEmpty()) {
            String currWord = wordQueue.pop();
            Integer currDistance = distanceQueue.pop();

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
                    if (!used.contains(newWord) && dict.contains(newWord)) {
                        wordQueue.add(newWord);
                        distanceQueue.add(currDistance + 1);
                        used.add(newWord);
                    }
                }
            }
        }

        return 0;
    }
}
