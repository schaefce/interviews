package ctci.arraysAndStrings.Q1;

/*
 * Question 1.1 : Implement algorithm to determine if a string has all unique
 * characters. What if you cannot use additional data structures?
 */
public class AllUniqueCharacters {
    public static boolean allUnique(String str) {
        // Forgot this check the first time
        if (str.length() > 256) {
            return false;
        }

        boolean[] mask = new boolean[256];
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
            for (int j = i; j < str.length(); j++) {
                if (str.charAt(j) == c) {
                    return false;
                }
            }
        }
        return true;
    }
}
