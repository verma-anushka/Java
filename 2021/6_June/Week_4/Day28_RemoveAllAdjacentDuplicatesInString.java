
//Day 28: 
//Problem Statement: Remove All Adjacent Duplicates In String

// You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

// We repeatedly make duplicate removals on s until we no longer can.

// Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

 

// Example 1:

// Input: s = "abbaca"
// Output: "ca"
// Explanation: 
// For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
// Example 2:

// Input: s = "azxxzy"
// Output: "ay"
 

// Constraints:

// 1 <= s.length <= 105
// s consists of lowercase English letters.

//Solution:
class Solution {
    public String removeDuplicates(String s) {
        
        Stack<Character> st=new Stack<Character>();

        for(int i=0; i<s.length(); i++) {
            char c=s.charAt(i);
            if(st.isEmpty()) 
                st.push(c);
            else if(st.peek()==c) 
                st.pop();
            else 
                st.push(c);

            // if(!st.isEmpty()) {
            //      if(st.peek()==c) {
            //         st.pop();        
            //         continue;
            //      }
            // } 
            // st.push(c);
        }

        StringBuilder ans=new StringBuilder();
        while(!st.isEmpty()) {
             ans.append(st.pop());
        }
        ans.reverse();
        return ans.toString();
    }
}
//Complexity: O(n)

