package programCreek.linkedLists;

import programCreek.library.ListNode;

/*
 * Given a singly linked list L: L0→L1→ ... →Ln-1→Ln, reorder it to:
 * L0→Ln→L1→Ln-1→L2→Ln-2→...
 * 
 * For example, given {1,2,3,4}, reorder it to {1,4,2,3}. You must do this
 * in-place without altering the nodes' values.
 */
public class ReorderList {

    public static void reorderList(ListNode<Integer> head) {
        ListNode<Integer> slow = head;
        ListNode<Integer> fast = head;
        // Move until end so slow points to middle of list
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split the two lists
        ListNode<Integer> secondHead = slow.next;
        slow.next = null;

        // Reverse the second list
        secondHead = reverseList(secondHead);

        // Merge the lists
        ListNode<Integer> p1 = head;
        ListNode<Integer> p2 = secondHead;
        while (p2 != null) {
            ListNode<Integer> tmp1 = p1.next;
            ListNode<Integer> tmp2 = p2.next;
            p1.next = p2;
            p2.next = tmp1;
            p1 = tmp1;
            p2 = tmp2;
        }

    }

    private static ListNode<Integer> reverseList(ListNode<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode<Integer> prev = head;
        ListNode<Integer> curr = head.next;
        while (curr != null) {
            ListNode<Integer> tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        // Make sure to set head's next to null or cycle
        head.next = null;
        return prev;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<Integer>(1,
                new ListNode<Integer>(2, new ListNode<Integer>(3,
                        new ListNode<Integer>(4))));
        System.out.println(head);
        reorderList(head);
        System.out.println(head);
    }

}
