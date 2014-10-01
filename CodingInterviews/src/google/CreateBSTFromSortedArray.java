package google;

import library.eopi.BTNodeTemplate.BTNode;
import library.eopi.BTreePrinter;

/*
 * int[] data create BST from integer array of data (sorted) class Node{ int
 * value; Node left; Node right; }
 */

public class CreateBSTFromSortedArray {

    public static BTNode<Integer> createBST(int[] data) {
        return createBST(data, 0, data.length - 1);

    }

    public static BTNode<Integer> createBST(int[] data, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = (lo + hi) / 2;
        BTNode<Integer> root = new BTNode<Integer>(data[mid]);
        root.setLeft(createBST(data, lo, mid - 1));
        root.setRight(createBST(data, mid + 1, hi));
        return root;

    }

    public static void main(String[] args) {
        int[] data = { 0, 3, 5, 6, 7, 9, 10, 11 };
        BTreePrinter.printNode(createBST(data));
    }

}
