/**
 * Closest Binary Search Tree(BST) Value
 *
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 *
 * Note: Given target value is a floating point. You are guaranteed to have only one unique value in the BST that is closest to the target.
 *
 * e.g. IN: root = [4,2,5,1,3], target = 3.714286, OUT: 4
 *         4
 *        / \
 *       2   5
 *      / \
 *     1   3
 *
 * Complexity: O(H) time where H is tree height, O(1) space
 */

public class ClosestValBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x; }
    }

    public int closestValue(TreeNode root, double target) {
        int val, closest = root.val;

        while (root != null) {
            val = root.val;
            closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
            root = target < root.val ? root.left : root.right;
        }
        return closest;
    }
}
