
//Day 26: 
//Problem Statement: Word Subsets

// We are given two arrays A and B of words.  Each word is a string of lowercase letters.

// Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.  For example, "wrr" is a subset of "warrior", but is not a subset of "world".

// Now say a word a from A is universal if for every b in B, b is a subset of a. 

// Return a list of all universal words in A.  You can return the words in any order.

 

// Example 1:

// Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
// Output: ["facebook","google","leetcode"]
// Example 2:

// Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
// Output: ["apple","google","leetcode"]
// Example 3:

// Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
// Output: ["facebook","google"]
// Example 4:

// Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
// Output: ["google","leetcode"]
// Example 5:

// Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
// Output: ["facebook","leetcode"]
 

// Note:

// 1 <= A.length, B.length <= 10000
// 1 <= A[i].length, B[i].length <= 10
// A[i] and B[i] consist only of lowercase letters.
// All words in A[i] are unique: there isn't i != j with A[i] == A[j].

//Solution:
class Solution {
    
    public int[] getFreq(String s) {
        
        int freq[]=new int[26];
        for(char c: s.toCharArray()) {
            freq[c-'a']++;
        }
        return freq;
        
    }
    
    public List<String> wordSubsets(String[] a, String[] b) {
        
        List<String> ans=new ArrayList<String>();
       
        int maxFreq[]=new int[26];
        
        for(int i=0; i<b.length; i++) {
            
            String word=b[i];
            int freq[]=getFreq(word);
            
            for(int j=0; j<26; j++) {
                maxFreq[j]=Math.max(maxFreq[j], freq[j]);
            } 
        }
        
        
        for(int i=0; i<a.length; i++) {
            
            String word=a[i];
            int freq[]=getFreq(word);
            boolean valid=true;
            
            for(int j=0; j<26; j++) {
                if(maxFreq[j]>freq[j]) {
                    valid=false;
                    break;
                }
            }
            
            if(valid) 
                ans.add(word);
        
        }
        
        return ans;
    
    }

}
//Complexity: O(n+m)

