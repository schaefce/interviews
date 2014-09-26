package ctci.stacksAndQueues.Q1;

/*
 * Implement three stacks using a single array
 */
public class ThreeStacksDynamicSize<Item> {
    private static class StackData {
        private int start;
        private int capacity;
        private int size = 0;
        private int pointer;

        private StackData(int start, int capacity) {
            this.pointer = start - 1;
            this.capacity = capacity;
            this.start = start;
        }

        private boolean isWithinStack(int index, int total_size) {
            if (start < index && index < start + capacity) {
                return true;
            } else if (start + capacity > total_size
                    && index < start + capacity % total_size) {
                return true;
            }
            return false;
        }
    }

    private static int defaultSize = 10;
    private static int numStacks = 3;
    private static int totalSize = defaultSize * numStacks;
    private static StackData[] stacks = { new StackData(0, defaultSize),
            new StackData(defaultSize, defaultSize),
            new StackData(defaultSize * 2, defaultSize) };
    private static int[] buffer = new int[totalSize];

    public static int getNumElements() {
        return stacks[0].size + stacks[1].size + stacks[2].size;
    }

    public static int pop(int stackNum) {
        StackData stack = stacks[stackNum];
        if (stack.size != 0) {
            int item = buffer[stack.pointer];
            buffer[stack.pointer] = 0;
            stack.size--;
            stack.pointer = getPreviousElement(stack.pointer);
            return item;
        }
        return -1;
    }

    public static int peek(int stackNum) {
        StackData stack = stacks[stackNum];
        if (stack.size != 0) {
            return buffer[stack.pointer];
        }
        return -1;
    }

    public static boolean isEmpty(int stackNum) {
        StackData stack = stacks[stackNum];
        return stack.size == 0;
    }

    public static void push(int stackNum, int item) {
        StackData stack = stacks[stackNum];
        if (stack.size >= stack.capacity) {
            if (getNumElements() == totalSize) {
                return;
            } else {
                expand(stackNum);
            }
        }
    }

    public static void expand(int stackNum) {
        shift((stackNum + 1) % numStacks);
        stacks[stackNum].capacity++;
    }

    public static void shift(int stackNum) {
        StackData stack = stacks[stackNum];
        if (stack.size >= stack.capacity) {
            shift((stackNum + 1) % numStacks);
            stack.capacity++;
        }
        for (int i = (stack.start + stack.capacity - 1) % totalSize; stack
                .isWithinStack(i, totalSize); i = getPreviousElement(i)) {
            buffer[i] = buffer[getPreviousElement(i)];
        }
        buffer[stack.start] = 0;
        stack.start = getNextElement(stack.start);
        stack.pointer = getNextElement(stack.pointer);
        stack.capacity--;
    }

    public static int getNextElement(int i) {
        if (i == totalSize - 1) {
            return 0;
        }
        return i + 1;
    }

    public static int getPreviousElement(int i) {
        if (i == 0) {
            return totalSize - 1;
        }
        return i - 1;
    }

}
