package library.implementations.hashMap;

public class LinkedListNode<K, V> {
    K key;
    V value;
    LinkedListNode<K, V> next;

    public LinkedListNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
