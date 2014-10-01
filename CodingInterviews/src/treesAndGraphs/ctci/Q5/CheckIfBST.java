package treesAndGraphs.ctci.Q5;

import library.ctci.TreeNode;

/* 4.5 Implement a function to check if a binary tree is a binary search tree */
public class CheckIfBST {
    public boolean isBST(TreeNode root) {
        return isBST(root, null, null);
    }

    public boolean isBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.data <= min)
                || (max != null && root.data > max)) {
            return false;
        }
        if (!isBST(root.left, min, root.data)
                || !isBST(root.right, root.data, max)) {
            return false;
        }
        return true;
    }
}
