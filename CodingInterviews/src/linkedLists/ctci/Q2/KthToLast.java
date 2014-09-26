package ctci.linkedLists.Q2;

import CtCILibrary.LinkedListNode;

/*
 * 2.2 Implement an algorithm to find the kth to last element of a singly linked
 * list.
 */
public class KthToLast {

    public static LinkedListNode kthToLast(LinkedListNode head, int k) {
        if (k <= 0) {
            return null;
        }
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;
        for (int i = 0; i < k - 1; i++) {
            if (p2 == null) {
                return null;
            }
            p2 = p2.next;
        }
        if (p2 == null) {
            return null;
        }

        while (p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;

    }

}
