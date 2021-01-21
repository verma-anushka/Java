
//Day 20: 
//Problem Statement: Valid Parentheses

// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
 

// Example 1:

// Input: s = "()"
// Output: true
// Example 2:

// Input: s = "()[]{}"
// Output: true
// Example 3:

// Input: s = "(]"
// Output: false
// Example 4:

// Input: s = "([)]"
// Output: false
// Example 5:

// Input: s = "{[]}"
// Output: true
 

// Constraints:

// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.

//Solution:
class Solution {
    public boolean isValid(String s) {
                
        Stack<Character> st=new Stack<>();
        for(int i=0; i<s.length(); i++) {
            Character c=s.charAt(i);
            if(c == '(' || c == '{' || c == '[') st.add(c);
            else {
                char top=' ';
                if(!st.empty()) {
                    top=st.pop();
                }
                
                if( (c==')' && top =='(') || (c=='}' && top =='{') || (c==']' && top =='['))
                    continue;
                else
                    return false;
            }    
        }
        return st.empty();
    }
}
//Complexity: O(n)

