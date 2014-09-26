package eopi.arraysAndStrings.Q14;

/*
 * 6.14 Check whether a 9x9 2D array representing a partially completed Sudoku
 * is valid. Specifically, check that no row, column, and 3x3 2D subarray
 * contains duplicates. A 0-value in the 2D array indicates the entry is blank;
 * every other entry is in [1,9]
 */
public class SudokuChecker {

    public static boolean checkSudokuBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            boolean[] used = new boolean[9];
            for (int j = 0; j < board[0].length; j++) {
                int num = board[i][j];
                if (used[num] && num != 0) {
                    return false;
                } else {
                    used[num] = true;
                }
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            boolean[] used = new boolean[9];
            for (int j = 0; j < board.length; j++) {
                int num = board[j][i];
                if (used[num] && num != 0) {
                    return false;
                } else {
                    used[num] = true;
                }
            }
        }
        int subSize = (int) Math.sqrt(board.length);
        // Iterate through each sub region
        for (int isub = 0; isub < subSize; isub++) {
            for (int jsub = 0; jsub < subSize; jsub++) {
                boolean[] used = new boolean[9];
                for (int i = 0; i < subSize; i++) {
                    for (int j = 0; j < subSize; j++) {
                        int num = board[subSize * isub + i][subSize * jsub + j];
                        if (used[num] && num != 0) {
                            return false;
                        } else {
                            used[num] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
}
