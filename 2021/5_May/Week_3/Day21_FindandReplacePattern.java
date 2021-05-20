
//Day 21: 
//Problem Statement: Find and Replace Pattern

// Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.

// A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

// Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.

 

// Example 1:

// Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
// Output: ["mee","aqq"]
// Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
// "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.
// Example 2:

// Input: words = ["a","b","c"], pattern = "a"
// Output: ["a","b","c"]
 

// Constraints:

// 1 <= pattern.length <= 20
// 1 <= words.length <= 50
// words[i].length == pattern.length
// pattern and words[i] are lowercase English letters.

//Solution:
class Solution {
    
    public boolean isSame(String p, String w) {
        
        HashMap<Character, Character> fwd=new HashMap<>();
        HashMap<Character, Character> bwd=new HashMap<>();
        
        for(int i=0; i<p.length(); i++) {
            
            if(!fwd.containsKey(w.charAt(i))) fwd.put(w.charAt(i), p.charAt(i));
            if(!bwd.containsKey(p.charAt(i))) bwd.put(p.charAt(i), w.charAt(i));
            
            if(fwd.get(w.charAt(i))!=p.charAt(i) || bwd.get(p.charAt(i))!=w.charAt(i)) return false;
            
        }
        
        return true;
    }
    
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans=new ArrayList<>();
        for(String w: words) {
            if(isSame(pattern, w)) ans.add(w);
        }    
        return ans;    
    }
}
//Complexity: O(n*w), n-> number of words, w -> length of each word

