package ctci.arraysAndStrings.Q3;

/*
 * Question 1.3 : Given two strings, write a method to decided if one is a
 * permutation of the other.
 */
public class Permutation {
    public static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] charCounts = new int[128];
        for (char c : s1.toCharArray()) {
            charCounts[c]++;
        }
        for (char c : s2.toCharArray()) {
            if (--charCounts[c] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] pairs = { { "apple", "papel" }, { "carrot", "tarroc" },
                { "hello", "llloh" } };
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = isPermutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }
}
