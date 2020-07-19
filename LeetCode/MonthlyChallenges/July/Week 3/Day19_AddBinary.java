
//Day 19: 
//Problem Link: https://leetcode.com/explore/featured/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3395/
//Problem Statement: Add Binary

//Given two binary strings, return their sum (also a binary string).

//The input strings are both non-empty and contains only characters 1 or 0.

//Example 1:

//Input: a = "11", b = "1"
//Output: "100"
//Example 2:

//Input: a = "1010", b = "1011"
//Output: "10101"
 

//Constraints:

//Each string consists only of '0' or '1' characters.
//1 <= a.length, b.length <= 10^4
//Each string is either "0" or doesn't contain any leading zero.

//Solution:
class Solution {
    public String addBinary(String a, String b) {
        
        String ans="";
        int c=0;
        int i=a.length()-1, j=b.length()-1;
        
        while(i>=0 && j>=0) {
            if(a.charAt(i) == '0' && b.charAt(j) == '0') {
                ans += String.valueOf(c);
                c=0;
            } else if((a.charAt(i) == '1' && b.charAt(j) == '0') || (a.charAt(i) == '0' && b.charAt(j) == '1')){
                ans += c==0 ? "1" : "0";
            } else {
                ans += c==0 ? "0" : "1";
                c=1;
            }
            i--; j--;
        }
        
        while(i>=0) {
            if(a.charAt(i) == '0') {
                ans += String.valueOf(c);
                c=0;
            } else {
                ans += c==0 ?  "1" : "0";
            }
            i--;
        }
        
        while(j>=0) {
            if(b.charAt(j) == '0') {
                ans += String.valueOf(c);
                c=0;
            } else {
                ans += c==0 ? "1" : "0";
            }
            j--;
        }
        
        if(c!=0) ans += String.valueOf(c);
        
        StringBuilder sum = new StringBuilder(); 
        sum.append(ans); 
        sum=sum.reverse(); 
        
        ans = sum.toString();
        
        return ans;
    
    }
}

//Complexity: O(n)

