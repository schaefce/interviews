package ctci.linkedLists.Q3;

import CtCILibrary.LinkedListNode;

/*
 * Implement an algorithm to delete a node i the middle of a singly linked list,
 * given only access to that node.
 */
public class DeleteNode {

    public static boolean deleteNode(LinkedListNode node) {
        // DETERMINE HOW TO HANDLE THESE CASES
        if (node == null || node.next == null) {
            return false;
        } else {
            node.data = node.next.data;
            node.next = node.next.next;
            return true;
        }

    }

}
