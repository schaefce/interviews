package treesAndGraphs.binarySearchTrees.eopi.Q6;

import java.util.Random;

/*
 * 14.6 How would you build a BST of minimum possible height from a sorted array
 * A?
 */

public class BuildBSTFromSortedArray {
    public static class Node {
        public Node left;
        public Node right;
        public int data;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(int data) {
            this(data, null, null);
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public int getData() {
            return data;
        }
    }

    public static Node buildBST(int[] A) {
        return buildBST(A, 0, A.length - 1);
    }

    private static Node buildBST(int[] A, int lo, int hi) {
        if (lo > hi) {
            return null;
        } else {
            int mid = lo + ((hi - lo) / 2);
            return new Node(A[mid], buildBST(A, lo, mid - 1), buildBST(A,
                    mid + 1, hi));
        }
    }

    private static int traversalCheck(Node root, Integer target) {
        if (root != null) {
            target = traversalCheck(root.getLeft(), target);
            assert (target.equals(root.getData()));
            ++target;
            target = traversalCheck(root.getRight(), target);
        }
        return target;
    }

    public static void main(String[] args) {
        Random r = new Random();
        for (int times = 0; times < 1000; ++times) {
            int n;
            if (args.length == 1) {
                n = Integer.parseInt(args[0]);
            } else {
                n = r.nextInt(1000) + 1;
            }
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = i;
            }

            Node root = buildBST(arr);
            int target = 0;
            traversalCheck(root, target);
        }
    }
}
