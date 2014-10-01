package stacksAndQueues.interviewCake;

import java.util.Stack;

/*
 * You're working with an intern that keeps coming to you with JavaScript code
 * that won't run because the braces, brackets, and parentheses are off. To save
 * you both some time, you decide to write a braces/brackets/parentheses
 * validator. Let's say: '(', '{', '[' are called "openers." ')', '}', ']' are
 * called "closers." Write an efficient function that tells us whether or not an
 * input string's openers and closers are properly nested. Examples:
 * "{ [ ] ( ) }" should return true "{ [ ( ] ) }" should return false "{ [ }"
 * should return false
 * 
 * O(n) time and space
 */

public class ParensValidator {
    public static boolean validate(String str) {
        Stack<Character> parens = new Stack<Character>();
        for (char c : str.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                parens.push(c);
            } else if (c == '}') {
                if (parens.pop() != '{') {
                    return false;
                }
            } else if (c == ')') {
                if (parens.pop() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (parens.pop() != '[') {
                    return false;
                }
            }
        }
        return parens.isEmpty();
    }

    public static void main(String[] args) {
        String correct = "{(5+2[{6}]){()}}";
        String incorrect = "{(5+2[{6]){()}}";
        System.out.println("Correct string got result " + validate(correct));
        System.out
                .println("Incorrect string got result " + validate(incorrect));
    }
}
