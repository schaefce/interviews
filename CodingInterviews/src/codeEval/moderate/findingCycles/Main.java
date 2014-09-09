package codeEval.moderate.findingCycles;

import java.io.BufferedReader;
import java.io.File;
/*
 * Given a sequence, write a program to detect cycles within it.
 * 
 * Your program should accept as its first argument a path to a filename
 * containing a sequence of numbers (space delimited) The file can have multiple
 * such lines. E.g 2 0 6 3 1 6 3 1 6 3 1 3 4 8 0 11 9 7 2 5 6 10 1 49 49 49 49 1
 * 2 3 1 2 3 1 2 3
 * 
 * Print to stdout the first cycle you find in each sequence. Ensure that there
 * are no trailing empty spaces on each line you print. E.g. 6 3 1 49 1 2 3
 * 
 * Constrains: The elements of the sequence are integers in range [0, 99] The
 * length of the sequence is in range [0, 50]
 */
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            File sequences = new File("seqs.txt");
            BufferedReader in = new BufferedReader(new FileReader(sequences));
            String line = in.readLine();
            while (line != null) {
                String[] numString = line.split("\\s+");
                int[] numbers = new int[numString.length];
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = Integer.parseInt(numString[i]);
                }
                processSequence(numbers);
                line = in.readLine();
            }
        } catch (IOException e) {

        }
    }

    public static void processSequence(int[] seq) {
        int p1 = 0;
        int p2 = 1;
        while (p1 < seq.length) {
            while (p2 < seq.length) {
                if (seq[p1] == seq[p2]) {
                    break;
                }
                p2++;
            }
            if (p2 < seq.length && seq[p1] == seq[p2]) {
                break;
            }
            p1++;
            p2 = p1 + 1;
        }
        if (p1 == seq.length) {
            return;
        }
        int start = p1;
        while (p2 < seq.length && seq[start] != seq[p2]) {
            p2++;
        }
        int end = p2;
        int length = end - start;
        for (int i = 0; i < length - 1; i++) {
            System.out.print(seq[start + i] + " ");
        }
        System.out.println(seq[start + length - 1]);
    }
}
