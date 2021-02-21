
//Day 22: 
//Problem Statement: Longest Word in Dictionary through Deleting

// Given a string s and a string array dictionary, return the longest string in the dictionary that can be formed by deleting some of the given string characters. If there is more than one possible result, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

 

// Example 1:

// Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
// Output: "apple"
// Example 2:

// Input: s = "abpcplea", dictionary = ["a","b","c"]
// Output: "a"
 

// Constraints:

// 1 <= s.length <= 1000
// 1 <= dictionary.length <= 1000
// 1 <= dictionary[i].length <= 1000
// s and dictionary[i] consist of lowercase English letters.

//Solution:
class Solution {
    
    public boolean isSubsequence(String a, String b) {

        int j=0;
        for(int i=0; i<b.length() && j<a.length(); i++) {
            if(a.charAt(j)==b.charAt(i))
                j++;
        }
        
        return j==a.length();
    
    }
    
    public String findLongestWord(String s, List<String> d) {
       
        String ans="";
        
        Collections.sort(d);
        
        for(int i=0; i<d.size(); i++) {
            
            if(ans.length() < d.get(i).length() && isSubsequence(d.get(i), s))
                ans=d.get(i);
        }
        
        return ans;
    }
}
//Complexity: O(n*logn)

