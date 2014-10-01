package sorting.topCoder;

/*
 * John is obsessed with security. He is writing a letter to his friend Brus and
 * he wants nobody else to be able to read it. He uses a simple substitution
 * cipher to encode his message. Each letter in the message is replaced with its
 * corresponding letter in a substitution alphabet. A substitution alphabet is a
 * permutation of all the letters in the original alphabet. In this problem, the
 * alphabet will consist of only lowercase letters ('a'-'z'). For example, if
 * John's message is "hello" and his cipher maps 'h' to 'q', 'e' to 'w', 'l' to
 * 'e' and 'o' to 'r', the encoded message will be "qweer". If the cipher maps
 * 'h' to 'a', 'e' to 'b', 'l' to 'c' and 'o' to 'd', then the encoded message
 * will be "abccd".
 * 
 * Given the original message, determine the cipher that will produce the
 * encoded string that comes earliest alphabetically. Return this encoded
 * string. In the example above, the second cipher produces the alphabetically
 * earliest encoded string ("abccd").
 */

public class EncodedMessage {

    public static String encode(String message) {
        char[] mapping = new char[26];
        for (int i = 0; i < mapping.length; i++) {
            mapping[i] = (char) 0;
        }
        int count = 'a';
        StringBuffer output = new StringBuffer();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (mapping[c - 'a'] != (char) 0) {
                output.append(mapping[c - 'a']);
            } else {
                mapping[c - 'a'] = (char) count;
                output.append((char) count);
                count++;
            }
        }
        return output.toString();
    }

    public static void main(String[] args) {
        String[] messages = { "hello", "abcde", "topcoder", "encryption" };
        for (int i = 0; i < messages.length; i++) {
            System.out.printf("%d.\tInput: %s\n\tOutput: %s\n", i, messages[i],
                    encode(messages[i]));
        }
    }

}
