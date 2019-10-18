/**
 * Binary Tree Level Order Traversal
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * e.g. Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *  return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * Breadth First Search pathway aka level-order
 *
 * Complexity: O(N) time and space
 */

import java.util.ArrayList;
import java.util.List;

public class LevelOrderBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    List<List<Integer>> levels = new ArrayList<>();

    public void helper(TreeNode node, int level){
        if (levels.size() == level) {
            levels.add(new ArrayList<Integer>());
        }

        levels.get(level).add(node.val);

        if (node.left != null) { helper(node.left, level + 1); }

        if (node.right != null) { helper(node.right, level +1); }
    }

    public List<List<Integer>> levelOrderBST(TreeNode root) {
        if (root == null) { return levels; }

        helper(root, 0);
        return levels;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.print(new LevelOrderBST().levelOrderBST(root));
    }
}
