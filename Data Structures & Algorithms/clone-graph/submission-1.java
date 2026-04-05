/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>();
        createNewNodes(node, map, new HashSet<>());

        addEdges(node, map, new HashSet<>());

        return map.get(node);
    }

    private void createNewNodes(Node node, HashMap<Node, Node> map, HashSet<Node> visited) {
        if(node == null) return;
        visited.add(node);
        Node newNode = new Node(node.val); //1`
        map.put(node, newNode); // 1 -> 1`

        for(Node neigh : node.neighbors) {
            if(!visited.contains(neigh)) createNewNodes(neigh, map, visited);
        }
    }

        private void addEdges(Node node, HashMap<Node, Node> map, HashSet<Node> visited) {
        if(node == null) return;

        visited.add(node);  // 1
        Node newNode = map.get(node); // 1`

        for(Node neigh : node.neighbors) {
            newNode.neighbors.add(map.get(neigh));
            if(!visited.contains(neigh)) addEdges(neigh, map, visited);
        }
    }
}
/*

- create the mapping of old to newNodes : 
1->1`
2->2`
3->3`

- dfs starts from 1
- get corresponding newNode i.e 1`
- get the all the neighbour nodes [2,3]
- for each neighbour node, add it to the adj list of 1'
- move to the neighbours

*/