package arraysAndStrings.strings.topCoder;

/*
 * Wolf Sothe is playing the game Delaymaster. In this game, he can create new
 * words according to the following rules: For each positive integer n, the
 * string which consists of n copies of 'w', then n copies of 'o', then n copies
 * of 'l', and finally n copies of 'f' is a valid word. The concatenation of two
 * valid words is a valid word. Only the words that can be obtained by rules 1
 * and 2 are valid. There are no other valid words. Thus, for example: By rule
 * 1, "wolf", "wwoollff", and "wwwooolllfff" are valid words. Then, by rule 2,
 * "wolfwwoollff" is a valid word. By applying rule 2 twice, "wolfwwoollffwolf"
 * is a valid word. The string "wfol" is not a valid word (order matters). The
 * string "wwolfolf" is not a valid word (we can only concatenate, not insert
 * one word into another). The string "wwwoolllfff" is not a valid word (only
 * two 'o's instead of three). You are given a String str. Return "VALID" if str
 * is a valid word and "INVALID" otherwise. Note that the return value is
 * case-sensitive: you must return the strings "VALID" and "INVALID" in
 * all-uppercase.
 */

public class WolfDelayMaster {

    public static String check(String str) {
        int i = 0;
        while (i < str.length()) {
            int start = i;
            if (str.charAt(i) != 'w') {
                return "INVALID";
            }
            while (str.charAt(i) == 'w') {
                i++;
            }
            int length = i - start;
            int j = start;
            while (j < i) {
                if ((j + length * 3) >= str.length()
                        || str.charAt(j + length) != 'o'
                        || str.charAt(j + length * 2) != 'l'
                        || str.charAt(j + length * 3) != 'f') {
                    return "INVALID";
                }
                j++;
            }
            i = j + length * 3;
        }
        return "VALID";

    }

    public static void main(String[] args) {
        String[] words = { "wolf", "wwolfolf",
                "wolfwwoollffwwwooolllfffwwwwoooollllffff", "flowolf" };
        for (String w : words) {
            System.out.println(w + ": " + check(w));
        }

    }

}
