package sedgewick.fundamentals.three;

public class FixedCapacityStackOfStrings {
    private String[] entries;
    private int N;

    public FixedCapacityStackOfStrings(int capacity) {
        entries = new String[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(String item) {
        entries[N++] = item;
    }

    public String pop() {
        return entries[--N];
    }

    /**
     * Exercise 1.3.1 Add a method isFull() to FixedCapacityStackOfStrings.
     * 
     * @return
     */
    public boolean isFull() {
        return entries.length == N;
    }
}
