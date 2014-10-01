package arraysAndStrings.strings.topCoder;

import java.util.Arrays;
import java.util.Comparator;

/*
 * You own a lot of guitars, and each guitar has a unique serial number. You
 * want to be able to look up serial numbers quickly, so you decide to sort the
 * entire list as follows.
 * 
 * 
 * 
 * Each serial number consists of uppercase letters ('A' - 'Z') and digits ('0'
 * - '9'). To see if serial number A comes before serial number B, use the
 * following steps:
 * 
 * If A and B have a different length, the one with the shortest length comes
 * first. Else if sum_of_digits(A) differs from sum_of_digits(B) (where
 * sum_of_digits(X) returns the sum of all digits in string X), the one with the
 * lowest sum comes first. Else compare them alphabetically, where digits come
 * before letters. Given a String[] serialNumbers, return a String[] with the
 * ordered list of serial numbers in increasing order.
 */

public class SerialNumbers {

    public static String[] sort(String[] serialNumbers) {
        Arrays.sort(serialNumbers, new Comparator<String>() {
            @Override
            public int compare(String A, String B) {
                int ret;
                if (A.length() != B.length()) {
                    ret = A.length() < B.length() ? -1 : 1;
                } else {
                    int sumA = sumOfDigits(A);
                    int sumB = sumOfDigits(B);
                    if (sumA != sumB) {
                        ret = sumA < sumB ? -1 : 1;
                    } else {
                        ret = A.compareTo(B);
                    }
                }
                return ret;
            }

            public int sumOfDigits(String str) {
                int sum = 0;
                for (char c : str.toCharArray()) {
                    int val = c - '0';
                    if (val < 10) {
                        sum += val;
                    }
                }
                return sum;
            }
        });
        return serialNumbers;
    }

    public static void main(String[] args) {
        String[][] serialNumbers = { { "ABCD", "145C", "A", "A910", "Z321" },
                { "Z19", "Z20" },
                { "34H2BJS6N", "PIM12MD7RCOLWW09", "PYF1J14TF", "FIPJOTEA5" },
                { "ABCDE", "BCDEF", "ABCDA", "BAAAA", "ACAAA" } };
        for (int i = 0; i < serialNumbers.length; i++) {
            System.out.printf("%d.\tInput: %s\n\tOutput: %s\n", i,
                    Arrays.toString(serialNumbers[i]),
                    Arrays.toString(sort(serialNumbers[i])));
        }
    }
}
