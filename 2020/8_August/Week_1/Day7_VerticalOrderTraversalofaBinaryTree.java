
//Day 7: 
//Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3415/
//Problem Statement: Vertical Order Traversal of a Binary Tree

// Given a binary tree, return the vertical order traversal of its nodes values.

// For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

// Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

// If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

// Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.

 

// Example 1:



// Input: [3,9,20,null,null,15,7]
// Output: [[9],[3,15],[20],[7]]
// Explanation: 
// Without loss of generality, we can assume the root node is at position (0, 0):
// Then, the node with value 9 occurs at position (-1, -1);
// The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
// The node with value 20 occurs at position (1, -1);
// The node with value 7 occurs at position (2, -2).
// Example 2:



// Input: [1,2,3,4,5,6,7]
// Output: [[4],[2],[1,5,6],[3],[7]]
// Explanation: 
// The node with value 5 and the node with value 6 have the same position according to the given scheme.
// However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.
 

// Note:

// The tree will have between 1 and 1000 nodes.
// Each node's value will be between 0 and 1000.

//Solution:
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public void dfs(TreeNode node, int r, int c, Map<Integer, Map<Integer, ArrayList<Integer>> > mp) {
        if(node == null) return;
        if(!mp.containsKey(r)) 
            mp.put(r, new HashMap<>());
        if(!mp.get(r).containsKey(c)) 
            mp.get(r).put(c, new ArrayList<>());
        
        mp.get(r).get(c).add(node.val);
        
        dfs(node.left, r-1, c-1, mp);
        dfs(node.right, r+1, c-1, mp);
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        // List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Map<Integer, Map<Integer, ArrayList<Integer>> > mp = new HashMap<>();        
        dfs(root, 0, 0, mp);
        

        int idx=0;
        ArrayList<Integer> x=new ArrayList<>(mp.keySet());
        ArrayList<Integer> y;
        
        Collections.sort(x);

        for(int z:x) {
            ans.add(idx, new ArrayList<>());
            y = new ArrayList<>(mp.get(z).keySet());
            Collections.sort(y);
            
            ArrayList<Integer> temp;
            for(int y2: y) {
                temp = new ArrayList<>(mp.get(z).get(y2));
                Collections.sort(temp);
                ans.get(idx).addAll(0, temp);
            }
            idx++;
        }
        return ans;
    }
}
//Complexity: O(nlogn)

