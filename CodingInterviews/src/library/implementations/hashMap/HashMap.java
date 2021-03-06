package library.implementations.hashMap;

/* My implementation of a hashmap */

public class HashMap<K, V> {
    private double loadFactor = .75;
    private LinkedListNode<K, V>[] buckets;
    private int numEntries;

    // TODO: determine good hash function
    public static int hash(int h) {
        return h;
    }

    public void put(K key, V value) {
        if (numEntries / buckets.length > loadFactor) {
            resize();
        }
        int index = hash(key.hashCode()) % buckets.length;
        if (buckets[index] == null) {
            buckets[index] = new LinkedListNode<K, V>(key, value);
        } else {
            LinkedListNode<K, V> curr = buckets[index];
            while (curr.next != null) {
                if ((curr.key).equals(key)) {
                    curr.value = value;
                    break;
                }
                curr = curr.next;
            }
            curr.next = new LinkedListNode<K, V>(key, value);
        }
    }

    public V get(K key) {
        int index = hash(key.hashCode()) % buckets.length;
        if (buckets[index] != null) {
            LinkedListNode<K, V> curr = buckets[index];
            while (curr.next != null) {
                if ((curr.key).equals(key)) {
                    return curr.value;
                }
            }
        }
        return null;
    }

    private void resize() {
        LinkedListNode<K, V>[] newBuckets = (LinkedListNode<K, V>[]) new Object[(int) (buckets.length * 1.5)];
        for (int i = 0; i < buckets.length; i++) {
            newBuckets[i] = buckets[i];
        }
        buckets = newBuckets;
    }

}
