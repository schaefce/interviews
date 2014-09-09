package sedgewick.fundamentals.three;

public class LinkedListExercises {
    private class Node<Item> {
        Item item;
        Node<Item> next;
    }

    /**
     * Exercise 1.3.20 Write a method delete() that takes an int argument k and
     * deletes the kth element in a linked list, if it exists.
     * 
     * @param head
     * @param k
     * @return
     */
    public static boolean deleteKth(Node<Integer> head, int k) {
        Node<Integer> curr = head;
        for (int i = 0; i < k - 1; i++) {
            if (curr == null) {
                return false;
            } else {
                curr = curr.next;
            }
        }
        curr.next = curr.next.next;
        return true;
    }

    /**
     * Exercise 1.3.21 Write a method find() that takes a linked list and a
     * string key as arguments and returns true if some node in the list has key
     * as its item field, false otherwise.
     * 
     * @param head
     * @param key
     * @return
     */
    public static boolean findKey(Node<String> head, String key) {
        Node<String> curr = head;
        while (curr != null) {
            if (curr.item.equals(key)) {
                return true;
            } else {
                curr = curr.next;
            }
        }
        return false;
    }

    /**
     * Exercise 1.3.24 Write a method removeAfter() that takes a linked-list
     * Node as argument and removes the node following the given one (and does
     * nothing if the argument or the next field in the argument node is null).
     * 
     * @param n
     */
    public static void removeAfter(Node<Integer> n) {
        if (n != null && n.next != null) {
            n.next = n.next.next;
        }
    }

    /**
     * Exercise 1.3.30 Write a function that takes the first Node in a linked
     * list as argument and (destructively) reverses the list, returning the
     * first Node in the result.
     * 
     * @param head
     * @return
     */
    public static Node<Integer> reverse(Node<Integer> head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        Node<Integer> second = head.next;
        Node<Integer> rest = reverse(second);
        second.next = head;
        head.next = null;
        return rest;
    }

}
