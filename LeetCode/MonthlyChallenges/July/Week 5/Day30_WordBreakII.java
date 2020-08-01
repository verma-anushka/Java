
//Day 30: 
//Problem Link: https://leetcode.com/explore/featured/card/july-leetcoding-challenge/548/week-5-july-29th-july-31st/3406/
//Problem Statement: Word Break II

// Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

// Note:

// The same word in the dictionary may be reused multiple times in the segmentation.
// You may assume the dictionary does not contain duplicate words.
// Example 1:

// Input:
// s = "catsanddog"
// wordDict = ["cat", "cats", "and", "sand", "dog"]
// Output:
// [
//   "cats and dog",
//   "cat sand dog"
// ]
// Example 2:

// Input:
// s = "pineapplepenapple"
// wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
// Output:
// [
//   "pine apple pen apple",
//   "pineapple pen apple",
//   "pine applepen apple"
// ]
// Explanation: Note that you are allowed to reuse a dictionary word.
// Example 3:

// Input:
// s = "catsandog"
// wordDict = ["cats", "dog", "sand", "and", "cat"]
// Output:
// []

//Solution:
class Solution {
    
    public List<String> wordBreakUtil(Set<String> dict, String s, Map<String, List<String>> mp){
        
        if(mp.containsKey(s)) return mp.get(s);

        List<String> ans=new ArrayList<>();
        
        if(s==null || s.isEmpty()) return ans;
        
        for(String word:dict) { 
            if(s.startsWith(word)) {
                if(s.length()==word.length())
                   ans.add(word);
               else {
                   List<String> temp=wordBreakUtil(dict, s.substring(word.length()), mp);
                   for(String str:temp){
                       ans.add(word + " " + str);
                   }
               }
            }
        }
        mp.put(s, ans);
        return ans;  
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
    
        Set<String> dict=new HashSet<>(wordDict);
        Map<String, List<String>> mp=new HashMap<>();
        return wordBreakUtil(dict, s, mp);
   
    }

}
//Complexity: O(2^n)

