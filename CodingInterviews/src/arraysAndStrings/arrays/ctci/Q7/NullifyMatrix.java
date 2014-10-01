package arraysAndStrings.arrays.ctci.Q7;

/*
 * 1.7 Write an algorithm such that if an element in an MxN matrix is 0, its
 * entire row and column are set to 0.
 */
public class NullifyMatrix {

    public static void nullify(int[][] matrix) {
        boolean[] nullRows = new boolean[matrix.length];
        boolean[] nullCols = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    nullRows[i] = true;
                    nullCols[j] = true;
                }
            }
        }
        for (int i = 0; i < nullRows.length; i++) {
            if (nullRows[i]) {
                nullifyRow(matrix, i);
            }
        }
        for (int i = 0; i < nullCols.length; i++) {
            if (nullCols[i]) {
                nullifyColumn(matrix, i);
            }
        }
    }

    public static void nullifyRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    public static void nullifyColumn(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 0, 1, 1, 1 }, { 0, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 } };
        printMatrix(matrix);
        nullify(matrix);
        printMatrix(matrix);

    }
}
