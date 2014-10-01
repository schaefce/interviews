package linkedLists.programCreek;

import library.programCreek.ListNode;

/*
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 */

public class AddTwoNumbers {
    public static ListNode<Integer> addTwoNumbers(ListNode<Integer> h1,
            ListNode<Integer> h2) {

        ListNode<Integer> sum = new ListNode<Integer>(0);
        ListNode<Integer> ptr1 = h1;
        ListNode<Integer> ptr2 = h2;
        ListNode<Integer> ptr3 = sum;
        int carry = 0;

        while (ptr1 != null || ptr2 != null) {
            if (ptr1 != null) {
                carry += ptr1.value;
                ptr1 = ptr1.next;
            }
            if (ptr2 != null) {
                carry += ptr2.value;
                ptr2 = ptr2.next;
            }
            ptr3.next = new ListNode<Integer>(carry % 10);
            ptr3 = ptr3.next;

            carry /= 10;

        }
        if (carry != 0) {
            ptr3.next = new ListNode<Integer>(carry);
        }
        return sum.next;
    }

    public static ListNode<Integer> createNumber(int[] digits) {
        ListNode<Integer> number = new ListNode<Integer>(0);
        ListNode<Integer> ptr = number;
        for (int i : digits) {
            ptr.next = new ListNode<Integer>(i);
            ptr = ptr.next;
        }
        return number.next;
    }

    public static void main(String[] args) {
        int[] n1 = { 2, 4, 9 };
        int[] n2 = { 5, 6, 4 };
        ListNode<Integer> number1 = createNumber(n1);
        ListNode<Integer> number2 = createNumber(n2);
        ListNode<Integer> number3 = addTwoNumbers(number1, number2);
        System.out.println(number1);
        System.out.println(number2);
        System.out.println(number3);
    }

}
