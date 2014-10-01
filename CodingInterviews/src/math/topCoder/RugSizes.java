package math.topCoder;

/*
 * Rugs come in various sizes. In fact, we can find a rug with any integer width
 * and length, except that no rugs have a distinct width and length that are
 * both even integers. For example, we can find a 4x4 rug, but not a 2x4 rug. We
 * want to know how many different choices we have for a given area.
 * 
 * Create a class RugSizes the contains a method rugCount that is given the
 * desired area and returns the number of different ways in which we can choose
 * a rug size that will cover that exact area. Do not count the same size twice
 * -- a 6 x 9 rug and a 9 x 6 rug should be counted as one choice.
 */

public class RugSizes {

    public static int rugCount(int area) {
        int[] sizes = new int[area + 1];
        int num = 0;
        for (int i = 1; i < sizes.length; i++) {
            if (sizes[i] == 0 && area % i == 0) {
                int j = area / i;
                if (i % 2 == 0 && j % 2 == 0) {
                    if (i == j) {
                        num++;
                    }
                } else {
                    sizes[i] = area / i;
                    sizes[area / i] = i;
                    num++;
                }
            }
        }
        return num;

    }

    public static void main(String[] args) {
        int[] rugs = { 4, 8 };
        for (int i = 0; i < rugs.length; i++) {
            System.out.printf("%d.\tInput: %d\n\tOutput: %d\n", i, rugs[i],
                    rugCount(rugs[i]));
        }
    }
}
