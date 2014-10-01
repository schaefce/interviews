package library.implementations.stack;

public class LinkedListStack<Item> {
    private class Node {
        Item item;
        Node next;
    }

    private Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(Item item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = top;
        top = newNode;
    }

    public Item pop() {
        Item ret = null;
        if (top != null) {
            ret = top.item;
            top = top.next;
        }
        return ret;
    }

    public Item peek() {
        Item ret = null;
        if (top != null) {
            ret = top.item;
        }
        return ret;
    }
}
