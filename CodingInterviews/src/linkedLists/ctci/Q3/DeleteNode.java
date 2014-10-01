package linkedLists.ctci.Q3;

import library.ctci.LinkedListNode;

/*
 * 2.3 Implement an algorithm to delete a node i the middle of a singly linked
 * list, given only access to that node.
 */
public class DeleteNode {

    public static boolean deleteNode(LinkedListNode node) {
        // TODO: DETERMINE HOW TO HANDLE THESE CASES
        if (node == null || node.next == null) {
            return false;
        } else {
            node.data = node.next.data;
            node.next = node.next.next;
            return true;
        }

    }

}
