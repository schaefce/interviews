package arraysAndStrings.strings.ctci.Q8;

/*
 * 1.8 Assume you have a method isSubstring which checks if one word is a
 * substring of another. Given two strings, s1 and s2, write code to check if s2
 * is a rotation of s1 using only one call to isSubstring (e.g. "waterbottle" is
 * a rotation of "erbottlewat")
 */
public class Rotation {
    public static boolean isSubstring(String big, String small) {
        if (big.indexOf(small) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String combined = s1 + s1;
        return isSubstring(combined, s2);
    }

}
