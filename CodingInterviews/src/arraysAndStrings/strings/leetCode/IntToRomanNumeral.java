package arraysAndStrings.strings.leetCode;

/*
 * https://oj.leetcode.com/problems/integer-to-roman/
 * 
 * Given an integer, convert it to a roman numeral.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 */

public class IntToRomanNumeral {
    public String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        if (num >= 4000) {
            return null;
        }
        if (num / 1000 > 0) {
            for (int j = 0; j < num / 1000; j++) {
                sb.append('M');
            }
        }
        num %= 1000;
        num = calculate(num, 100, sb, 'C', 'D', 'M');
        // num %= 100;
        num = calculate(num, 10, sb, 'X', 'L', 'C');
        // num %= 10;
        calculate(num, 1, sb, 'I', 'V', 'X');
        return sb.toString();
    }

    private int calculate(int i, int place, StringBuffer sb, char one,
            char five, char ten) {
        int n = i / place;
        if (n > 0) {
            if (n < 4) {
                for (int j = 0; j < n; j++) {
                    sb.append(one);
                }
            } else if (n == 4) {
                sb.append(one);
                sb.append(five);
            } else if (n < 9) {
                sb.append(five);
                calculate(i - 5 * place, place, sb, one, five, ten);
            } else {
                sb.append(one);
                sb.append(ten);
            }
        }
        return i % place;
    }

}
