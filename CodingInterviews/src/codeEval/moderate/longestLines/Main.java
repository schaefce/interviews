package codeEval.moderate.longestLines;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/*
 * Write a program to read a multiple line text file and write the 'N' longest
 * lines to stdout. Where the file to be read is specified on the command line.
 * 
 * Input Sample: Your program should read an input file (the first argument to
 * your program will be a path to a filename). The first line contains the value
 * of the number 'N' followed by multiple lines. You may assume that the input
 * file is formatted correctly and the number on the first line i.e. 'N' is a
 * valid positive integer. E.g. 2 Hello World CodeEval Quick Fox A San Francisco
 * 
 * Output Sample: The 'N' longest lines, newline delimited. Ignore all empty
 * lines in the input. Ensure that there are no trailing empty spaces on each
 * line you print. Also ensure that the lines are printed out in decreasing
 * order of length i.e. the output should be sorted based on their length. E.g.
 * 
 * San Francisco Hello World
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException,
            IOException {
        process("lines.txt");

    }

    public static void process(String fileName) throws NumberFormatException,
            IOException {
        File file = new File(fileName);
        BufferedReader in = new BufferedReader(new FileReader(file));
        int N = Integer.parseInt(in.readLine());
        LinkedList<String> longestLines = new LinkedList<String>();
        String line = in.readLine();
        while (line != null) {
            if (line.length() > 0) {
                for (int i = 0; i < N; i++) {
                    if (longestLines.size() - 1 < i) {
                        longestLines.addLast(line);
                        break;
                    } else if (line.length() > longestLines.get(i).length()) {
                        longestLines.add(i, line);
                        if (longestLines.size() > N) {
                            longestLines.removeLast();
                        }
                        break;
                    }
                }
            }
            line = in.readLine();
        }
        for (int i = 0; i < longestLines.size(); i++) {
            System.out.println(longestLines.get(i));
        }
        in.close();

    }

}
