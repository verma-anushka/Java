
//Day 5: 
//Problem Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3449/
//Problem Statement: All Elements in Two Binary Search Trees

// Given two binary search trees root1 and root2.

// Return a list containing all the integers from both trees sorted in ascending order.

 

// Example 1:

// Input: root1 = [2,1,4], root2 = [1,0,3]
// Output: [0,1,1,2,3,4]

// Example 2:

// Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
// Output: [-10,0,0,1,2,5,7,10]

// Example 3:

// Input: root1 = [], root2 = [5,1,7,0,2]
// Output: [0,1,2,5,7]

// Example 4:

// Input: root1 = [0,-10,10], root2 = []
// Output: [-10,0,10]

// Example 5:

// Input: root1 = [1,null,8], root2 = [8,1]
// Output: [1,1,8,8]

 

// Constraints:

//     Each tree has at most 5000 nodes.
//     Each node's value is between [-10^5, 10^5].



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
    
    List<Integer> ans=new ArrayList<>();
    public void inorder(TreeNode root) {
        if(root==null) return;
        
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);

    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        inorder(root1);
        inorder(root2);
        Collections.sort(ans);
        return ans;
    }
}
//Complexity: O(n)

