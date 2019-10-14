/**
 * Binary Tree Inorder Traversal
 *
 * Given a binary tree, return the inorder traversal of its nodes' values
 *
 * e.g. IN: [15, 10, 22, 4, 12, 18, 24], OUT: [4, 10, 12, 15, 18, 22, 24]
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
 * Inorder strategy: Left -> Root -> Right
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class InorderBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.right = new TreeNode(22);
        root.right.left = new TreeNode(18);
        root.right.right = new TreeNode(24);
        System.out.println("Inorder: " + new InorderBST().inorderTraversal(root));
    }
}
