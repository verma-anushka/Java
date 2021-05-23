//Day 24: 
//Problem Statement: To Lower Case

// Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.

 

// Example 1:

// Input: s = "Hello"
// Output: "hello"
// Example 2:

// Input: s = "here"
// Output: "here"
// Example 3:

// Input: s = "LOVELY"
// Output: "lovely"
 

// Constraints:

// 1 <= s.length <= 100
// s consists of printable ASCII characters.

//Solution:
class Solution {
    public String toLowerCase(String s) {
        
        char[] str=s.toCharArray();
        
        for(int i=0; i<str.length; i++) {
            if(str[i]>64 && str[i]<91)
                str[i]+=32;
        }
        
        return String.valueOf(str);
    }
}
//Complexity: O(n)

