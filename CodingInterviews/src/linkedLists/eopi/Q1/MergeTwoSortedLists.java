package eopi.linkedLists.Q1;

import eopi.library.LLNodeTemplate.LLNode;
import eopi.utils.Ref;

/*
 * 7.1 Let L and F be singly linked lists in which each node holds a number.
 * Assume the numbers in L and F appear in ascending order witihin the lists.
 * Write a function that takes L and F, and returns the merge of L and F. Your
 * code should use O(1) additional storage - it should reuse the nodes from the
 * lists provided as input. The only field you can change in a node is next.
 */

public class MergeTwoSortedLists {

    private static <T> void appendNode(Ref<LLNode<T>> head,
            Ref<LLNode<T>> tail, Ref<LLNode<T>> node) {
        if (head.value == null) {
            head.value = node.value;
        } else {
            tail.value.next = node.value;
        }
        tail.value = node.value;
    }

    private static <T> void appendNodeAndAdvance(Ref<LLNode<T>> head,
            Ref<LLNode<T>> tail, Ref<LLNode<T>> node) {
        appendNode(head, tail, node);
        node.value = node.value.next;
    }

    public static <T extends Comparable<T>> LLNode<T> merge(LLNode<T> L,
            LLNode<T> F) {
        Ref<LLNode<T>> Lptr = new Ref<LLNode<T>>(L);
        Ref<LLNode<T>> Fptr = new Ref<LLNode<T>>(F);
        Ref<LLNode<T>> Mhead = new Ref<LLNode<T>>(null);
        Ref<LLNode<T>> Mtail = new Ref<LLNode<T>>(null);

        while (Lptr.value != null && Fptr.value != null) {
            appendNodeAndAdvance(Mhead, Mtail,
                    Lptr.value.item.compareTo(Fptr.value.item) < 0 ? Lptr
                            : Fptr);
        }

        if (Lptr.value != null) {
            appendNode(Mhead, Mtail, Lptr);
        }
        if (Fptr != null) {
            appendNode(Mhead, Mtail, Fptr);
        }

        return Mhead.value;
    }

}
