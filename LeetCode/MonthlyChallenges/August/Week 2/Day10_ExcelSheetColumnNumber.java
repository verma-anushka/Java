
//Day 10: 
//Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3419/
//Problem Statement: Excel Sheet Column Number

// Given a column title as appear in an Excel sheet, return its corresponding column number.

// For example:

//     A -> 1
//     B -> 2
//     C -> 3
//     ...
//     Z -> 26
//     AA -> 27
//     AB -> 28 
//     ...
// Example 1:

// Input: "A"
// Output: 1
// Example 2:

// Input: "AB"
// Output: 28
// Example 3:

// Input: "ZY"
// Output: 701
 

// Constraints:

// 1 <= s.length <= 7
// s consists only of uppercase English letters.
// s is between "A" and "FXSHRXW".

//Solution:
class Solution {
    public int titleToNumber(String s) {
        int power=0, colnum=0;
        while(s.length() != 0) {
            colnum += (s.charAt(s.length()-1) - 'A' + 1)*Math.pow(26, power);
            power++;
            s=s.substring(0, s.length()-1);
        }
        return colnum;
    }
}
//Complexity: O(n)

