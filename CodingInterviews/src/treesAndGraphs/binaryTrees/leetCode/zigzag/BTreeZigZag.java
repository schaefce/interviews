package treesAndGraphs.binaryTrees.leetCode.zigzag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 *
 * For example: Given binary tree 3 / \ 9 20 / \ 15 7
 *
 * return its zigzag level order traversal as: [ [3], [20,9], [15,7] ]
 */
public class BTreeZigZag {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        Stack<TreeNode> currLevel = new Stack<TreeNode>();
        currLevel.add(root);
        boolean inOrder = true;
        while (!currLevel.isEmpty() && currLevel.peek() != null) {
            Stack<Integer> currValues = new Stack<Integer>();
            Stack<TreeNode> nextLevel = new Stack<TreeNode>();
            while (!currLevel.isEmpty() && currLevel.peek() != null) {
                TreeNode curr = currLevel.pop();
                currValues.add(curr.val);
                if (!inOrder) {
                    if (curr.right != null)
                        nextLevel.push(curr.right);
                    if (curr.left != null)
                        nextLevel.push(curr.left);
                } else {
                    if (curr.left != null)
                        nextLevel.push(curr.left);
                    if (curr.right != null)
                        nextLevel.push(curr.right);
                }
            }
            levels.add(currValues);
            currLevel = nextLevel;
            inOrder = !inOrder;

        }
        return levels;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        root2.left = new TreeNode(15);
        root2.right = new TreeNode(7);
        root.right = root2;
        System.out.println(Arrays.toString(zigzagLevelOrder(root).toArray()));
    }
}
