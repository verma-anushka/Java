
//Day 26: 
//Problem Statement: Longest Substring with At Least K Repeating Characters

// Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.

 

// Example 1:

// Input: s = "aaabb", k = 3
// Output: 3
// Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
// Example 2:

// Input: s = "ababbc", k = 2
// Output: 5
// Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 

// Constraints:

// 1 <= s.length <= 104
// s consists of only lowercase English letters.
// 1 <= k <= 105

//Solution: 
class Solution {
    public int longestSubstring(String s, int k) {
               
        int maxlen=0, len=0;
        int []freq = new int[26];
        for(int i=0; i<s.length(); i++) 
            freq[s.charAt(i)-'a']++;
      
        for(int i=0; i<s.length(); i++){
            if(freq[s.charAt(i)-'a'] >= k) 
                len++;
            else {
                if(maxlen<len) {
                    int t=longestSubstring(s.substring(i-len, len), k);
                    if(t>maxlen)
                        maxlen=t;
                }
                len=0;                
            }
        }
    
        if(len==s.length()) 
            return len;
    
        if(maxlen<len) {
            int t=longestSubstring(s.substring(s.length()-len, len), k);
            maxlen=Math.max(t, maxlen);
        }
        return maxlen; 
    }
}

//Complexity: O(n)

