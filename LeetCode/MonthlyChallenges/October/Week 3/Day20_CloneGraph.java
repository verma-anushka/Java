
//Day 20: 
//Problem Statement: Clone Graph

//Solution:
/*
// Definition for a Node.
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
    Map<Integer, Node> mp=new HashMap<>();
  
    public Node cloneGraph(Node node) {
  
        if(node==null) return null;
        return helper(node);
    }
    
    public Node helper(Node node) {   
        if(mp.containsKey(node.val))
            return mp.get(node.val);
        
        Node new_node=new Node(node.val);
        mp.put(node.val, new_node);
        for (Node neighbor: node.neighbors) 
            new_node.neighbors.add(helper(neighbor));
        
        return new_node;
    
    } 
}
//Complexity: O(n)

