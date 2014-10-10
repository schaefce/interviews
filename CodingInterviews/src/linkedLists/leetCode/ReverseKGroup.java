package linkedLists.leetCode;

import library.leetCode.ListNode;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2 || head == null || head.next == null) {
            return head;
        }
        ListNode groupHead = head;
        ListNode groupTail = getTail(head, k);
        if (groupTail == null) {
            return head;
        }
        ListNode nextHead, prevTail = null;
        head = groupTail;
        while (groupTail != null) {
            nextHead = groupTail.next;
            reverseKGroupHelper(groupHead, k);
            if (prevTail != null) {
                prevTail.next = groupTail;
            }
            prevTail = groupHead;
            groupHead.next = nextHead;
            groupHead = nextHead;
            groupTail = getTail(groupHead, k);
        }
        return head;
    }

    private void reverseKGroupHelper(ListNode groupHead, int k) {
        if (k <= 1) {
            return;
        }
        reverseKGroupHelper(groupHead.next, k - 1);
        groupHead.next.next = groupHead;
    }

    private ListNode getTail(ListNode head, int k) {
        ListNode curr = head;
        while (k > 1) {
            if (curr == null)
                return null;
            curr = curr.next;
            k--;
        }
        return curr;
    }

}
