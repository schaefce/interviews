package arraysAndStrings.strings.leetCode;

/*
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null)
            return false;
        if (s.isEmpty())
            return true;
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i <= j && !isAlphaNum(s.charAt(i))) {
                i++;
            }
            while (i <= j && !isAlphaNum(s.charAt(j))) {
                j--;
            }
            if (i > j)
                break;
            char c = s.charAt(i);
            char d = s.charAt(j);
            if (isLetter(c)) {
                if (!isLetter(d))
                    return false;
                if (!sameLetter(c, d))
                    return false;
            } else if (isLetter(d)) {
                return false;
            } else {
                if (c != d)
                    return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private boolean sameLetter(char c, char d) {
        return numRep(c) == numRep(d);
    }

    private int numRep(char c) {
        return c < 'a' ? 'Z' - c : 'z' - c;
    }

    private boolean isAlphaNum(char c) {
        return isLetter(c) || (c <= '9' && c >= '0');
    }
}
