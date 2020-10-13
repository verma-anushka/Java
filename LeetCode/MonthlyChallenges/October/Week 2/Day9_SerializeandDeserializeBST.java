
//Day 9: 
//Problem Statement: Serialize and Deserialize BST

// Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

// Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.

// The encoded string should be as compact as possible.

 

// Example 1:

// Input: root = [2,1,3]
// Output: [2,1,3]
// Example 2:

// Input: root = []
// Output: []
 

// Constraints:

// The number of nodes in the tree is in the range [0, 104].
// 0 <= Node.val <= 104
// The input tree is guaranteed to be a binary search tree.

//Solution:
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    public String encode(TreeNode root) {
    
        if (root==null) return "";

        return Integer.toString(root.val) + "-" + encode(root.left) + encode(root.right);
    
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
         return encode(root);
    }
    
    public TreeNode insert(TreeNode root, int val) {
        
        if (root==null) return new TreeNode(val);
		
        if (val<=root.val) root.left = insert(root.left, val);
		else root.right = insert(root.right, val);
		
        return root;
    }
    
        
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data.length()==0) return null;
        
        TreeNode root=null;
        String arr[]=data.split("-");
        
        for(int i=0; i<arr.length; i++)
            root=insert(root, Integer.parseInt(arr[i]));

        return root;

    }
    
}
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;

//Complexity: O(n)

