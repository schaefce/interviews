package treesAndGraphs.ctci.Q1;

/*
 * 4.1 Implement a function to check if a binary tree is balanced. For the
 * purposes of this question, a balanced tree is defined to be a tree such that
 * the heights of the two subtrees of any node never differ by more than one
 */
public class BalancedBST {
    private static class TreeNode {
        TreeNode right;
        TreeNode left;
    }

    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    public int checkHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }

        int diff = leftHeight - rightHeight;
        if (Math.abs(diff) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
