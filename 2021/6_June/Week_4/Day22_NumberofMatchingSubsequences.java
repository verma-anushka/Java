
//Day 22: 
//Problem Statement: Number of Matching Subsequences

// Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.

// A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

// For example, "ace" is a subsequence of "abcde".
 

// Example 1:

// Input: s = "abcde", words = ["a","bb","acd","ace"]
// Output: 3
// Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
// Example 2:

// Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
// Output: 2
 

// Constraints:

// 1 <= s.length <= 5 * 104
// 1 <= words.length <= 5000
// 1 <= words[i].length <= 50
// s and words[i] consist of only lowercase English letters.

//Solution:
class Solution {
    public boolean isSubSequence(String s, String word) {
        
        int n1=s.length(), n2=word.length(), j=0;
        
        for(int i=0; i<n1 && j<n2; i++) {
            if(word.charAt(j)==s.charAt(i))
                j++;
        }
        
        return j==n2;
        
    }
    
    public int numMatchingSubseq(String s, String[] words) {
        
        int ans=0;
        Map<String, Boolean> map=new HashMap();
        
        for(String word: words) {
            if(!map.containsKey(word)) {
                if(isSubSequence(s, word)) {
                    ans++;
                    map.put(word, true);
                } else {
                    map.put(word, false);
                }
            } else {  
                if (map.get(word))
                    ans++;
            }
        }
        
        return ans;
    }
}
//Complexity: O(n*n)

