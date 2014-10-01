package hashTables.eopi.Q9;

/*
 * 12.9 You are required to write a method which takes an anonymous letter L and
 * text from magazine M. Your method is to return true iff L can be written
 * using M i.e. if a letter appears k times in L, it must appear at least k
 * times in M
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AnonymousLetter {
    public static boolean anonymousLetter(String L, String M) {
        Map<Character, Integer> letterHash = new HashMap<>();

        // hash all letters in L to their frequency
        for (char c : L.toCharArray()) {
            if (letterHash.containsKey(c)) {
                letterHash.put(c, letterHash.get(c) + 1);
            } else {
                letterHash.put(c, 1);
            }
        }

        for (char c : M.toCharArray()) {
            if (letterHash.containsKey(c)) {
                letterHash.put(c, letterHash.get(c) - 1);
                if (letterHash.get(c) == 0) {
                    letterHash.remove(c);
                    if (letterHash.isEmpty()) {
                        return true;
                    }
                }
            }
        }
        return letterHash.isEmpty();
    }

    private static String randString(int len) {
        StringBuilder ret = new StringBuilder();
        Random rnd = new Random();

        while (len-- > 0) {
            ret.append((char) (rnd.nextInt(26) + 97));
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String L = null;
        String M = null;
        if (args.length == 2) {
            L = args[0];
            M = args[1];
        } else {
            Random rnd = new Random();
            L = randString(rnd.nextInt(1000) + 1);
            M = randString(rnd.nextInt(100000) + 1);
        }
        System.out.println(L);
        System.out.println(M);
        assert (!anonymousLetter("123", "456"));
        assert (!anonymousLetter("123", "12222222"));
        assert (anonymousLetter("123", "1123"));
        assert (anonymousLetter("123", "123"));
        System.out.println(anonymousLetter(L, M) ? "true" : "false");
    }
}
