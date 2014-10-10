package library.leetCode;

/* Definition for singly-linked list. */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }

    @Override
    public String toString() {
        // if (next != null) {
        // return String.format("%d %s", val, next.toString());
        // } else {
        return String.format("%d", val);
        // }
    }
}
