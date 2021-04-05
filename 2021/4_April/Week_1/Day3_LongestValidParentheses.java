
//Day 3: 
//Problem Statement: Longest Valid Parentheses

// Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 

// Example 1:

// Input: s = "(()"
// Output: 2
// Explanation: The longest valid parentheses substring is "()".
// Example 2:

// Input: s = ")()())"
// Output: 4
// Explanation: The longest valid parentheses substring is "()()".
// Example 3:

// Input: s = ""
// Output: 0
 

// Constraints:

// 0 <= s.length <= 3 * 104
// s[i] is '(', or ')'.


//Solution:
class Solution {
    public int longestValidParentheses(String s) {
        
                 
        int left=0, right=0, ans=0;
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)==')') right++;
            else left++;
            if(left==right) ans=Math.max(ans, right+left);
            else if(right>left) right=left=0;
        }
//         ())
        
        
        left=right=0;
        
        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i)==')') right++;
            else left++;
            if(left==right) ans=Math.max(ans, right+left);
            else if(left>right) right=left=0;
        }
//         (()
        return ans;
    }
}
//Complexity: O(n)
