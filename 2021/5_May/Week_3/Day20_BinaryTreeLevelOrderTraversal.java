
//Day 20: 
//Problem Statement: Binary Tree Level Order Traversal

// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]
// Example 2:

// Input: root = [1]
// Output: [[1]]
// Example 3:

// Input: root = []
// Output: []
 

// Constraints:

// The number of nodes in the tree is in the range [0, 2000].
// -1000 <= Node.val <= 1000

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        
        Queue<TreeNode> pending=new ArrayDeque<TreeNode>();
        pending.add(root);
        
        while(pending.size()>0) {
            int n=pending.size();
            List<Integer> v=new ArrayList<>();
            
            while(n-->0) {
                TreeNode curr=pending.poll();
                v.add(curr.val);
                if(curr.left!=null) pending.add(curr.left);
                if(curr.right!=null) pending.add(curr.right);    
            }
            ans.add(v);
        }
        return ans;
    
    }
}

//Complexity: O(n*n)

