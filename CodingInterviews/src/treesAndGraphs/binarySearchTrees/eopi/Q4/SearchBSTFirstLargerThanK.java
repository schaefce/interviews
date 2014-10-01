package treesAndGraphs.binarySearchTrees.eopi.Q4;

import library.eopi.BTNodeTemplate.BTNode;

/*
 * 14.4 Write a function that takes a BST T and a key k, and returns the first
 * entry larger than k that would appear in an inorder walk. If k is absent or
 * no key larger than k is present, return null.
 */

public class SearchBSTFirstLargerThanK {
    public static BTNode<Integer> searchBST(BTNode<Integer> root, Integer k) {
        boolean foundK = false;
        BTNode<Integer> curr = root;
        BTNode<Integer> first = null;
        while (curr != null) {
            int comparison = curr.getValue().compareTo(k);
            // if current value equals k, set foundK and search right
            if (comparison == 0) {
                foundK = true;
                curr = curr.getRight();
            }
            // if current value is greater than k, set first and search left
            else if (comparison > 0) {
                first = curr;
                curr = curr.getLeft();
            }
            // if current value is less than k, search right
            else {
                curr = curr.getRight();
            }
        }
        return foundK ? first : null;
    }

    public static void main(String[] args) {
        // 3
        // 2 5
        // 1 4 7
        BTNode<Integer> root = new BTNode<>(3);
        root.setLeft(new BTNode<>(2));
        root.getLeft().setLeft(new BTNode<>(1));
        root.setRight(new BTNode<>(5));
        root.getRight().setLeft(new BTNode<>(4));
        root.getRight().setRight(new BTNode<>(7));
        assert (searchBST(root, 1) == root.getLeft());
        assert (searchBST(root, 5) == root.getRight().getRight());
        assert (searchBST(root, 6) == null);
        assert (searchBST(root, 7) == null);
    }
}
