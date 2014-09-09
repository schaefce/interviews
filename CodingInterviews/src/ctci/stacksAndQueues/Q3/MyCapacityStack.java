package ctci.stacksAndQueues.Q3;

public class MyCapacityStack<Item> {

    private class Node {
        private Item item;
        private Node next;
    }

    private int capacity;
    private int size = 0;
    private Node top;

    public MyCapacityStack(int cap) {
        this.capacity = cap;
    }

    public boolean push(Item item) {
        if (size + 1 > capacity) {
            return false;
        } else {
            Node newNode = new Node();
            newNode.item = item;
            newNode.next = top;
            size++;
            return true;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Item pop() {
        if (size > 0) {
            Item item = top.item;
            top = top.next;
            size--;
            return item;
        } else {
            return null;
        }
    }

}