package stacksAndQueues.ctci.Q5;

import java.util.Stack;

/* 3.5 Implement a queue using two stacks */
public class QueueTwoStacks<E> {
    private Stack<E> newAtTop;
    private Stack<E> oldAtTop;

    public void enqueue(E item) {
        newAtTop.push(item);
    }

    public E dequeue() {
        shiftStacks();
        return oldAtTop.pop();
    }

    public E peek() {
        shiftStacks();
        return oldAtTop.peek();
    }

    private void shiftStacks() {
        if (oldAtTop.isEmpty()) {
            while (!newAtTop.isEmpty()) {
                oldAtTop.push(oldAtTop.pop());
            }
        }
    }

    public int size() {
        return newAtTop.size() + oldAtTop.size();
    }

    public boolean isEmpty() {
        return newAtTop.isEmpty() && oldAtTop.isEmpty();
    }
}
