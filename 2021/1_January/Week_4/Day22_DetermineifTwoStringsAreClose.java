
//Day 22: 
//Problem Statement: Determine if Two Strings Are Close

// Two strings are considered close if you can attain one from the other using the following operations:

// Operation 1: Swap any two existing characters.
// For example, abcde -> aecdb
// Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
// For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
// You can use the operations on either string as many times as necessary.

// Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.

 

// Example 1:

// Input: word1 = "abc", word2 = "bca"
// Output: true
// Explanation: You can attain word2 from word1 in 2 operations.
// Apply Operation 1: "abc" -> "acb"
// Apply Operation 1: "acb" -> "bca"
// Example 2:

// Input: word1 = "a", word2 = "aa"
// Output: false
// Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
// Example 3:

// Input: word1 = "cabbba", word2 = "abbccc"
// Output: true
// Explanation: You can attain word2 from word1 in 3 operations.
// Apply Operation 1: "cabbba" -> "caabbb"
// Apply Operation 2: "caabbb" -> "baaccc"
// Apply Operation 2: "baaccc" -> "abbccc"
// Example 4:

// Input: word1 = "cabbba", word2 = "aabbss"
// Output: false
// Explanation: It is impossible to attain word2 from word1, or vice versa, in any amount of operations.
 

// Constraints:

// 1 <= word1.length, word2.length <= 105
// word1 and word2 contain only lowercase English letters.

//Solution:
class Solution {
    public boolean closeStrings(String word1, String word2) {
         
        Set<Character> st1=new HashSet<Character>();
        Set<Character> st2=new HashSet<Character>();
        
        int[] f1=new int[26];
        int[] f2=new int[26];
        
        for(char c: word1.toCharArray()) {
            f1[c-'a']++;
            st1.add(c);
        }
        
        for(char c: word2.toCharArray()) {
            f2[c-'a']++;
            st2.add(c);
        }
        
        Arrays.sort(f1);
        Arrays.sort(f2);
        
        return st1.equals(st2) && Arrays.equals(f1, f2);
    
    }
}
//Complexity: O(n)

