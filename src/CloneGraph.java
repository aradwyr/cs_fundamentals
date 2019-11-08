/**
 * Clone Graph
 *
 * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph.
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 *
 * IN: {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},
 * {"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
 *
 * Node 1's value is 1, and it has two neighbors: Node 2 and 4.
 * Node 2's value is 2, and it has two neighbors: Node 1 and 3.
 * Node 3's value is 3, and it has two neighbors: Node 2 and 4.
 * Node 4's value is 4, and it has two neighbors: Node 1 and 3.
 *
 *                  1 ----- 2
 *                  |       |
 *                  |       |
 *                  4 ----- 3
 *
 * Complexity:
 * O(n) time (traverse each node once)
 * O(n) space (from the visited hash map and the recursive call stack is equal to O(h) where h is height of the graph)
 *
 * Strategy: depth-first search
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    public static class Node {
        public int val;

        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };

    private HashMap <Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null)   return null;

        if (visited.containsKey(node)) { return visited.get(node); }            // if already traversed current node, return the cloned node

        Node clone = new Node(node.val, new ArrayList<>());                     // create clone for current node

        visited.put(node, clone);                           // key is orig node and the value is the clone node

        for (Node neighbor : node.neighbors) {                  // iterate through neighbors to generate clones
            clone.neighbors.add(cloneGraph(neighbor));
        }
        return clone;
    }
}
