package arraysAndStrings.strings.eopi.Q22;

/*
 * 6.22 Given a cell phone keypad(specified by a mapping M that takes individual
 * digits and returns the corresponding set of characters) and a number
 * sequence, return all possible character sequences(not just legal words) that
 * correspond to the number sequence
 */
public class PhoneNumberMnemonic {
    private static final String[] M = new String[] { "0", "1", "ABC", "DEF",
            "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };

    public static void getAllSequences(String number) {
        char[] sequence = new char[number.length()];
        getAllSequences(number, 0, sequence);
    }

    private static void getAllSequences(String number, int d, char[] seq) {
        if (d == number.length()) {
            System.out.println(seq);
        } else {
            for (char c : M[number.charAt(d) - '0'].toCharArray()) {
                seq[d] = c;
                getAllSequences(number, d + 1, seq);
            }
        }
    }

    public static void main(String[] args) {
        String number = "0123";
        System.out.println("Sequences for " + number + " :");
        getAllSequences(number);
        number = "27";
        System.out.println("Sequences for " + number + " :");
        getAllSequences(number);
    }
}
