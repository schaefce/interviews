package sedgewick.fundamentals.three;

/*
 * 1.3.33 Deque. A double-ended queue or deque (pronounced "deck") is like a
 * stack or a queue but supports adding and removing items at both ends.Write a
 * class Deque that uses a doubly-linked list to implement this API
 */
public class Deque<Item> {
    private Node left;
    private Node right;
    private int size;

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    public boolean isEmpty() {
        // Is the Deque empty?
        return left == right && left == null;
    }

    public int size() {
        // Number of items in the deque
        return size;
    }

    public void pushLeft(Item item) {
        // Add item to left end
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = left;
        if (isEmpty()) {
            right = newNode;
        } else {
            left.prev = newNode;
        }
        left = newNode;

    }

    public void pushRight(Item item) {
        // Add item to right end
        Node newNode = new Node();
        newNode.item = item;
        newNode.prev = right;
        if (isEmpty()) {
            left = newNode;
        } else {
            right.next = newNode;
        }
        right = newNode;

    }

    public Item popLeft() {
        // remove item from left end
        Item item = null;
        if (!isEmpty()) {
            item = left.item;
            left = left.next;
            if (left == null) {
                right = null;
            } else {
                left.prev = null;
            }
        }
        return item;

    }

    public Item popRight() {
        // remove item from right end
        Item item = null;
        if (!isEmpty()) {
            item = right.item;
            right = right.prev;
            if (right == null) {
                left = null;
            } else {
                right.next = null;
            }
        }
        return item;
    }
}
