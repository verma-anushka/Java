
//Day 4: 
//Problem Link: https://leetcode.com/explore/featured/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3380/
//Problem Statement: Ugly Number II

// Write a program to find the n-th ugly number.

// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

// Example:

// Input: n = 10
// Output: 12
// Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
// Note:  

// 1 is typically treated as an ugly number.
// n does not exceed 1690.

//Solution:
class Solution {
    public int nthUglyNumber(int n) {

        int i2=0, i3=0, i5=0;
        int []uglynums = new int[n];
        uglynums[0]=1;
        
        for(int i=1; i<n; i++) {
            int nm2=uglynums[i2]*2;
            int nm3=uglynums[i3]*3;
            int nm5=uglynums[i5]*5;
            
            uglynums[i] = Math.min(nm2, Math.min(nm3, nm5));
            
            if(uglynums[i]==nm2) i2++;
            if(uglynums[i]==nm3) i3++;
            if(uglynums[i]==nm5) i5++;
            
        }
        return uglynums[n-1];
    }
}
//Complexity: O(n)

