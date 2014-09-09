package careercup.random;

public class fiveTenDigitPrimes {

    public static boolean isPrime(int num) {
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

    public static int nextPrime(int n) {
        int nextPrime;
        while (n != 0) {
            nextPrime = n + 1;
            if (nextPrime % 2 == 0) {
                nextPrime += 1;
            }
            while (!isPrime(nextPrime)) {
                nextPrime += 2;
            }
            return nextPrime;
        }
        return 0;
    }

    public static void main(String[] args) {
        int i = 0;
        int current = 1000000000;
        while (i < 5) {
            current = nextPrime(current);
            System.out.println(current);
            i++;
        }
    }
}
