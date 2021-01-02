
//Day 4: 
//Problem Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3448/
//Problem Statement: Partition Labels

// A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

 

// Example 1:

// Input: S = "ababcbacadefegdehijhklij"
// Output: [9,7,8]
// Explanation:
// The partition is "ababcbaca", "defegde", "hijhklij".
// This is a partition so that each letter appears in at most one part.
// A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.

 

// Note:

//     S will have length in range [1, 500].
//     S will consist of lowercase English letters ('a' to 'z') only.


//Solution:
class Solution {
    public List<Integer> partitionLabels(String s) {
        
        if(s.length()==0) return null;
        
        List<Integer> ans=new ArrayList();
        int []freq=new int[26]; 
        for(int i=0; i<s.length(); i++) {
            freq[s.charAt(i)-'a']=i;
        }
        
        int si=0, ei=0;
        for(int i=0; i<s.length(); i++) {
            ei=Math.max(ei, freq[s.charAt(i)-'a']);
            
            if(i==ei) {
                ans.add(ei-si+1);
                si=ei+1;
            }
        }
        
        return ans;
    }
}
//Complexity: O(n)
