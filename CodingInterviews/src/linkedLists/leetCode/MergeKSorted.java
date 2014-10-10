package linkedLists.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import library.leetCode.ListNode;

public class MergeKSorted {
    public static ListNode mergeKLists(List<ListNode> lists) {
        ListNode head = new ListNode(0);
        ListNode mergePtr = head;
        while (!lists.isEmpty()) {
            int minIndex = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.size(); i++) {
                ListNode iList = lists.get(i);
                if (iList != null) {
                    int value = iList.val;
                    if (value < min) {
                        minIndex = i;
                        min = value;
                    }
                } else {
                    lists.remove(i);
                }
            }
            if (minIndex != -1) {
                ListNode minPtr = lists.get(minIndex);
                mergePtr.next = minPtr;
                mergePtr.next.val = min;
                mergePtr = mergePtr.next;
                if (minPtr.next != null) {
                    minPtr.next = minPtr.next.next;
                    minPtr.val = minPtr.next.val;
                    minPtr = minPtr.next;
                } else {
                    lists.remove(minIndex);
                }
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(0, new ListNode(2, new ListNode(5)));
        List<ListNode> lists = new ArrayList<ListNode>();
        lists.add(list);
        System.out.printf("Input:\t%s\nOutput:\t%s",
                Arrays.toString(lists.toArray()), mergeKLists(lists));
    }
}
