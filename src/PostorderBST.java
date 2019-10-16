/**
 * Binary Tree Postorder Traversal
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * e.g. IN: [15, 10, 22, 4, 12, 18, 24], OUT: [4, 12, 10, 18, 24, 22, 15]
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
 * Postorder strategy: Left -> Right -> Root && bottom -> top
 */

import java.util.LinkedList;
import java.util.List;

public class PostorderBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) { val = x; }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();

        if (root == null) { return output; }

        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.addFirst(node.val);                   // constant insert to front

            if (node.left != null) { stack.add(node.left); }

            if (node.right != null) { stack.add(node.right); }
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
        System.out.println("Postorder: " + new PostorderBST().postorderTraversal(root));
    }

}


/**
                           15
                          /  \
                       10     22
                      / \    /  \
                    4   12  18  24

 iteration | node = stack.pollLast |     output                  |   stack
        1  |          15           | [15]                        |  [10, 22]
        2  |          22           | [22, 15]                    |  [10, 18, 24]
        3  |          24           | [24, 22, 15]                |  [10, 18]
        4  |          18           | [18, 24, 22, 15]            |  [10]
        5  |          10           | [10, 18, 24, 22, 15]        |  [4, 12]
        6  |          12           | [12, 10, 18, 24, 22, 15]    |  [4]
        7  |          4            | [4, 12, 10, 18, 24, 22, 15] |  []
 */