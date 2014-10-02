package google;

import java.util.ArrayList;
import java.util.Arrays;

public class Google2 {

    static String arrToString(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i].length() + "|" + arr[i]);
        }
        return sb.toString();
    }

    static String arrToString2(String[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append(arr.length + "|");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                sb.append("-1|");
            } else {
                sb.append(arr[i].length() + "|" + arr[i]);
            }
        }
        return sb.toString();
    }

    static String[] stringToArr(String s) {
        ArrayList<String> al = new ArrayList<String>();
        int count = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                count = Integer.parseInt(s.substring(start, i));
                al.add(s.substring((i + 1), (i + 1) + count));
                start = (i + 1) + count;
                i += count;
            }
        }

        // return (String[]) al.toArray(); //Has a typecast error

        String[] arr = new String[al.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = al.get(i);
        }
        return arr;
    }

    static String[] stringToArr2(String s) {
        int i = 0, start = 0, count = 0;
        while (i < s.length() && s.charAt(i) != '|') {
            i++;
        }
        String[] strings = new String[Integer.parseInt(s.substring(start, i))];
        start = i + 1;
        i = start;
        int index = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '|') {
                count = Integer.parseInt(s.substring(start, i));
                i++;
                if (count != -1) {
                    strings[index] = s.substring(i, i + count);
                    start = i + count;
                    i += count;
                } else {
                    strings[index] = new String();
                    start = i;
                }
                index++;
            } else {
                i++;
            }
        }
        return strings;
    }

    public static void main(String[] args) {
        // String[] arr = {"abc", "cde", "fgh", "ijk"};
        String[] arr = { "234||123}a adsf", "sadf1|214 abc", "sad|||214 af",
                "asdfkkfdao|.,21" };
        String s = arrToString(arr);
        System.out.println(s);
        String[] arr2 = stringToArr(s);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
        String[] arr3 = { "234||123}a adsf", "sadf1|214 abc", "sad|||214 af",
                "asdfkkfdao|.,21", null };
        String s2 = arrToString2(arr3);
        System.out.println(s2);
        String[] arr4 = stringToArr2(s2);
        System.out.println(Arrays.toString(arr4));
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr4[i]);
        }

    }

}
