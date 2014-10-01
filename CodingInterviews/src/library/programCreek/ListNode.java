package library.programCreek;

public class ListNode<E> {
    public E value;
    public ListNode<E> next;

    public ListNode(E data, ListNode<E> next) {
        this.value = data;
        this.next = next;
    }

    public ListNode(E data) {
        this(data, null);
    }

    public String toString() {
        if (next == null) {
            return String.valueOf(value);
        } else {
            return value + "->" + next.toString();
        }
    }

}
