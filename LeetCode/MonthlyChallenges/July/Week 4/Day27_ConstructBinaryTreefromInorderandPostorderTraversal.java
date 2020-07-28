
//Day 27: 
//Problem Link: https://leetcode.com/explore/featured/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3403/
//Problem Statement: Construct Binary Tree from Inorder and Postorder Traversal

//Given inorder and postorder traversal of a tree, construct the binary tree.

//Note:
//You may assume that duplicates do not exist in the tree.

//For example, given

//inorder = [9,3,15,20,7]
//postorder = [9,15,7,20,3]
//Return the following binary tree:

//    3
//   / \
//  9  20
//    /  \
//   15   7

//Solution:
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    unordered_map<int,int> mp;
    TreeNode* buildTreeUtil(vector<int>& post, int& idx, const int& si, const int& ei) {
        if (si>ei) return NULL;
        TreeNode* root = new TreeNode(post[idx]);
        int mid = mp[post[idx]];
        idx--;
        root->right = buildTreeUtil(post, idx, mid+1, ei);
        root->left = buildTreeUtil(post, idx, si, mid-1);
        return root;
    }

    TreeNode* buildTree(vector<int>& in, vector<int>& post) {
        for(int i=0; i<in.size(); i++) mp[in[i]]=i;
        int idx=post.size()-1;
        return buildTreeUtil(post, idx, 0, in.size()-1);
    }
};

//Complexity: O(n)
