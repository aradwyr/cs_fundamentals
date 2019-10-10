/**
 * Search in a Binary Search Tree (BST)
 *
 * Given the root node of a BST and a value. You need to find the node in the BST that the node's value equals the
 * given value. Return the subtree rooted with that node. If such node doesn't exist, return NULL.
 *
 * Note: An empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [], not null.
 *
 * e.g. IN: [4,2,7,1,3] and 2, OUT: [2,1,3]
 * Given the tree:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * Return the subtree:
 *       2
 *      / \
 *     1   3
 */


public class SearchBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x; }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && val != root.val) {
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }
}
