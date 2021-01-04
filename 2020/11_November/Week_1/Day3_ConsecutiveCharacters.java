
//Day 3: 
//Problem Statement: Consecutive Characters

// Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.

// Return the power of the string.

 

// Example 1:

// Input: s = "leetcode"
// Output: 2
// Explanation: The substring "ee" is of length 2 with the character 'e' only.
// Example 2:

// Input: s = "abbcccddddeeeeedcba"
// Output: 5
// Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
// Example 3:

// Input: s = "triplepillooooow"
// Output: 5
// Example 4:

// Input: s = "hooraaaaaaaaaaay"
// Output: 11
// Example 5:

// Input: s = "tourist"
// Output: 1
 

// Constraints:

// 1 <= s.length <= 500
// s contains only lowercase English letters.


//Solution:
class Solution {
    public int maxPower(String s) {
        
        int []power=new int[26];
        
        int i=0, ans=0;
        while(i<s.length()) {
            int p=1;
            while(i+1<s.length() && s.charAt(i)==s.charAt(i+1)) {
                p++; i++;
            }
            power[s.charAt(i)-'a']=Math.max(p, power[s.charAt(i)-'a']);
            i++;
        }
        // cout << endl;
        
        for(i=0; i<26; i++) {
            ans=Math.max(ans, power[i]);
        }
        
        return ans;
    }
}
//Complexity: O(n^2)
