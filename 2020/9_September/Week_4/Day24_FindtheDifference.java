
//Day 24: 
//Problem Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3471/
//Problem Statement: Find the Difference

// You are given two strings s and t.

// String t is generated by random shuffling string s and then add one more letter at a random position.

// Return the letter that was added to t.

 

// Example 1:

// Input: s = "abcd", t = "abcde"
// Output: "e"
// Explanation: 'e' is the letter that was added.

// Example 2:

// Input: s = "", t = "y"
// Output: "y"

// Example 3:

// Input: s = "a", t = "aa"
// Output: "a"

// Example 4:

// Input: s = "ae", t = "aea"
// Output: "a"

 

// Constraints:

//     0 <= s.length <= 1000
//     t.length == s.length + 1
//     s and t consist of lower-case English letters.



//Solution:
class Solution {
    public char findTheDifference(String s, String t) {
         
        int []tmp = new int[26];
        
        for(int i=0; i<t.length(); i++) tmp[t.charAt(i)-'a']++;
        for(int i=0; i<s.length(); i++) tmp[s.charAt(i)-'a']--;
        
        for(int i=0; i<26; i++) if(tmp[i] > 0) return (char)(i+'a');
        return 'a';
    }
}
//Complexity: O(n)

