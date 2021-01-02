
//Day 29: 
//Problem Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/558/week-5-september-29th-september-30th/3477/
//Problem Statement: Word Break

// Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

// Note:

//     The same word in the dictionary may be reused multiple times in the segmentation.
//     You may assume the dictionary does not contain duplicate words.

// Example 1:

// Input: s = "leetcode", wordDict = ["leet", "code"]
// Output: true
// Explanation: Return true because "leetcode" can be segmented as "leet code".

// Example 2:

// Input: s = "applepenapple", wordDict = ["apple", "pen"]
// Output: true
// Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
//              Note that you are allowed to reuse a dictionary word.

// Example 3:

// Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
// Output: false



//Solution:
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        Set<String> dict = new HashSet(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for(int i=1; i<=s.length(); i++) {
            for(int j=0; j<i; j++) {
                // System.out.println(s.substring(j, i)+ " " + i + " " + j);
                if(dict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i]=true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    
    }
}
//Complexity: O(n*n)

