package treesAndGraphs.ctci.Q4;

import java.util.ArrayList;
import java.util.LinkedList;
/*
 * 4.4 Given a binary tree, design an algorithm which creates a linked list of
 * all of the nodes at each depth (e.g. if you have a tree with depth D, you'll
 * have D linked lists)
 */

import library.ctci.TreeNode;

// Blegh
public class DepthLinkedLists {

    private void generateLevelLinkedLists(TreeNode root, int depth,
            ArrayList<LinkedList<TreeNode>> lists) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> list = null;
        if (lists.size() == depth) {
            list = new LinkedList<TreeNode>();
            lists.add(list);
        } else {
            list = lists.get(depth);
        }
        list.add(root);
        generateLevelLinkedLists(root.left, depth + 1, lists);
        generateLevelLinkedLists(root.right, depth + 1, lists);
    }

    public ArrayList<LinkedList<TreeNode>> generateLevelLinkedLists(
            TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        generateLevelLinkedLists(root, 0, lists);
        return lists;
    }
}
