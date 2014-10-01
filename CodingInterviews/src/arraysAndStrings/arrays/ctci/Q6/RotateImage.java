package arraysAndStrings.arrays.ctci.Q6;

/*
 * 1.6 Given an image represented by an NxN matrix, where each pixel in the
 * image is 4 bytes, write a method to rotate the image by 90 degrees. Can you
 * do this in place?
 */
public class RotateImage {
    public static void rotateImage(int[][] image) {
        int n = image.length;
        // rotate layer by layer, from outermost to innermost
        for (int layer = 0; layer < n / 2; layer++) {
            // length for a layer depends on proximity to outermost layer (0)
            // iterate through each cell position in this layer
            int start = layer;
            int end = n - 1 - layer;

            for (int i = layer; i < end; i++) {
                int offset = i - layer;
                int topCell = image[start][i];
                image[start][i] = image[end - offset][start];
                image[end - offset][start] = image[end][end - offset];
                image[end][end - offset] = image[i][end];
                image[i][end] = topCell;
            }

        }
    }

    public static int[][] randomSquareMatrix(int length, int min, int max) {
        int[][] mat = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                mat[i][j] = ((int) (Math.random() * (max + 1 - min))) + min;
            }
        }
        return mat;
    }

    public static void printSquareMatrix(int[][] matrix) {
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int N = 4;
        int[][] matrix = randomSquareMatrix(N, 0, 3);
        printSquareMatrix(matrix);
        rotateImage(matrix);
        printSquareMatrix(matrix);

    }

}
