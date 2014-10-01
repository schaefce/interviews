package google;

import library.ctci.LinkedListNode;

public class CircularListMinimum {
    /*
     * You are given a list of numbers. When you reach the end of the list you
     * will come back to the beginning of the list (a circular list). Write the
     * most efficient algorithm to find the minimum # in this list. Find any
     * given # in the list. The numbers in the list are always increasing but
     * you don't know where the circular list begins i.e. 38, 40, 55, 89, 6, 13,
     * 20, 23, 36.
     */

    public int getMinimum(LinkedListNode circleListHead) {
        int min = circleListHead.data;
        LinkedListNode nextNode = circleListHead.next;
        while (nextNode.data != circleListHead.data) {
            if (nextNode.data < min) {
                min = nextNode.data;
            }
        }
        return min;
    }

}
