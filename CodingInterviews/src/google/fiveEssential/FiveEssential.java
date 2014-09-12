package google.fiveEssential;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FiveEssential {

    /* Write a method to reverse a string */
    public static void reverse(char[] str) {
        for (int j = 0; j < str.length / 2; j++) {
            swap(str, j, str.length - j);
        }
    }

    private static void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }

    /* Write function to compute Nth fibonacci number */
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    /* Write a function that sums integers from a text file, one int per line */
    public static int sumFile(String fileName) {
        try {
            int sum = 0;
            BufferedReader in = new BufferedReader(new FileReader(fileName));

            for (String s = in.readLine(); s != null; s = in.readLine()) {
                sum += Integer.parseInt(s);
            }
            System.out.println(sum);

            in.close();
            return sum;
        } catch (IOException e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        String str = "Hello World.";
        char[] chars = str.toCharArray();
        System.out.println(chars);
        reverse(chars);
        System.out.println(chars);

        for (int i = 0; i < 10; i++) {
            System.out.print(fib(i) + ", ");
        }
        System.out.println(fib(10));
    }
}
