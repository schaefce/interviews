package arraysAndStrings.strings.leetCode;

/*
 * https://oj.leetcode.com/problems/add-binary/ Given two binary strings, return
 * their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        if (a == null || b == null || a.length() == 0 || b.length() == 0) {
            return null;
        }
        int maxLength = a.length() > b.length() ? a.length() : b.length();
        char[] binarySum = new char[maxLength + 1];
        int i = a.length() - 1;
        int j = b.length() - 1;
        int k = maxLength;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int b1 = charBit(a.charAt(i--));
            int b2 = charBit(b.charAt(j--));
            binarySum[k--] = (char) ('0' + ((b1 + b2 + carry) % 2));
            carry = (b1 + b2 + carry) / 2;

        }
        if (i >= 0) {
            while (i >= 0) {
                int b1 = charBit(a.charAt(i--));
                binarySum[k--] = (char) ('0' + ((b1 + carry) % 2));
                carry = (b1 + carry) / 2;
            }
        } else if (j >= 0) {
            while (j >= 0) {
                int b2 = charBit(b.charAt(j--));
                binarySum[k--] = (char) ('0' + ((b2 + carry) % 2));
                carry = (b2 + carry) / 2;
            }
        }
        if (carry != 0) {
            binarySum[k] = (char) ('0' + carry);
        } else {
            k++;
        }
        return new String(binarySum).substring(k);
    }

    private static int charBit(char c) {
        return c > '0' ? 1 : 0;
    }

    public static void main(String[] args) {
        String b1 = "100";
        String b2 = "110010";
        System.out.println(addBinary(b1, b2));
    }
}
