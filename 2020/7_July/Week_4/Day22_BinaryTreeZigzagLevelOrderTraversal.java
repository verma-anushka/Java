
//Day 22: 
//Problem Link: https://leetcode.com/explore/featured/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3398/
//Problem Statement: Binary Tree Zigzag Level Order Traversal

// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its zigzag level order traversal as:
// [
//   [3],
//   [20,9],
//   [15,7]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(root==null) return ans;
        
        Deque<TreeNode> q = new ArrayDeque<TreeNode>();
        q.add(root);
        
        boolean dir=true;
        while(q.size()>0) {
        
            int n=q.size();
            List<Integer> temp= new LinkedList<>();

            while(n-->0) {
                
                TreeNode el=null;
                if(dir) {
                    el = q.pollFirst();
                    temp.add(el.val);
                    if(el.left != null) q.add(el.left);
                    if(el.right != null) q.add(el.right);
                } else {
                    el = q.pollLast(); 
                    temp.add(el.val);
                    if(el.right != null) q.addFirst(el.right);
                    if(el.left != null) q.addFirst(el.left);
                }
            }
            
            dir = !dir;
            ans.add(temp);
        }
        
        return ans;
    }
}
//Complexity: O(n)
