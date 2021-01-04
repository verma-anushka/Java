
//Day 14: 
//Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3423/
//Problem Statement: Longest Palindrome

// Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

// This is case sensitive, for example "Aa" is not considered a palindrome here.

// Note:
// Assume the length of given string will not exceed 1,010.

// Example:

// Input:
// "abccccdd"

// Output:
// 7

// Explanation:
// One longest palindrome that can be built is "dccaccd", whose length is 7.

//Solution:
class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0)+1);
        }
        
        // for(char c:s.toCharArray()) {
        //     mp.put(c, mp.getOrDefault(c, 0)+1);
        // }
        
        int len=0, odd=0;
        for(int p:mp.values()) {
            if(p%2 == 0) {
                len += p;
            } else {
                odd=1;
                len += p-1;
            }
        }
        if(odd !=0 ) len++;
        return len;
    }
}
//Complexity: O(1)

