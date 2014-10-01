package stacksAndQueues.eopi.Q3;

import java.util.Stack;

import library.eopi.BTNodeTemplate.BTNode;

/*
 * 8.3 Given a BST node n, print all the keys at n and its descendants. The
 * nodes should be printed in sorted order, and you cannot use recursion.
 */

public class BSTSortedOrder {
    public static <Item> void printSorted(BTNode<Item> n) {
        Stack<BTNode<Item>> stack = new Stack<>();
        if (n == null) {
            return;
        }
        BTNode<Item> curr = n;
        stack.push(n);
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.getLeft();
            } else {
                curr = stack.pop();
                System.out.println(curr.getValue());
                curr = curr.getRight();
            }
        }
    }
}
