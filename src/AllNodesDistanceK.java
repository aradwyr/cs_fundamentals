/**
 * All Nodes Distance K in Binary Tree
 *
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 *
 * Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
 *
 * e.g. IN: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2, OUT: [7,4,1]
 *
 *              3
 *            /   \
 *          5      1
 *        / \     / \
 *      6   2    0   8
 *         / \
 *        7  4
 *
 * Complexity: O(n) time and space
 *
 * Note: The inputs, root and target, are actually TreeNodes; descriptions of the inputs above are just serializations of these objects.
 */

import java.util.LinkedList;
import java.util.List;


public class AllNodesDistanceK {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    TreeNode target;
    int K;
    List<Integer> res;

    public List<Integer> distanceFromK(TreeNode root, TreeNode target, int K) {
        res = new LinkedList<>();
        this.target = target;
        this.K = K;
        dfs(root);
        return res;
    }

    public void addSubtree(TreeNode node, int dist) {
        if (node == null) { return; }

        if (dist == K) { res.add(node.val); }

        else {
            addSubtree(node.left, dist + 1);
            addSubtree(node.right, dist + 1);
        }
    }

    public int dfs(TreeNode node) {
        if (node == null) { return -1; }

        else if (node == target) {
            addSubtree(node, 0);
            return 1;

        } else {
            int L = dfs(node.left), R = dfs(node.right);

            if (L != -1) {
                if (L == K) { res.add(node.val); }
                addSubtree(node.right, L + 1);
                return L + 1;

            } else if (R != -1) {
                if (R == K) { res.add(node.val); }
                addSubtree(node.left, R + 1);
                return R + 1;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        System.out.println(new AllNodesDistanceK().distanceFromK(root, root.left, 2));
    }
}
