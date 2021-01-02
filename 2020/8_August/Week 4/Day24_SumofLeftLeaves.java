//Day 24: 
//Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3435/
//Problem Statement: Sum of Left Leaves

// Find the sum of all left leaves in a given binary tree.

// Example:

//     3
//    / \
//   9  20
//     /  \
//    15   7

// There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

//Solution:
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {

    int sum = 0;

    void sumOfLeftLeavesUtil(TreeNode root, boolean isLeft) {
        if (isLeft && root.left == null && root.right == null) {
            sum += root.val;
            return;
        }

        if (root.left != null) {
            sumOfLeftLeavesUtil(root.left, true);
        }
        if (root.right != null) {
            sumOfLeftLeavesUtil(root.right, false);
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null)
            return 0;
        sumOfLeftLeavesUtil(root, false);
        return sum;
    }
}
// Complexity: O(n)
