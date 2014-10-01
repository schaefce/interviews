package linkedLists.eopi.Q4;

import library.eopi.LLNodeTemplate.LLNode;

/*
 * 7.4 Let h1 and h2 be the heads of lists L1 and L2, respectively. Assume that
 * L1 and L2 are well-formed, that is each consists of a finite sequence of
 * nodes. (In particular, neither list has a cycle.) How would you determine if
 * there exists a node r reachable from boht h1 and h2 by following the next
 * fields? If such a node exists, find the node that appears earliest when
 * traversing the lists. You are constrained to use no more than constant
 * additional storage
 */

public class OverlappingListsNoCycles {
    public static <T> LLNode<T> getOverlap(LLNode<T> h1, LLNode<T> h2) {
        LLNode<T> p1 = h1;
        LLNode<T> p2 = h2;
        // Determine if overlap by checking if have same tail
        int l1 = 0;
        int l2 = 0;
        while (p1 != null) {
            l1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            l2++;
            p2 = p2.next;
        }
        p1 = h1;
        p2 = h2;
        if (l1 > l2) {
            for (int i = 0; i < l1 - l2; i++) {
                p2 = p2.next;
            }
        } else {
            for (int i = 0; i < l2 - l1; i++) {
                p1 = p1.next;
            }
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;

    }

    public static void main(String[] args) {
        LLNode<Integer> l1 = null;
        LLNode<Integer> l2 = null;
        // l1: 1->2->3->null
        l1 = new LLNode<>(new LLNode<>(new LLNode<>(null, 3), 2), 1);
        l2 = l1.next.next;
        assert (getOverlap(l1, l2).item == 3);
        // l2: 4->5->null
        l2 = new LLNode<>(new LLNode<>(null, 5), 4);
        assert (getOverlap(l1, l2) == null);
    }
}
