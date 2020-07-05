
//Day 2: 
//Problem Link: https://leetcode.com/explore/featured/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3378/
//Problem Statement: Binary Tree Level Order Traversal II

// Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its bottom-up level order traversal as:
// [
//   [15,7],
//   [9,20],
//   [3]
// ]

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Queue<TreeNode> pending = new LinkedList<TreeNode>();
        
        if(root==null) return ans;
        
        pending.add(root);
        
        while(pending.size()>0) {
        
            int qsize = pending.size();
            List<Integer> temp = new ArrayList<Integer>();
            while(qsize>0) {
                TreeNode curr = pending.poll();
                temp.add(curr.val);
                if(curr.left != null) pending.add(curr.left);
                if(curr.right != null) pending.add(curr.right);
                qsize--;
            }
            ans.add(0, temp);
        }
        return ans;
    }
}

//Complexity: O(n)

