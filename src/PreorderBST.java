/**
 * Binary Tree Preorder Traversal
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * e.g. IN: [15, 10, 22, 4, 12, 18, 24], OUT: [15, 10, 4, 12, 22, 18, 24]
 *
 *                  15
 *                 /  \
 *              10     22
 *             / \    /  \
 *           4   12  18  24
 *
 * Complexity: O(n) time and space
 *
 * Depth First Search(DFS) traversal pathways (Inorder, Preorder, and Postorder).
 *
 * Preorder strategy: Root -> Left -> Right
 */

import java.util.LinkedList;
import java.util.List;

public class PreorderBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();

        if (root == null) { return output; }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);

            if (node.right != null) { stack.add(node.right); }

            if (node.left != null) { stack.add(node.left); }
        }
        return output;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.right = new TreeNode(22);
        root.right.left = new TreeNode(18);
        root.right.right = new TreeNode(24);
        System.out.println("Preorder: " + new PreorderBST().preorderTraversal(root));
    }
}
