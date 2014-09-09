package codeEval.moderate.mthToLast;

/*
 * Write a program to determine the Mth to last element of a list.
 * 
 * INPUT SAMPLE:
 * 
 * The first argument will be a path to a filename containing a series of space
 * delimited characters followed by an integer representing a index into the
 * list (1 based), one per line. E.g. a b c d 4 e f g h 2
 * 
 * OUTPUT SAMPLE:
 * 
 * Print to stdout, the Mth element from the end of the list, one per line. If
 * the index is larger than the list size, ignore that input. E.g. a g
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            File lists = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(lists));
            String line = in.readLine();
            while (line != null) {

                System.out.println(getMthToLast(line.split("\\s+")));
                line = in.readLine();
            }
        } catch (IOException e) {

        }
    }

    public static char getMthToLast(String[] arr) {
        int m = Integer.parseInt(arr[arr.length - 1]);
        if (m > arr.length) {
            return ' ';
        } else {
            return arr[arr.length - m - 1].charAt(0);
        }
    }
}
