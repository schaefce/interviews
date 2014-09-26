package programCreek.treesAndHeaps;

import java.util.Stack;

import programCreek.library.BTNode;

/* Given a binary tree, flatten it to a linked list in-place. */
public class FlattenBTree {

    public static void flatten(BTNode<Integer> root) {
        Stack<BTNode<Integer>> nodeStack = new Stack<BTNode<Integer>>();

        BTNode<Integer> p = root;
        while (p != null || !nodeStack.isEmpty()) {
            if (p.right != null) {
                nodeStack.push(p.right);
            }
            if (p.left != null) {
                p.right = p.left;
                p.left = null;
            } else if (!nodeStack.isEmpty()) {
                p.right = nodeStack.pop();
            }
            p = p.right;
        }

    }

}
