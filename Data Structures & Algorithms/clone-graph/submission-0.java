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
        if(node==null) return null;
        Map<Node, Node> map = new HashMap<>();
        Set<Node> set = new HashSet<>();
        Node head = new Node(node.val);
        dfs(head, node, map, set);
        return head;
    }
    public void dfs(Node head, Node node, Map<Node, Node> map, Set<Node> set){
        if(set.contains(head)) return;
        set.add(head);
        for(Node neighbor : node.neighbors){
            map.putIfAbsent(neighbor, new Node(neighbor.val));
            head.neighbors.add(map.get(neighbor));
            dfs(map.get(neighbor), neighbor, map, set);
        }
    }
}