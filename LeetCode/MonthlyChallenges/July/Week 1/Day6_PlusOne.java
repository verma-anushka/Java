
//Day 6: 
//Problem Link: https://leetcode.com/explore/featured/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3382/
//Problem Statement: Plus One

// Given a non-empty array of digits representing a non-negative integer, increment one to the integer.

// The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

// You may assume the integer does not contain any leading zero, except the number 0 itself.

// Example 1:

// Input: [1,2,3]
// Output: [1,2,4]
// Explanation: The array represents the integer 123.
// Example 2:

// Input: [4,3,2,1]
// Output: [4,3,2,2]
// Explanation: The array represents the integer 4321.

//Solution:
class Solution {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1; i>=0; i--) {
            if(digits[i] !=9) {
                digits[i]++;
                return digits;
            }
            else digits[i] = 0;
        }
        
        int[] ans = new int[digits.length+1];
        ans[0]=1;
        for(int i=1; i<=digits.length; i++) {
            ans[i] = digits[i-1];
        }
        return ans;

    }
}
//Complexity: O(n)

