
//Day 23: 
//Problem Link: https://leetcode.com/explore/featured/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3399/
//Problem Statement: Single Number III

// Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

// Example:

// Input:  [1,2,1,3,2,5]
// Output: [3,5]
// Note:

// The order of the result is not important. So in the above example, [5, 3] is also correct.
// Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?


//Solution:
class Solution {
    public int[] singleNumber(int[] nums) {

        int nums_xor=0;
        for(int n:nums) nums_xor^=n;
        
        // int firstbit=nums_xor & (-nums_xor);
        int firstbit=nums_xor&(~(nums_xor-1));
        
        int num1=0, num2=0;
        for(int n:nums) {
            if((n & firstbit) == 0) num1^=n;
            else num2^=n;
        }
        return new int[]{num1, num2};
    }
}
//Complexity: O(n)
