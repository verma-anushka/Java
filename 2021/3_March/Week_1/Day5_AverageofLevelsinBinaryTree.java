
//Day 5: 
//Problem Statement: Average of Levels in Binary Tree

// Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
// Example 1:
// Input:
//     3
//    / \
//   9  20
//     /  \
//    15   7
// Output: [3, 14.5, 11]
// Explanation:
// The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
// Note:
// The range of node's value is in the range of 32-bit signed integer.

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
    public List<Double> averageOfLevels(TreeNode root) {
         
        if(root==null) return new ArrayList<>() {};
        List<Double> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        
        while(q.size()>0) {  
            
            double sum=0;
            int n=q.size();
            
            for(int i=0; i<n; i++) {

                TreeNode front=q.peek(); q.poll();
                sum+=front.val;
                if(front.left!=null) q.add(front.left);
                if(front.right!=null) q.add(front.right);
            }
            ans.add(sum/n);
        }
        
        return ans;
    }
}

//Complexity: O(n)

