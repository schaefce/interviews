package eopi.binarySearchTrees.Q1;

import eopi.library.BTNodeTemplate.BTNode;
import eopi.library.BTreePrinter;

/*
 * 14.1 Write a function that takes as input the root of a binary tree whose
 * nodes have a key filed and returns true if the tree satisfies the BST
 * property
 */
public class CheckIfBST {

    public static boolean checkIfBST(BTNode<Integer> root) {
        return checkIfBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean checkIfBST(BTNode<Integer> root, Integer lower,
            Integer upper) {
        if (root == null) {
            return true;
        }
        if (root.getValue().compareTo(lower) < 0
                || root.getValue().compareTo(upper) > 0) {
            return false;
        }
        return (checkIfBST(root.getLeft(), lower, root.getValue()) && checkIfBST(
                root.getRight(), root.getValue(), upper));
    }

    public static void main(String[] args) {
        BTNode<Integer> root = new BTNode<>(10);
        assert (checkIfBST(root) == true);
        BTreePrinter.printNode(root);

        root.setLeft(new BTNode<Integer>(2));
        assert (checkIfBST(root) == true);
        BTreePrinter.printNode(root);

        root.setRight(new BTNode<Integer>(20));
        assert (checkIfBST(root) == true);
        BTreePrinter.printNode(root);

        root.setLeft(new BTNode<Integer>(new BTNode<Integer>(1),
                new BTNode<Integer>(4), 2));
        assert (checkIfBST(root) == true);
        BTreePrinter.printNode(root);

        root.setRight(new BTNode<Integer>(new BTNode<Integer>(30),
                new BTNode<Integer>(30), 20));
        assert (checkIfBST(root) == false);
        BTreePrinter.printNode(root);

    }
}
