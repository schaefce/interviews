package bitManipulation.ctci.Q1;

public class InsertMIntoN {
    public static int insertM(int M, int N, int i, int j) {
        int left = (~0) << (j + 1);
        int right = (1 << i) - 1;
        int mask = left | right;
        int clearedN = N & mask;
        int shiftedM = M << i;
        return clearedN | shiftedM;
    }

}
