
//Day 30: 
//Problem Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/558/week-5-september-29th-september-30th/3478/
//Problem Statement: First Missing Positive

// Given an unsorted integer array, find the smallest missing positive integer.

// Example 1:

// Input: [1,2,0]
// Output: 3

// Example 2:

// Input: [3,4,-1,1]
// Output: 2

// Example 3:

// Input: [7,8,9,11,12]
// Output: 1

// Follow up:

// Your algorithm should run in O(n) time and uses constant extra space.


//Solution:
class Solution {
    public int firstMissingPositive(int[] nums) {

        int l=0, r=nums.length-1;
        
        while(l<r) {
            if((l+1)==nums[l]) {
                l++;
            } else if((r+1)==nums[r] || nums[r]<=0 || nums[r]>=nums.length || nums[nums[r]-1]==nums[r]) {
                r--;
            } else {
                // System.out.println(nums[r]+" "+ nums[nums[r]-1]);
                int temp=nums[r];
                nums[r]=nums[temp-1];
                nums[temp-1]=temp;
                // System.out.println(nums[r]+" "+ nums[nums[r]-1]);
            }
        }
        
        while(l<nums.length && (l+1)==nums[l]) 
            l++;
        
        return l+1;
    }
}
//Complexity: O(n)

