package arraysAndStrings.strings.ctci.Q5;

/*
 * Question 1.5: Implement a method to perform basic string compression using
 * the counts of repeated characters. For example, the string aabcccccaaa would
 * become a2b1c5a3. If the "compressed" string would not become larger than the
 * original string, your method should return the original string. You can
 * assume the string has only upper and lower case letters (a-z)
 */
public class RunLengthCompression {
    public static String compress(String str) {
        if (getCompressedLength(str) >= str.length()) {
            return str;
        }
        StringBuffer sb = new StringBuffer();
        char curr = str.charAt(0);
        int runLength = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == curr) {
                runLength++;
            } else {
                sb.append(curr);
                sb.append(runLength);
                curr = str.charAt(i);
                runLength = 1;
            }
        }
        // Forgot these two last lines last time!
        sb.append(curr);
        sb.append(runLength);
        return sb.toString();
    }

    public static int getCompressedLength(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int length = 0;
        int count = 1;
        char curr = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != curr) {
                curr = str.charAt(i);
                length += 1 + String.valueOf(count).length();
            } else {
                count++;
            }
        }
        length += 1 + String.valueOf(count).length();
        return length;
    }

    public static void main(String[] args) {
        String str = "abbccccccde";
        int c = getCompressedLength(str);
        String str2 = compress(str);
        System.out.println("Old String (len = " + str.length() + "): " + str);
        System.out.println("New String (len = " + str2.length() + "): " + str2);
        System.out.println("Potential Compression: " + c);
    }

}
