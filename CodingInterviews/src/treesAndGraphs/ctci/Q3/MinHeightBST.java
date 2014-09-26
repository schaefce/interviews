package ctci.treesAndGraphs.Q3;

import CtCILibrary.TreeNode;

/*
 * 4.3 Given a sorted (increasing order) array with unique integer elements,
 * write an algorithm to create a BST with minimal height
 */

public class MinHeightBST {

    public TreeNode generateMinHeightBST(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + end / 2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = generateMinHeightBST(array, start, mid - 1);
        root.right = generateMinHeightBST(array, mid + 1, end);
        return root;
    }

    public TreeNode generateMinHeightBST(int[] array) {
        return generateMinHeightBST(array, 0, array.length - 1);
    }
}
