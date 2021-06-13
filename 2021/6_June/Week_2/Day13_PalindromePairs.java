
//Day 13: 
//Problem Statement: Palindrome Pairs

// Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list, so that the concatenation of the two words words[i] + words[j] is a palindrome.

// Example 1:

// Input: words = ["abcd","dcba","lls","s","sssll"]
// Output: [[0,1],[1,0],[3,2],[2,4]]
// Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
// Example 2:

// Input: words = ["bat","tab","cat"]
// Output: [[0,1],[1,0]]
// Explanation: The palindromes are ["battab","tabbat"]
// Example 3:

// Input: words = ["a",""]
// Output: [[0,1],[1,0]]
 

// Constraints:

// 1 <= words.length <= 5000
// 0 <= words[i].length <= 300
// words[i] consists of lower-case English letters.

//Solution:
class Solution {
    
    private boolean isPalindrome(String word, int i, int j) {
        while(i<j)
            if(word.charAt(i++)!=word.charAt(j--)) 
                return false;
        return true;
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> ans=new ArrayList<>();
        Map<String, Integer> mp=new HashMap<>();
        
        for(int i=0; i<words.length; i++) {
            mp.put(words[i], i);            
        }
        
        for(int i=0; i<words.length; i++) {
            if(words[i].equals("")) {
                for(int j=0; j<words.length; j++) {
                    String w=words[j];
                    if(isPalindrome(w, 0, w.length()-1) && j!=i) {
                        ans.add(List.of(i, j));
                        ans.add(List.of(j, i));
                    }
                }    
                continue;
            }
            
            StringBuilder temp=new StringBuilder(words[i]);
            temp.reverse();
            String rev=temp.toString();
            
            if(mp.containsKey(rev)) {
                int idx=mp.get(rev);
                if(idx!=i) 
                    ans.add(List.of(i, idx));
            }
            
            for(int j=1; j<rev.length(); j++) {
                if(isPalindrome(rev, 0, j-1)) {
                    String s=rev.substring(j);
                    if(mp.containsKey(s))
                        ans.add(List.of(i, mp.get(s)));
                }
                
                if(isPalindrome(rev, j, rev.length()-1)) {
                    String s=rev.substring(0,j);
                    if(mp.containsKey(s))
                        ans.add(List.of(mp.get(s), i));
                }
            }
        }
        return ans;
    }
    
}
//Complexity: O(n^2)

