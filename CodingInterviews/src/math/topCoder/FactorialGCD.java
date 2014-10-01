package math.topCoder;

/*
 * The greatest common divisor (GCD) of two positive integers a and b is the
 * largest integer that evenly divides both a and b. In this problem, you will
 * find the GCD of a positive integer and the factorial of a non-negative
 * integer.
 * 
 * Create a class FactorialGCD with method factGCD which takes an int a and an
 * int b as parameters and returns the GCD of a! (the factorial of a) and b.
 */

public class FactorialGCD {
    public static int factGCD(int a, int b) {
        int gcd = 1;
        // factorize b on primes
        for (int i = 2; i * i <= b; i++) {
            // suppose b divides on some prime i
            // let j = k*i for some k
            for (int j = i; b % i == 0; j += i) {
                int k = j;
                // while j can still be divided on i
                while (b % i == 0 && k > 1) {
                    b /= i;
                    k /= i;
                    if (j <= a) {
                        gcd *= i;
                    }
                }
            }
        }
        if (b != 1 && b <= a) {
            gcd *= b;
        }
        return gcd;
    }

    public static int factGCD2(int a, int b) {
        int b0 = b;
        int gcd = 1;
        for (int i = 2; i * i <= b0; i++) {
            for (int j = i; b % i == 0; j += i) {
                int k = j;
                while (b % i == 0 && k % i == 0) {
                    b /= i;
                    k /= i;
                    if (j <= a) {
                        gcd *= i;
                    }
                }
            }
        }
        if (b <= a) {
            gcd *= b;
        }
        return gcd;
    }

    public static void main(String[] args) {
        int[][] abs = { { 5, 20 }, { 7, 5040 }, { 0, 2425 }, { 667024, 1 },
                { 4, 40 }, { 2097711064, 2147483646 } };
        for (int i = 0; i < abs.length; i++) {
            System.out.printf("%d.\ta:\t%d\n\tb:\t%d\n\tgcd:\t%d\t%d\n", i,
                    abs[i][0], abs[i][1], factGCD(abs[i][0], abs[i][1]),
                    factGCD2(abs[i][0], abs[i][1]));
        }
    }

}
