
//Day 11: 
//Problem Statement: Remove Duplicate Letters

// Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

// Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/


// Example 1:

// Input: s = "bcabc"
// Output: "abc"
// Example 2:

// Input: s = "cbacdcbc"
// Output: "acdb"
 

// Constraints:

// 1 <= s.length <= 104
// s consists of lowercase English letters.

//Solution:
class Solution {
    public String removeDuplicateLetters(String s) {
        
        int []freq=new int[26];
        boolean []visited=new boolean[26];
        
        StringBuilder ans=new StringBuilder("");

        for(int i=0; i<s.length(); i++)
            freq[s.charAt(i)-'a']++;
        
        for(int i=0; i<s.length(); i++) {
            freq[s.charAt(i)-'a']--;
            
            if(visited[s.charAt(i)-'a'])
                continue;
    
            while(ans.length()>0 && ans.charAt(ans.length()-1)>s.charAt(i) && freq[ans.charAt(ans.length()-1)-'a']>0){
                visited[ans.charAt(ans.length()-1)-'a']=false;
                ans.deleteCharAt(ans.length()-1);
            }
            
            ans.append(s.charAt(i));
            visited[s.charAt(i)-'a']=true; 
        
        }
        return ans.toString();
        
    }
}

//Complexity: O(n)
