
//Day 3: 
//Problem Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3447/
//Problem Statement: Repeated Substring Pattern

// Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

 

// Example 1:

// Input: "abab"
// Output: True
// Explanation: It's the substring "ab" twice.

// Example 2:

// Input: "aba"
// Output: False

// Example 3:

// Input: "abcabcabcabc"
// Output: True
// Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)



//Solution:
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String temp = s+s;
        temp = temp.substring(1);
        temp = temp.substring(0, temp.length()-1);
        return temp.contains(s);
    }
}
//Complexity: O(n)
