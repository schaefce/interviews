package treesAndGraphs.binarySearchTrees.leetCode;

import library.leetCode.ListNode;
import library.leetCode.TreeNode;

/*
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */

public class SortedListToBST {
    public static TreeNode sortedListToBST(ListNode head) {
        ListNode ptr = head;
        int n = getListLength(ptr);
        ptr = head;
        return sortedListToBST(ptr, 0, n - 1);
    }

    private static TreeNode sortedListToBST(ListNode head, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode left = sortedListToBST(head, start, mid - 1);
        TreeNode root = new TreeNode(head.val);
        root.left = left;
        if (head.next != null) { // "move to next"
            head.val = head.next.val;
            head.next = head.next.next;
            root.right = sortedListToBST(head, mid + 1, end);
        }
        return root;
    }

    private static int getListLength(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
