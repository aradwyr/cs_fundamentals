/**
 * Recover Binary Search Tree
 *
 * Two elements of a binary search tree (BST) are swapped by mistake. Recover the tree without changing its structure.
 *
 * e.g.
 * IN: [1,3,null,null,2]        OUT: [3,1,null,null,2]
 *          1                           3
 *        /                            /
 *      3                             1
 *       \                             \
 *        2                             2
 *
 * IN: [3,1,4,null,null,2]      OUT: [2,1,4,null,null,3]
 *            3                            2
 *           / \                          / \
 *          1   4                        1   4
 *             /                            /
 *            2                            3
 *
 * Complexity: O(n) time (worst case aka rightmost leaf node needs to be swapped) & O(h) space for the stack where h is tree height
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class RecoverBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
    }

    public void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    public void recoverBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode x = null, y = null, pred = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            root = stack.removeLast();

            if (pred != null && root.val < pred.val) {
                y = root;
                if (x == null) { x = pred; }
                else break;
            }

            pred = root;
            root = root.right;
        }
        swap(x, y);
    }
}
