
//Day 8: 
//Problem Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3453/
//Problem Statement: Sum of Root To Leaf Binary Numbers

// You are given the root of a binary tree where each node has a value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

// For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

// Return the sum of these numbers. The answer is guaranteed to fit in a 32-bits integer.

 

// Example 1:

// Input: root = [1,0,1,0,1,0,1]
// Output: 22
// Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22

// Example 2:

// Input: root = [0]
// Output: 0

// Example 3:

// Input: root = [1]
// Output: 1

// Example 4:

// Input: root = [1,1]
// Output: 3

 

// Constraints:

//     The number of nodes in the tree is in the range [1, 1000].
//     Node.val is 0 or 1.



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
    int sum = 0;
    public int binaryToDecimal(String num) {

        int power = 0, decimal = 0;
        for(int i=num.length()-1; i>=0; i--) {
            int rem = num.charAt(i)-48;
            decimal += rem*Math.pow(2,power);
            power++;
        }
        return decimal;
    }
    
    public void sumRootToLeafUtil(TreeNode root, String num) {
        if(root.left == null && root.right == null) {
            num += Integer.toString(root.val); 
            int decimal = binaryToDecimal(num);
            sum+=decimal;
        }
        num += Integer.toString(root.val); 
        // num=num*10+root->val;
        if(root.left != null) {
            // num=num*10+root->val;
            sumRootToLeafUtil(root.left, num);
        }
        
        if(root.right != null) {
            // num=num*10+root->val;
            sumRootToLeafUtil(root.right, num);
        }
    }
    
    public int sumRootToLeaf(TreeNode root) {
        
        sumRootToLeafUtil(root, "");
        return sum;
        
    }
}
//Complexity: O(n)

