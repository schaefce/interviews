package arraysAndStrings.strings.programCreek;

/* Find the longest palindromic substring in a string */

public class LongestPalindromicSubstring {

    public static String getLongestPalindromicSubstring(String s) {
        if (s.isEmpty()) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        String longest = s.substring(0, 1); // So far longest is single letter
        for (int i = 0; i < s.length(); i++) {
            String tmp = helper(s, i, i); // Get longest palindrome w center i
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
            tmp = helper(s, i, i + 1); // Get longest palindrome w center i, i+1
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }
        return longest;

    }

    private static String helper(String s, int start, int end) {
        while (start >= 0 && end <= s.length() - 1
                && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);

    }

    public static void main(String[] args) {
        String s1 = "racecar";
        String s2 = "Ihavearacecar";
        String s6 = "nopalindromes";
        String s3 = "momhasaracecar";
        String s4 = "doracecarshavemoms";
        String s5 = "0101101011";

        String racecar = "racecar";
        String binaryPal = "01011010";

        assert (getLongestPalindromicSubstring(s1).equals(racecar));
        assert (getLongestPalindromicSubstring(s2).equals(racecar));
        assert (getLongestPalindromicSubstring(s3).equals(racecar));
        assert (getLongestPalindromicSubstring(s4).equals(racecar));
        assert (getLongestPalindromicSubstring(s5).equals(binaryPal));
        assert (getLongestPalindromicSubstring(s6).equals("n"));

    }

}
