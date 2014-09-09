package sedgewick.fundamentals.three;

/*
 * 1.3.32 A stack-ended queue or steque is a data type that supports push, pop,
 * and enqueue. Articulate an API for this ADT. Develop a linked-list-based
 * implementation.
 */
public class Steque<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        // Add item to bottom of stack
        Node newNode = new Node();
        newNode.item = item;
        if (size() == 0) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        N++;
    }

    public void push(Item item) {
        // Add item to top of stack
        Node newNode = new Node();
        newNode.item = item;
        if (size() == 0) {
            first = last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
        N++;
    }

    public Item pop() {
        // Remove item from top of stack
        Item item = null;
        if (size() > 0) {
            item = first.item;
            if (size() == 1) {
                first = last = null;
            } else {
                first = first.next;
            }
            N--;
        }
        return item;

    }

}
