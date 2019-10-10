/**
 * Insert into a Binary Search Tree (BST)
 *
 * Given the root node of a BST and a value to be inserted into the tree, insert the value into the BST. Return the
 * root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
 *
 * Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion.
 * You can return any of them.
 *
 * e.g. IN: [4,2,7,1,3] and 5, OUT: 4 or 5
 * Given the tree:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 * And the value to insert: 5
 *
 * Valid results:
 *          4                               5
 *        /   \                            / \
 *       2     7                          2   7
 *      / \   /                          / \
 *     1   3 5                          1   3
 *                                           \
 *                                            4
 */

public class InsertBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x; }
    }

    // Recursive Solution
    // Complexity: O(log n) avg time and space, O(n) worst time and space
    public TreeNode recursiveInsertBST(TreeNode root, int val) {
        if (root == null) { return new TreeNode(val); }

        if (val > root.val) { root.right = recursiveInsertBST(root.right, val); }

        else { root.left = recursiveInsertBST(root.left, val); }

        return root;
    }

    // Iterative Solution
    // Complexity: O(log n) avg time, O(n) worst time, O(1) space
    public TreeNode insertInBST(TreeNode root, int val) {
        TreeNode node = root;

        while (node != null) {
            if (val > node.val) {       // go into right subtree
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    return root;
                } else { node = node.right; }
            } else {                        // go into left subtree
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    return root;
                } else { node = node.left; }
            }
        }
        return new TreeNode(val);          // covers inserting into empty BST
    }
}
