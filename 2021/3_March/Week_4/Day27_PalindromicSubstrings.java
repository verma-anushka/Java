
//Day 27: 
//Problem Statement: Palindromic Substrings

// Given a string, your task is to count how many palindromic substrings in this string.

// The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

// Example 1:

// Input: "abc"
// Output: 3
// Explanation: Three palindromic strings: "a", "b", "c".
 

// Example 2:

// Input: "aaa"
// Output: 6
// Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 

// Note:

// The input string length won't exceed 1000.

//Solution:
class Solution {
    public int countSubstrings(String s) {
         
        int ans=0;
        
        for(int i=0; i<s.length(); i++) {
            
            int j=i-1, k=i;
            while(k<s.length()-1 && s.charAt(k)==s.charAt(k+1)) 
                k++;
            
            ans+=(k-j)*(k-j+1)/2; 
            i=k++;
        
            while(j>=0 && k<s.length() && s.charAt(k++)==s.charAt(j--)) 
                ans++;    
        
        }
        
        return ans;
    }
}
//Complexity: O(n*n)

