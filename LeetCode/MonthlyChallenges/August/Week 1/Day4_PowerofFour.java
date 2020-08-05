
//Day 4: 
//Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3412/
//Problem Statement: Power of Four

// Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

// Example 1:

// Input: 16
// Output: true
// Example 2:

// Input: 5
// Output: false
// Follow up: Could you solve it without loops/recursion?

//Solution #1:
class Solution {
    public boolean isPowerOfFour(int num) {
        if(num <= 0) return false;
        int count0=0, count1=0;
        
        while(num != 0) {
            if((num & 1) != 0) count1++;
            else count0++;
            num >>= 1;
        }
        
        if(count1 == 1 && count0 %2 == 0) return true;
        else return false;
    }
}

//Complexity: O(logn)
