package google;

/*
 * alphabet: {a, b, c, ...} words: 3 of each letter (aaabbbccc, abcabcabc, ....)
 * problem: print all possible "words"
 */

public class AllPossibleWords {
    public static void printAllPossibleWords(char[] alphabet) {
        // Need 3 of each character for each word
        int[] alphabetUsed = new int[alphabet.length];
        char[] word = new char[alphabet.length * 3];
        printAllPossibleWords(0, word, alphabet, alphabetUsed);

    }

    public static void printAllPossibleWords(int index, char[] word,
            char[] letters, int[] letterUsage) {
        if (index == word.length) {
            System.out.println(word);
            return;
        }
        for (int i = 0; i < letters.length; i++) {
            int currLetterUsage = letterUsage[i];
            if (letterUsage[i] < 3) {
                word[index] = letters[i];
                letterUsage[i]++;
                printAllPossibleWords(index + 1, word, letters, letterUsage);
            }
            letterUsage[i] = currLetterUsage;
        }

    }

    public static void main(String[] args) {
        char[] alphabet = { 'a', 'b', 'c' };
        printAllPossibleWords(alphabet);
    }

}
