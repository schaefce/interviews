package math.topCoder;

/*
 * You have been hired to do some refactoring. You are not really sure what that
 * is, but you think it has something to do with factoring a number multiple
 * times. Recall that a factorization of a positive integer n is a collection of
 * at least two positive integers, each larger than one, whose product is n.
 * Note that the order of the numbers in a factorization is ignored, so 2*12 and
 * 12*2 represent the same factorization of 24. In fact, 24 has precisely 6
 * valid factorizations: 2*2*2*3, 2*2*6, 2*3*4, 2*12, 3*8, and 4*6.
 * 
 * To prepare for your job, write a program that, given an int n, returns the
 * number of unique factorizations of n.
 */

public class Refactor {
    public static int uniqueFactors(int n) {
        return uniqueFactors(n, 2);

    }

    public static int uniqueFactors(int n, int last) {
        int res = 0;
        for (int i = last; i * i <= n; i++) {
            if (n % i == 0) {
                res += uniqueFactors(n / i, i) + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] numbers = { 24, 9973, 9240, 1916006400 };
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%d.\tInput: %d\n\tOutput: %d\n", i, numbers[i],
                    uniqueFactors(numbers[i]));
        }
    }

}
