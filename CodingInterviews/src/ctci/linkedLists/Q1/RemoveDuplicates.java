package ctci.linkedLists.Q1;

import java.util.HashSet;
import java.util.Set;

import CtCILibrary.LinkedListNode;

/*
 * 2.1 Write code to remove duplicates from an unsorted linked list. FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class RemoveDuplicates {
    public static void removeDuplicates(LinkedListNode lst) {
        Set<Integer> set = new HashSet<Integer>();
        LinkedListNode previous = null;
        while (lst != null) {
            if (set.contains(lst.data)) {
                previous.next = previous.next.next;
            } else {
                set.add(lst.data);
                previous = lst;
            }
            lst = lst.next;
        }
    }

    public static void removeDuplicatesNoBuffer(LinkedListNode lst) {
        LinkedListNode curr = lst;
        while (curr != null) {
            LinkedListNode runner = curr;
            while (runner.next != null) {
                if (runner.next.data == curr.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            curr = curr.next;
        }
    }
}
