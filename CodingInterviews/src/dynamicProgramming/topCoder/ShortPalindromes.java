package dynamicProgramming.topCoder;

import java.util.Arrays;

/*
 * A palindrome is a String that is spelled the same forward and backwards.
 * Given a String base that may or may not be a palindrome, we can always force
 * base to be a palindrome by adding letters to it. For example, given the word
 * "RACE", we could add the letters "CAR" to its back to get "RACECAR" (quotes
 * for clarity only). However, we are not restricted to adding letters at the
 * back. For example, we could also add the letters "ECA" to the front to get
 * "ECARACE". In fact, we can add letters anywhere in the word, so we could also
 * get "ERCACRE" by adding an 'E' at the beginning, a 'C' after the 'R', and
 * another 'R' before the final 'E'. Your task is to make base into a palindrome
 * by adding as few letters as possible and return the resulting String. When
 * there is more than one palindrome of minimal length that can be made, return
 * the lexicographically earliest (that is, the one that occurs first in
 * alphabetical order).
 */

public class ShortPalindromes {

    public static String getMinPalindrome(String str) {
        int N = str.length();
        int[][] sp = new int[N][N];
        int l, h;
        for (int gap = 1; gap < N; gap++) {
            for (l = 0, h = gap; h < N; l++, h++) {
                if (str.charAt(l) == str.charAt(h)) {
                    sp[l][h] = sp[l + 1][h - 1];
                } else {
                    if (sp[l][h - 1] < sp[l + 1][h]) {
                        sp[l][h] = sp[l][h - 1] + 1;
                    } else {
                        sp[l][h] = sp[l + 1][h] + 1;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(sp[i]));
        }
        l = 0;
        h = N - 1;
        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        while (l < h) {
            if (sp[l][h] == sp[l + 1][h - 1]) {
                sb.append(str.charAt(l));
                sb2.insert(0, str.charAt(h));
                l++;
                h--;
            } else if (sp[l][h] == sp[l + 1][h] + 1) {
                sb.append(str.charAt(l));
                sb2.insert(0, str.charAt(l));
                l++;
            } else {
                sb.insert(0, str.charAt(h));
                sb2.append(str.charAt(h));
                h--;
            }
        }
        sb.append(sb2);

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(getMinPalindrome("GEEKS"));
    }

}
