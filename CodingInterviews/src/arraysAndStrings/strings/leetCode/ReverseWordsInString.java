package arraysAndStrings.strings.leetCode;

public class ReverseWordsInString {
    public static String reverseWords(String s) {
        if (s == null || s.isEmpty())
            return s;
        int charPtr = s.length() - 1;
        int wordEnd = -1;
        int wordStart = -1;
        StringBuffer sb = new StringBuffer();
        while (charPtr >= 0) {
            while (charPtr >= 0 && s.charAt(charPtr) == ' ')
                charPtr--;
            if (charPtr < 0)
                break;
            if (wordStart != wordEnd) {
                sb.append(' ');
            }
            wordEnd = charPtr + 1;
            charPtr--;
            while (charPtr >= 0 && s.charAt(charPtr) != ' ')
                charPtr--;
            wordStart = charPtr + 1;
            sb.append(s.substring(wordStart, wordEnd));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = { "a b", "the sky is blue", "",
                "     the   sky   is blue" };
        for (String s : strings) {
            System.out
                    .printf("Input:\t%s\nOutput:\t%s\n\n", s, reverseWords(s));
        }
    }
}
