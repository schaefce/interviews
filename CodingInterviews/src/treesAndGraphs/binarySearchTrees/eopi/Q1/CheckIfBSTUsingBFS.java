package eopi.binarySearchTrees.Q1;

import java.util.LinkedList;

import eopi.library.BTNodeTemplate.BTNode;
import eopi.library.BTreePrinter;

/*
 * 14.1 Write a function that takes as input the root of a binary tree whose
 * nodes have a key filed and returns true if the tree satisfies the BST
 * property
 */
public class CheckIfBSTUsingBFS {
    public static class QBTNode {
        public BTNode<Integer> node;
        public Integer lower;
        public Integer upper;

        public QBTNode(BTNode<Integer> node, Integer lower, Integer upper) {
            this.node = node;
            this.lower = lower;
            this.upper = upper;
        }
    }

    public static boolean checkIfBST(BTNode<Integer> root) {
        LinkedList<QBTNode> queue = new LinkedList<QBTNode>();
        queue.addFirst(new QBTNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        while (!queue.isEmpty()) {
            if (queue.getFirst().node != null) {
                QBTNode qbtnode = queue.getFirst();
                if (qbtnode.node.getValue().compareTo(qbtnode.lower) < 0
                        || qbtnode.node.getValue().compareTo(qbtnode.upper) > 0) {
                    return false;
                }
                queue.addLast(new QBTNode(qbtnode.node.getLeft(),
                        qbtnode.lower, qbtnode.node.getValue()));
                queue.addLast(new QBTNode(qbtnode.node.getRight(), qbtnode.node
                        .getValue(), qbtnode.upper));
            }
            queue.removeFirst();
        }
        return true;
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
