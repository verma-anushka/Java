
//Day 31: 
//Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/553/week-5-august-29th-august-31st/3443/
//Problem Statement: Delete Node in a BST

// Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

// Basically, the deletion can be divided into two stages:

// Search for a node to remove.
// If the node is found, delete the node.
// Note: Time complexity should be O(height of tree).

// Example:

// root = [5,3,6,2,4,null,7]
// key = 3

//     5
//    / \
//   3   6
//  / \   \
// 2   4   7

// Given key to delete is 3. So we find the node with value 3 and delete it.

// One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

//     5
//    / \
//   4   6
//  /     \
// 2       7

// Another valid answer is [5,2,6,null,4,null,7].

//     5
//    / \
//   2   6
//    \   \
//     4   7

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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if (root == null) return null;

		if (root.val < key) {
			root.right=deleteNode(root.right, key);
			return root;
		} else if (root.val > key) {
			root.left=deleteNode(root.left, key);
			return root;
		} else {
			if (root.left == null && root.right == null) {
				// delete root;
				return null;
			} else if (root.left == null) {
				TreeNode temp=root.right;
				root.right=null;
				// delete root;
				return temp;
			} else if (root.right == null) {
				TreeNode temp=root.left;
				root.left=null;
				// delete root;
				return temp; 
			} else {
				TreeNode minNode=root.right;
				while (minNode.left != null) {
					minNode=minNode.left;
				}
				int minVal=minNode.val;
				root.val=minVal;
				root.right=deleteNode(root.right, minVal);
				return root;
			}
		}
    }
}
//Complexity: O(n)
