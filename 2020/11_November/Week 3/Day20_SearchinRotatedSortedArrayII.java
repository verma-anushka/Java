
//Day 20: 
//Problem Statement: Search in Rotated Sorted Array II

// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

// (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

// You are given a target value to search. If found in the array return true, otherwise return false.

// Example 1:

// Input: nums = [2,5,6,0,0,1,2], target = 0
// Output: true
// Example 2:

// Input: nums = [2,5,6,0,0,1,2], target = 3
// Output: false
// Follow up:

// This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
// Would this affect the run-time complexity? How and why?

//Solution:
class Solution {
    public boolean search(int[] nums, int t) {
        // int n=nums.size();
        if (nums.length==0) return false;
        
        int si=0, ei=nums.length-1;
        
        while(si<=ei) {
            
            int mid = si+(ei-si)/2;
            
            if (nums[mid]==t) return true;
            
            if (nums[mid]==nums[si]) {
                si++; continue;
            }
            
            boolean left=nums[mid]>nums[si];
            if (left && t>=nums[si] && t<nums[mid])
                ei=mid;
            else if (!left && (t<nums[mid] || t>=nums[si]))
                ei=mid;
            else
                si=mid+1;
            
        }
        
        return false;
    }
}
//Complexity: O(log*n)

