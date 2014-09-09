package ctci.stacksAndQueues.Q1;

/*
 * Implement three stacks using a single array
 */
public class ThreeStacksFixedSize<Item> {
    private final int stackSize;
    private Item[] buffer;
    private int[] ptrs = { -1, -1, -1 };

    public ThreeStacksFixedSize(int c) {
        this.stackSize = c / 3;
        buffer = (Item[]) new Object[c];
    }

    public void push(int stackNum, Item item) {
        if (ptrs[stackNum] + 1 < stackSize) {
            ptrs[stackNum]++;
            buffer[topOfStack(stackNum)] = item;
        }
    }

    public Item pop(int stackNum) {
        Item ret = null;
        if (!isEmpty(stackNum)) {
            ret = buffer[topOfStack(stackNum)];
            buffer[topOfStack(stackNum)] = null;
            ptrs[stackNum]--;
        }
        return ret;
    }

    public Item peek(int stackNum) {
        Item ret = null;
        if (!isEmpty(stackNum)) {
            ret = buffer[topOfStack(stackNum)];
        }
        return ret;
    }

    public boolean isEmpty(int stackNum) {
        return ptrs[stackNum] == -1;
    }

    public int topOfStack(int stackNum) {
        return stackSize * stackNum + ptrs[stackNum];
    }
}
