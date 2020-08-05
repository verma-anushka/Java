
//Day 1:
//Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3409/
//Problem Statement: Detect Capital

// Given a word, you need to judge whether the usage of capitals in it is right or not.

// We define the usage of capitals in a word to be right when one of the following cases holds:

// All letters in this word are capitals, like "USA".
// All letters in this word are not capitals, like "leetcode".
// Only the first letter in this word is capital, like "Google".
// Otherwise, we define that this word doesn't use capitals in a right way.
 

// Example 1:

// Input: "USA"
// Output: True
 

// Example 2:

// Input: "FlaG"
// Output: False
 

// Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.


//Solution:
class Solution {
    public boolean detectCapitalUse(String word) {
        int uCount = 0, lCount = 0; 
        for (int i=0; i<word.length(); i++){
            if (Character.isUpperCase(word.charAt(i)))
                uCount++;
            else
                lCount++;
        }
        
        if (lCount == word.length() || uCount == word.length())
            return true;
        else if (uCount == 1 && Character.isUpperCase(word.charAt(0)) )
            return true;
        else
            return false;
        
    }
}
//Complexity: O(n)

