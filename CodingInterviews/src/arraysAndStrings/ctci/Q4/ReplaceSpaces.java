package ctci.arraysAndStrings.Q4;

/*
 * Question 1.4: Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the end of the string
 * to hold the additional characters, and that you are given the "true" length
 * of the string. (Note: if implementing in Java, please use a character array
 * so that you can perform this operation in place.)
 */
public class ReplaceSpaces {
    public static void replaceSpaces(char[] str, int length) {
        int newLength = getNewLength(str, length);
        str[newLength] = '\0'; // Forgot this the first time
        for (int i = length - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength -= 3;
            } else {
                str[newLength - 1] = str[i];
                newLength -= 1;
            }
        }
    }

    public static int getNewLength(char[] str, int length) {
        int cnt = 0;
        for (int i = 0; i < length; i++) {
            if (str[i] == ' ') {
                cnt++;
            }
        }
        return length + cnt * 2;
    }

    public static String charArrayToString(char[] array) {
        StringBuilder buffer = new StringBuilder(array.length);
        for (char c : array) {
            if (c == 0) {
                break;
            }
            buffer.append(c);
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        String str = "abc d e f";
        char[] arr = new char[str.length() + 3 * 2 + 1];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        replaceSpaces(arr, str.length());
        System.out.println("\"" + charArrayToString(arr) + "\"");
    }

}
