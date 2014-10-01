package treesAndGraphs.binarySearchTrees.eopi.Q11;

/*
 * 14.11 Which traversal orders- inorder, preorder, and postorder- of a BST can
 * be used to reconstruct the BST uniquely? Write a program that takes as input
 * a sequence of node keys and ocmputes the corresponding BST. Assume that all
 * keys are unique.
 */

import java.util.ArrayList;
import java.util.List;

import library.eopi.BTNodeTemplate.BTNode;

// TODO: determine why it is preorder
public class ConstructBSTFromPreorderTraversal {
    private static int index;

    public static BTNode<Integer> constructBST(List<Integer> preorder) {
        index = 0;
        return constructBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static BTNode<Integer> constructBST(List<Integer> preorder,
            int min, int max) {
        if (index == preorder.size()) {
            return null;
        }
        Integer curr = preorder.get(index);
        if (curr < min || curr > max) {
            return null;
        }
        index++;
        return new BTNode<Integer>(constructBST(preorder, min, curr),
                constructBST(preorder, curr, max), curr);
    }

    public static void traverse(BTNode<Integer> root) {
        if (root == null) {
            return;
        }
        visit(root);
        traverse(root.getLeft());
        traverse(root.getRight());
    }

    private static void visit(BTNode<Integer> node) {
        System.out.print(node.getValue() + " ");
    }

    private static void checkAns(BTNode<Integer> n, Integer pre) {
        if (n != null) {
            checkAns(n.getLeft(), pre);
            assert (pre <= n.getValue());
            System.out.println(n.getValue());
            checkAns(n.getRight(), n.getValue());
        }
    }

    public static void main(String[] args) {
        // 3
        // 2 5
        // 1 4 6
        // should output 1, 2, 3, 4, 5, 6
        // preorder [3, 2, 1, 5, 4, 6]
        List<Integer> preorder = new ArrayList<>();
        preorder.add(3);
        preorder.add(2);
        preorder.add(1);
        preorder.add(5);
        preorder.add(4);
        preorder.add(6);
        BTNode<Integer> root = constructBST(preorder);
        checkAns(root, Integer.MIN_VALUE);
    }
}
