package dynamicProgramming.topCoder;

/*
 * Given a string of digits, find the minimum number of additions required for
 * the string to equal some target number. Each addition is the equivalent of
 * inserting a plus sign somewhere into the string of digits. After all plus
 * signs are inserted, evaluate the sum as usual. For example, consider the
 * string "12" (quotes for clarity). With zero additions, we can achieve the
 * number 12. If we insert one plus sign into the string, we get "1+2", which
 * evaluates to 3. So, in that case, given "12", a minimum of 1 addition is
 * required to get the number 3. As another example, consider "303" and a target
 * sum of 6. The best strategy is not "3+0+3", but "3+03". You can do this
 * because leading zeros do not change the result. Write a class QuickSums that
 * contains the method minSums, which takes a String numbers and an int sum. The
 * method should calculate and return the minimum number of additions required
 * to create an expression from numbers that evaluates to sum. If this is
 * impossible, return -1.
 * 
 * Constraints: 1. Numbers will contain between 1 and 10 characters, inclusive.
 * 2. Each character in numbers will be a digit. 3. Sum will be between 0 and
 * 100, inclusive.
 */

public class QuickSums {

    public static int getQS(String numbers, int target) {
        // qs[i][j] = min number + added to first i digits to get sum j
        int N = numbers.length();
        int[][] qs = new int[N][target + 1];
        for (int i = 0; i < N; i++) {
            for (int sum = 0; sum <= target; sum++) {
                qs[i][sum] = 105;
            }
        }
        for (int i = 0; i < N; i++) {
            // tmp = value of first i characters as a number
            int sum = Integer.parseInt(numbers.substring(0, i + 1));
            if (sum <= target) {
                qs[i][sum] = 0; // add 0 + to get tmp using first i characters
            } else {
                break; // we have exceeded the target-- don't need to record
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= i; j++) {
                // we know numbers[j...i] have value val
                int val = Integer.parseInt(numbers.substring(j, i + 1));
                if (val > target) {
                    break;
                }
                for (int sum = 0; sum <= target; sum++) {
                    // numbers[0...i] make sum. if numbers[0...j] make sum-val
                    // then we can make sum using + between 0...j and j...i
                    if (sum >= val) {
                        qs[i][sum] = Math.min(qs[i][sum],
                                qs[j - 1][sum - val] + 1);
                    }
                }
            }
        }
        if (qs[N - 1][target] == 105)
            return -1;
        return qs[N - 1][target];
    }

    public static void main(String[] args) {
        System.out.println(getQS("416", 47));
        System.out.println(getQS("1110", 3));
        System.out.println(getQS("99999", 5));
    }

}
