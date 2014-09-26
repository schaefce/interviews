package interviewCake;

import java.util.Stack;

/*
 * Write an extended stack class that has a function getLargest() for returning
 * the largest element in the stack.
 * 
 * O(1) time for all ops O(m) space, where m is number ops performed on stack
 */
public class maxStack {
    Stack<Integer> maxStack = new Stack<Integer>();
    Stack<Integer> stack = new Stack<Integer>();

    public void push(Integer item) {
        stack.push(item);
        if (item >= maxStack.peek()) {
            maxStack.push(item);
        }
    }

    public Integer pop() {
        Integer item = stack.pop();
        if (item == maxStack.peek()) {
            maxStack.pop();
        }
        return item;
    }

    public Integer getLargest() {
        return maxStack.peek();
    }
}
