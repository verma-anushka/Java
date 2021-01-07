
//Day 7: 
//Problem Statement: Longest Substring Without Repeating Characters

// Given a string s, find the length of the longest substring without repeating characters.

 

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
// Example 4:

// Input: s = ""
// Output: 0
 

// Constraints:

// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.


//Solution:
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int si=0, ei=0;
        int maxl=0;
        
        Set<Character> unique=new HashSet<>();
        while(si<s.length() && ei<s.length()) {
            if(!unique.contains(s.charAt(ei))) {
                unique.add(s.charAt(ei++));
                maxl=Math.max(maxl, ei-si);
            } else {
                unique.remove(s.charAt(si++));
            }
        }
        maxl=Math.max(maxl, ei-si);

        return maxl;

    }
}
//Complexity: O(n)

