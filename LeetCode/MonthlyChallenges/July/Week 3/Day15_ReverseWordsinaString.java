
//Day 15: 
//Problem Link: https://leetcode.com/explore/featured/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3391/
//Problem Statement: Reverse Words in a String

// Given an input string, reverse the string word by word.

 

// Example 1:

// Input: "the sky is blue"
// Output: "blue is sky the"
// Example 2:

// Input: "  hello world!  "
// Output: "world! hello"
// Explanation: Your reversed string should not contain leading or trailing spaces.
// Example 3:

// Input: "a good   example"
// Output: "example good a"
// Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

// Note:

// A word is defined as a sequence of non-space characters.
// Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
// You need to reduce multiple spaces between two words to a single space in the reversed string.
 

// Follow up:

// For C programmers, try to solve it in-place in O(1) extra space.

// Solution:
class Solution {
    public String reverseWords(String s) {
        
        String ans="";
        int i=0, n=s.length();
        
        while(i<n) {
            while(i<n && s.charAt(i) == ' ') i++;
            if(i>=n) break;
            int j=i+1;
            while(j<n && s.charAt(j) != ' ') j++;
            if(ans.length()==0) ans=s.substring(i, j);
            else ans=s.substring(i, j) + " " + ans;
            i=j+1;
        }
        return ans;

    }
}
//Complexity: O(n)

