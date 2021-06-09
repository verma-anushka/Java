
//Day 8: 
//Problem Statement: Construct Binary Tree from Preorder and Inorder Traversal

// Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 

// Example 1:


// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// Output: [3,9,20,null,null,15,7]
// Example 2:

// Input: preorder = [-1], inorder = [-1]
// Output: [-1]
 

// Constraints:

// 1 <= preorder.length <= 3000
// inorder.length == preorder.length
// -3000 <= preorder[i], inorder[i] <= 3000
// preorder and inorder consist of unique values.
// Each value of inorder also appears in preorder.
// preorder is guaranteed to be the preorder traversal of the tree.
// inorder is guaranteed to be the inorder traversal of the tree.

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
     
        TreeNode root=new TreeNode(preorder[0]);
        
        HashMap<Integer, Integer> idx=new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            idx.put(inorder[i], i);
        }
        
        Stack<TreeNode> s=new Stack<>();
        s.push(root);
        
        for(int i=1; i<preorder.length; i++) {    
            
            TreeNode node=new TreeNode(preorder[i]);
            if(idx.get(preorder[i])<idx.get(s.peek().val)) {
                s.peek().left=node;
            } else {
                TreeNode curr=null;
                while(!s.empty() && idx.get(preorder[i])>idx.get(s.peek().val)) {
                    curr=s.peek(); 
                    s.pop();
                }
                curr.right=node;
            }
            
            s.push(node);
        }
        
        return root;
    }
}
//Complexity: O(n)

