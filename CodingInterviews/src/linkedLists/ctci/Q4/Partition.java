package ctci.linkedLists.Q4;

import CtCILibrary.LinkedListNode;

/*
 * 2.4 Write code to partition a linked list around a value x, such that all
 * nodes less than x come before all nodes greater than or equal to x.
 */
public class Partition {
    public static LinkedListNode partitionStable(LinkedListNode head, int x) {
        LinkedListNode frontStart = null;
        LinkedListNode frontEnd = null;
        LinkedListNode backStart = null;
        LinkedListNode backEnd = null;
        while (head != null) {
            LinkedListNode next = head.next;
            head.next = null;
            if (head.data < x) {
                if (frontStart == null) {
                    frontStart = head;
                    frontEnd = frontStart;
                } else {
                    frontEnd.next = head;
                    frontEnd = head;
                }
            } else {
                if (backStart == null) {
                    backStart = head;
                    backEnd = backStart;
                } else {
                    backEnd.next = head;
                    backEnd = head;
                }
            }
            head = next;
        }
        if (frontStart == null) {
            return backStart;
        }

        frontEnd.next = backStart;
        return frontStart;
    }

    public static LinkedListNode partitionUnstable(LinkedListNode head, int x) {
        LinkedListNode front = head;
        LinkedListNode back = head;
        while (head != null) {
            LinkedListNode next = head.next;
            if (head.data < x) {
                head.next = front;
                front = head;
            } else {
                back.next = head;
                back = head;
            }
            head = next;
        }
        back.next = null;
        return front;
    }

}
