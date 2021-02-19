
//Day 20: 
//Problem Statement: Roman to Integer

// Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000
// For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

// Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900.
// Given a roman numeral, convert it to an integer.

 

// Example 1:

// Input: s = "III"
// Output: 3
// Example 2:

// Input: s = "IV"
// Output: 4
// Example 3:

// Input: s = "IX"
// Output: 9
// Example 4:

// Input: s = "LVIII"
// Output: 58
// Explanation: L = 50, V= 5, III = 3.
// Example 5:

// Input: s = "MCMXCIV"
// Output: 1994
// Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

// Constraints:

// 1 <= s.length <= 15
// s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
// It is guaranteed that s is a valid roman numeral in the range [1, 3999].

//Solution:
class Solution {
    public int romanToInt(String s) {
         int num=0;
		
        for(int i=0; i<s.length(); i++) {
			
            if(s.charAt(i)=='I') num+=1;
			if(s.charAt(i)=='V') num+=5;
			if(s.charAt(i)=='X') num+=10;
			if(s.charAt(i)=='L') num+=50;
			if(s.charAt(i)=='C') num+=100;
			if(s.charAt(i)=='D') num+=500;
			if(s.charAt(i)=='M') num+=1000;
			
			if(i>=1 && (s.charAt(i-1)=='I') && (s.charAt(i)=='V' || s.charAt(i)=='X')) num-=2;
			if(i>=1 && (s.charAt(i-1)=='X') && (s.charAt(i)=='L' || s.charAt(i)=='C')) num-=20;
			if(i>=1 && (s.charAt(i-1)=='C') && (s.charAt(i)=='D' || s.charAt(i)=='M')) num-=200;
            
		}
		
		return num;
    }
}
//Complexity: O(n)
