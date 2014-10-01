package arraysAndStrings.strings.topCoder;

/*
 * In this problem you will be given a String text and you will need to find the
 * substring of the text that matches a given template in the best way. The
 * template will be represented by two Strings: prefix and suffix. Consider a
 * string S. The prefix match score of S with respect to a given template is the
 * maximal n >= 0 such that the first n characters of S are equal to the last n
 * characters of prefix and occur in the same exact order. Analogously, the
 * suffix match score of S is the maximal m >= 0 such that the last m characters
 * of S are equal to the first m characters of suffix and occur in the same
 * exact order.
 * 
 * For example, if S = "something", prefix = "awesome", and suffix =
 * "ingenious", than the prefix score of S is 4 (the matched characters are
 * "some") and the suffix score is 3 (the matched characters are "ing").
 * 
 * The match score of a string S with respect to a given template is the sum of
 * its prefix and suffix match scores. Find the non-empty substring of text with
 * the maximal match score according to the template (prefix, suffix). In case
 * of a tie, return the substring with the maximal prefix score. If there are
 * still several candidates, return one that comes first lexicographically.
 */

public class TemplateMatching {

    public static String bestMatch(String text, String prefix, String suffix) {
        int N = text.length();
        int mps = -1;
        int mp = -1;
        String ans = "a";
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                String sub = text.substring(j, i + 1);
                int p = Math.min(sub.length(), prefix.length());
                while (p > 0
                        && !prefix.substring(prefix.length() - p).equals(
                                sub.substring(0, p)))
                    p--;
                int s = Math.min(sub.length(), suffix.length());
                while (s > 0
                        && !suffix.substring(0, s).equals(
                                sub.substring(sub.length() - s)))
                    s--;
                if (p + s > mps) {
                    mps = p + s;
                    mp = p;
                    ans = sub;
                } else if (p + s == mps && p > mp) {
                    mp = p;
                    ans = sub;
                } else if (p + s == mps && p == mp && ans.compareTo(sub) > 0) {
                    ans = sub;
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] texts = { "something", "havka", "abracadabra", "mississippi",
                "a a a a a a", "ab" };
        String[] prefixes = { "awesome", "eto", "habrahabr", "promise", "a a",
                "b" };
        String[] suffixes = { "ingenious", "papstvo", "bracket", "piccolo",
                "a", "a" };
        for (int i = 0; i < 6; i++) {
            System.out.println(i + ": \n\ttext=" + texts[i] + "\n\tprefix="
                    + prefixes[i] + "\n\tsuffix=" + suffixes[i]
                    + "\n\tsubstring="
                    + bestMatch(texts[i], prefixes[i], suffixes[i]));
        }
    }
}
