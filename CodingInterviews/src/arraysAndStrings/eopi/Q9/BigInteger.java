package eopi.arraysAndStrings.Q9;

/*
 * 6.9 Write a function that takes two strings representing integers, and
 * returns an integer representing their product
 */

public class BigInteger {
    private static int MAX_DIGITS = 10;

    public static int bigIntegerMult(String s1, String s2) {
        return stringToInt(s1) * stringToInt(s2);
    }

    public static int stringToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int val = 0;
        boolean isNegative = false;
        int i = 0;
        if (s.charAt(i) == '-') {
            isNegative = true;
            i++;
        }
        while (i < s.length()) {
            val = val * 10;
            int digit = s.charAt(i) - '0';
            val += digit;
            i++;
        }
        if (isNegative) {
            val *= -1;
        }
        return val;
    }

    public static String intToString(int value) {
        StringBuffer s = new StringBuffer();
        char[] tmp = new char[MAX_DIGITS + 1];
        if (value < 0) {
            s.append('-');
            value *= -1;
        }
        int i = 0;
        while (value > 0) {
            tmp[i] = (char) (value % 10 + '0');
            i++;
            value /= 10;
        }
        while (i > 0) {
            s.append(tmp[i]);
            i--;
        }
        return s.toString();

    }

    public static void main(String[] args) {
        String s1 = "-40";
        String s2 = "23";
        assert (bigIntegerMult(s1, s2) == -40 * 23);
        assert (stringToInt("-45") == Integer.parseInt("-45"));
        assert (intToString(4201).equals(Integer.toString(4201)));
    }

}
