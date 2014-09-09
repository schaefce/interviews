package codeEval.primePalindromes;

/* Write a program to determine the biggest prime palindrome under 1000. */

public class Main {
    public static void main(String[] args) {
        System.out.println(getPrimePalindrome());

    }

    public static int getPrimePalindrome() {
        int primePal = getPreviousPrime(1000);
        while (!isPalindrome(primePal)) {
            primePal = getPreviousPrime(primePal);
        }
        return primePal;
    }

    private static boolean isPalindrome(int n) {
        if (n / 100 > 0) {
            return (n % 100 % 10) == n / 100;
        } else if (n / 10 > 0) {
            return n % 10 == n / 10;
        } else {
            return true;
        }
    }

    private static boolean isPrime(int num) {
        int i;
        boolean prime = true;
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0 || num <= 1) {
            prime = false;
        } else {
            for (i = 3; i <= Math.sqrt(num); i += 2) {
                if (num % i == 0)
                    prime = false;
            }
        }
        return prime;
    }

    private static int getPreviousPrime(int n) {
        int prevPrime;
        while (n != 0) {
            prevPrime = n - 1;
            if (prevPrime % 2 == 0) {
                prevPrime -= 1;
            }
            while (!isPrime(prevPrime)) {
                prevPrime -= 2;
            }
            return prevPrime;
        }
        return 0;
    }
}
