package arraysAndStrings.strings.leetCode;

/*
 * Validate if a given string is numeric.
 * 
 * Some examples: "0" => true " 0.1 " => true "abc" => false "1 a" => false
 * "2e10" => true
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        int i = 0;
        boolean expSeen = false, decSeen = false;
        boolean noDigits = true, needDigits = true;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        if (i < s.length() && isSign(s.charAt(i))) {
            i++;
        }
        char c;
        while (i < s.length()) {
            c = s.charAt(i++);
            if (c == ' ') {
                if (needDigits)
                    return false;
                while (i < s.length())
                    if (s.charAt(i++) != ' ')
                        return false;
                return true;
            }
            if (isDigit(c)) {
                needDigits = false;
                noDigits = false;
            } else if (c == '.') {
                if (expSeen)
                    return false;
                if (decSeen)
                    return false;
                if (noDigits)
                    needDigits = true;
                decSeen = true;
            } else if (c == 'e') {
                if (noDigits)
                    return false;
                if (expSeen)
                    return false;
                expSeen = true;
                if (i < s.length() && isSign(s.charAt(i)))
                    i++;
                needDigits = true;
            } else {
                return false;
            }
        }
        if (needDigits) {
            return false;
        }
        return true;

    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isSign(char c) {
        return c == '+' || c == '-';
    }
}
