package sorting.topCoder;

import java.util.Arrays;

/*
 * Fox Ciel loves music. She currently has n songs in her mp3 player. Their file
 * names are "1.mp3", "2.mp3", and so on, until string(n)+".mp3".
 * 
 * Sadly, Ciel's mp3 player does not sort the files according to the number.
 * Instead, it simply sorts the file names in lexicographic order, as strings.
 * So, for instance, if n=10 then the sorted order looks as follows: "1.mp3",
 * "10.mp3", "2.mp3", ..., "9.mp3".
 * 
 * You are given the int n. If n is at most 50, return a String[] containing the
 * entire sorted list of file names. If n is more than 50, return a String[]
 * containing the first 50 elements of the sorted list of file names.
 */

public class SortedMp3s {
    public static String[] playList(int n) {
        // A temporary array to fill and then sort:
        String[] tem = new String[n];
        for (int i = 1; i <= n; i++) {
            tem[i - 1] = i + ".mp3";
        }
        Arrays.sort(tem);
        // Cannot simply change the size of the array, create another:
        String[] res = new String[Math.min(50, n)];
        for (int i = 0; i < res.length; i++) {
            res[i] = tem[i];
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(playList(20)));
    }

}
