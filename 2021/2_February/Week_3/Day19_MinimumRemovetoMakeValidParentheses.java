
//Day 19: 
//Problem Statement: Minimum Remove to Make Valid Parentheses

// Given a string s of '(' , ')' and lowercase English characters. 

// Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

// Formally, a parentheses string is valid if and only if:

// It is the empty string, contains only lowercase characters, or
// It can be written as AB (A concatenated with B), where A and B are valid strings, or
// It can be written as (A), where A is a valid string.
 

// Example 1:

// Input: s = "lee(t(c)o)de)"
// Output: "lee(t(c)o)de"
// Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
// Example 2:

// Input: s = "a)b(c)d"
// Output: "ab(c)d"
// Example 3:

// Input: s = "))(("
// Output: ""
// Explanation: An empty string is also valid.
// Example 4:

// Input: s = "(a(b(c)d)"
// Output: "a(b(c)d)"
 

// Constraints:

// 1 <= s.length <= 10^5
// s[i] is one of  '(' , ')' and lowercase English letters.

//Solution:
class Solution {
    public String minRemoveToMakeValid(String s) {
        
        if(s.length()==1 && !s.equals("(") && !s.equals(")")) 
            return s;
        
        Stack<Integer> open=new Stack<>();
        StringBuilder ans=new StringBuilder();
        
        int count=0;
        
        for(int i=0; i<s.length(); i++) {
            
            if(s.charAt(i) == '(')
                open.push(i-open.size());
            else if(s.charAt(i) == ')') {
                if(!open.isEmpty()) {
                    ans.insert(open.pop()-count, '(');
                    ans.append(s.charAt(i));
                } else
                    count++; 
            } else
                ans.append(s.charAt(i));
        }
        
        return ans.toString();
    }
}
//Complexity: O(n)

