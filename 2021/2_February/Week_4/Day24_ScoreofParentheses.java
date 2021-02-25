//Day 24: 
//Problem Statement: Score of Parentheses

// Given a balanced parentheses string S, compute the score of the string based on the following rule:

// () has score 1
// AB has score A + B, where A and B are balanced parentheses strings.
// (A) has score 2 * A, where A is a balanced parentheses string.
 

// Example 1:

// Input: "()"
// Output: 1
// Example 2:

// Input: "(())"
// Output: 2
// Example 3:

// Input: "()()"
// Output: 2
// Example 4:

// Input: "(()(()))"
// Output: 6
 

// Note:

// S is a balanced parentheses string, containing only ( and ).
// 2 <= S.length <= 50

//Solution:
class Solution {
    public int scoreOfParentheses(String s) {
        
        int ans=0;
        Stack<Integer> st=new Stack<>();
    
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(') {
                st.push(ans);
                ans=0;
            } else {
                int top=st.peek(); st.pop();
                ans+=top+Math.max(ans, 1);
            }
        }
        
        return ans;
    }
}
//Complexity: O(n)

