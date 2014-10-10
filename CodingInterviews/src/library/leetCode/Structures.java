package library.leetCode;

public class Structures {
    public static TreeNode generateBST(int n) {
        if (n <= 0) {
            return null;
        }
        int[] values = new int[n];
        for (int i = 0; i < values.length; i++) {
            values[i] = i + 1;
        }
        return generateBST(values, 0, values.length - 1);
    }

    private static TreeNode generateBST(int[] A, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(A[mid]);
        root.left = generateBST(A, l, mid - 1);
        root.right = generateBST(A, mid + 1, r);
        return root;
    }
}
