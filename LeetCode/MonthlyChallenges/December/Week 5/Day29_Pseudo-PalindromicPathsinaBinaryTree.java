//Day 29:
//Problem Statement: Pseudo-Palindromic Paths in a Binary Tree

// Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.

// Return the number of pseudo-palindromic paths going from the root node to leaf nodes.

 

// Example 1:



// Input: root = [2,3,1,3,1,null,1]
// Output: 2 
// Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the red path [2,3,3], the green path [2,1,1], and the path [2,3,1]. Among these paths only red path and green path are pseudo-palindromic paths since the red path [2,3,3] can be rearranged in [3,2,3] (palindrome) and the green path [2,1,1] can be rearranged in [1,2,1] (palindrome).
// Example 2:



// Input: root = [2,1,1,1,3,null,null,null,null,null,1]
// Output: 1 
// Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the green path [2,1,1], the path [2,1,3,1], and the path [2,1]. Among these paths only the green path is pseudo-palindromic since [2,1,1] can be rearranged in [1,2,1] (palindrome).
// Example 3:

// Input: root = [9]
// Output: 1
 

// Constraints:

// The given binary tree will have between 1 and 10^5 nodes.
// Node values are digits from 1 to 9.

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
    public int isPal(int []freq, int l) {
        int odd=0;
        for(int i=0; i<10; i++) {
            if(freq[i]%2==1) {
                if(odd!=0 || l%2==0)
                    return 0;
                odd+=1;
            }
        }
        return 1;
    }
    
    public int pseudoPalindromicUtil(TreeNode root, int []freq, int l) {   
        
        if(root==null) return 0;
        int ans=0;
        freq[root.val]+=1;
        
        if(root.left==null && root.right==null) {
            ans=isPal(freq, l);
        } else {
            ans+=pseudoPalindromicUtil(root.left, freq, l+1);
            ans+=pseudoPalindromicUtil(root.right, freq, l+1);
        }
        
        freq[root.val]-=1;
        return ans;
    }
    
    public int pseudoPalindromicPaths(TreeNode root) {
        int []freq=new int[10];    
        return pseudoPalindromicUtil(root, freq, 1);
    }
}
//Complexity: O(n)
