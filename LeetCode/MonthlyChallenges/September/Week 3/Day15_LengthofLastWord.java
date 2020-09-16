
//Day 15: 
//Problem Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3461/
//Problem Statement: Length of Last Word

// Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.

// If the last word does not exist, return 0.

// Note: A word is defined as a maximal substring consisting of non-space characters only.

// Example:

// Input: "Hello World"
// Output: 5


// Solution:
class Solution {
    public int lengthOfLastWord(String s) {
        
        if(s.length()==0) return 0;
        int i=s.length()-1, len=0;
        while(i>=0 && s.charAt(i)==' ') {
            i--;
        }
        
        while(i>=0 && s.charAt(i)!=' ') {
            len++; i--;
        }
        return len;
    }
}
//Complexity: O(n)

