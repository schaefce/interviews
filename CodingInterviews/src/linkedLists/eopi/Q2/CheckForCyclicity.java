package eopi.linkedLists.Q2;

import eopi.library.LLNodeTemplate.LLNode;

/*
 * 7.2 Given a reference to the head of a singly linked list L, how would you
 * determine whether L ends in a null or reaches a cycle of nodes? Write a
 * function that returns null if there does not exist a cycle and the reference
 * to the start of the cycle if a cycle is present
 */

public class CheckForCyclicity {
    public static <T> LLNode<T> hasCycle(LLNode<T> L) {
        LLNode<T> slow = L;
        LLNode<T> fast = L;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = L;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        LLNode<Integer> l3 = new LLNode<>(null, 3);
        LLNode<Integer> l2 = new LLNode<>(l3, 2);
        LLNode<Integer> l1 = new LLNode<>(l2, 1);

        // should output "l1 does not have cycle."
        assert (hasCycle(l1) == null);
        System.out.println("l1 "
                + (hasCycle(l1) != null ? "has" : "does not have") + " cycle.");

        // make it a cycle
        l3.next = l2;
        // should output "l1 has cycle, located at node has value 2"
        assert (hasCycle(l1) != null);
        assert (hasCycle(l1).item == 2);
        LLNode<Integer> temp = hasCycle(l1);
        if (temp != null) {
            System.out.println("l1 has cycle, located at node has value "
                    + temp.item);
        } else {
            System.out.println("l1 does not have cycle");
        }
    }
}
