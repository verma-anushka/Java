
//Day 19: 
//Problem Statement: Longest Palindromic Substring

// Given a string s, return the longest palindromic substring in s.

 

// Example 1:

// Input: s = "babad"
// Output: "bab"
// Note: "aba" is also a valid answer.
// Example 2:

// Input: s = "cbbd"
// Output: "bb"
// Example 3:

// Input: s = "a"
// Output: "a"
// Example 4:

// Input: s = "ac"
// Output: "a"
 

// Constraints:

// 1 <= s.length <= 1000
// s consist of only digits and English letters (lower-case and/or upper-case),

//Solution:
public String longestPalindrome(String s) {
        
    String longest="";

    for(int i=0; i<s.length(); i++) {

        for(int j=s.length()-1; j>i; j--) {   
        
            String temp=s.substring(i, j+1);
            // System.out.println(i + " " + j+1);
            
            if(temp.length()>longest.length() && isPalindrome(temp)) {
                longest=temp;
                break;
            }
            
        }
    }
    
   
    return longest.length()>0 ? longest: s.charAt(0)+""; 

}

public boolean isPalindrome(String s){
    
    int i=0, j=s.length()-1;
    
    while(i<j) {

        if(s.charAt(i) != s.charAt(j))
            return false;
    
        i++; j--;
    
    }
    
    return true;

}
//Complexity: O(n*n)

