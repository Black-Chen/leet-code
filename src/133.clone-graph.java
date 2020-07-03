import java.util.ArrayList;
import java.util.List;

import org.graalvm.compiler.graph.Node;

/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */

// @lc code=start
/*
// Definition for a Node.
*/
// class Node {
//     public int val;
//     public List<Node> neighbors;
    
//     public Node() {
//         val = 0;
//         neighbors = new ArrayList<Node>();
//     }
    
//     public Node(int _val) {
//         val = _val;
//         neighbors = new ArrayList<Node>();
//     }
    
//     public Node(int _val, ArrayList<Node> _neighbors) {
//         val = _val;
//         neighbors = _neighbors;
//     }
// }

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        ArrayList<Integer>[] neighborIndex = new ArrayList[100];
        Node[] nodes = new Node[100];
        iterateNode(node, neighborIndex, nodes);
        for (int i = 0; i < nodes.length; i++) {
            if (neighborIndex[i] != null && neighborIndex[i].size() > 0) {
                for (Integer index : neighborIndex[i]) {
                    nodes[i].neighbors.add(nodes[index - 1]);
                }
                
            }
        }
        return nodes[0];
    }

    private void iterateNode(Node node, ArrayList<Integer>[] neighborIndex, Node[] nodes) {
        if (nodes[node.val - 1] == null) {
            nodes[node.val - 1] = new Node(node.val);
        } else {
            return;
        }
        if (node.neighbors != null && !node.neighbors.isEmpty()) {
            for (Node neighbor : node.neighbors) {
                if (neighborIndex[node.val - 1] == null) {
                    neighborIndex[node.val - 1] = new ArrayList<>(node.neighbors.size());
                }
                neighborIndex[node.val - 1].add(neighbor.val);
                iterateNode(neighbor, neighborIndex, nodes);
            }
        }
    }
}
// @lc code=end

