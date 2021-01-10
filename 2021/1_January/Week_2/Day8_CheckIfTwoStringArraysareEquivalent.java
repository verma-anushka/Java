
//Day 8: 
//Problem Statement: Check If Two String Arrays are Equivalent

// Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

// A string is represented by an array if the array elements concatenated in order forms the string.

 

// Example 1:

// Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
// Output: true
// Explanation:
// word1 represents string "ab" + "c" -> "abc"
// word2 represents string "a" + "bc" -> "abc"
// The strings are the same, so return true.
// Example 2:

// Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
// Output: false
// Example 3:

// Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
// Output: true
 

// Constraints:

// 1 <= word1.length, word2.length <= 103
// 1 <= word1[i].length, word2[i].length <= 103
// 1 <= sum(word1[i].length), sum(word2[i].length) <= 103
// word1[i] and word2[i] consist of lowercase letters.

//Solution:
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
         
        String s1=new String(), s2=new String();
        for(String w1: word1)
            s1 += w1;
        
        for(String w2: word2) 
            s2 += w2;
        
        // System.out.println(s1 + " " + s2);
        
        return s1.equals(s2);
    }
}
//Complexity: O(n)

