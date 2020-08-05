
//Day 3: 
//Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3411/
//Problem Statement: Valid Palindrome

// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

// Note: For the purpose of this problem, we define empty string as valid palindrome.

// Example 1:

// Input: "A man, a plan, a canal: Panama"
// Output: true
// Example 2:

// Input: "race a car"
// Output: false
 

// Constraints:

// s consists only of printable ASCII characters.

//Solution:
class Solution {
    public boolean isPalindrome(String s) {
        
        int i=0, j=s.length()-1;
        
        while(i<=j) {
            if(Character.isLetterOrDigit(s.charAt(i)) == false) {
                i++; continue;
            }
            if(Character.isLetterOrDigit(s.charAt(j)) == false) {
                j--; continue;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++;j--;
        }
        return true;
    }
}
//Complexity: O(n)
