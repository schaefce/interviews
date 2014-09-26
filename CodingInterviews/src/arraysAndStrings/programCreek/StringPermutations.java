package programCreek.stringsAndArrays;

public class StringPermutations {
    public static void permute(String str) {
        char[] out = new char[str.length()];
        boolean[] used = new boolean[str.length()];
        permute(0, str.toCharArray(), out, used);
        System.out.println();
    }

    public static void permute(int index, char[] in, char[] out, boolean[] used) {
        if (index == in.length) {
            System.out.print(new String(out) + " ");
            return;
        }
        for (int i = 0; i < in.length; i++) {
            if (!used[i]) {
                out[index] = in[i];
                used[i] = true;
                permute(index + 1, in, out, used);
                used[i] = false;
            }
        }

    }

    public static void combine(String str) {
        char[] out = new char[str.length()];
        boolean[] used = new boolean[str.length()];
        combine(0, 0, 0, str.toCharArray(), out, used);
        System.out.println();
    }

    public static void combine(int start, int index, int outLength, char[] in,
            char[] out, boolean[] used) {
        for (int i = start; i < in.length; i++) {
            out[index] = in[i];
            outLength += 1;
            System.out.print(new String(out).substring(0, outLength - 1) + " ");
            if (i < in.length) {
                combine(i + 1, index + 1, outLength, in, out, used);
            }
            outLength -= 1;
        }
    }

    public static void main(String[] args) {
        permute("abcd");
        combine("abcd");
    }
}
