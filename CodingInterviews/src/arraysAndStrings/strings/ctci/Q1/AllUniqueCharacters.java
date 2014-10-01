package arraysAndStrings.strings.ctci.Q1;

/*
 * Question 1.1 : Implement algorithm to determine if a string has all unique
 * characters. What if you cannot use additional data structures?
 */
public class AllUniqueCharacters {
    public static boolean allUnique(String str) {
        // Forgot this check the first time
        if (str.length() > 128) {
            return false;
        }

        boolean[] mask = new boolean[128];
        for (char c : str.toCharArray()) {
            if (mask[c] == true) {
                return false;
            }
            mask[c] = true;
        }
        return true;
    }

    public static boolean allUniqueNoBuffer(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) == c) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean allUniqueBitVector(String str) {
        // long has fixed size usually 64 bits (flags)
        long checker1 = 0;
        long checker2 = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            int toCheck = val / 64;
            val %= 64;
            if (toCheck == 0) {
                // check if flag index val is true
                if ((checker1 & (1L << val)) > 0) {
                    return false;
                }
                // set flag index val to be true
                checker1 |= (1L << val);
            } else {
                if ((checker2 & (1L << val)) > 0) {
                    return false;
                }
                checker2 |= (1L << val);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = { "abcde", "hello", "apple", "kite", "paDDle" };
        for (String w : words) {
            System.out.println(w + ": " + allUnique(w) + " "
                    + allUniqueNoBuffer(w) + " " + allUniqueBitVector(w));
        }
    }
}
