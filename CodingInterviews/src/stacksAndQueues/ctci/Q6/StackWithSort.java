package stacksAndQueues.ctci.Q6;

import java.util.Stack;

/*
 * 3.6 Write a program to sort a stack in ascending order (with biggest items on
 * top). You may use at most one additional stack to hold items, but you may not
 * copy the elements into any other data structure (such as an array). The stack
 * supports the following operations: push, pop, peek, and isEmpty.
 */
public class StackWithSort extends Stack<Integer> {
    public Stack<Integer> sort(Stack<Integer> s1) {
        Stack<Integer> s2 = new Stack<Integer>();
        while (!s1.isEmpty()) {
            Integer tmp = s1.pop();
            while (!s2.isEmpty() && tmp.compareTo(s2.peek()) < 0) {
                s1.push(s2.pop());
            }
            s2.push(tmp);
        }
        return s2;
    }

}
