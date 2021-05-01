//Day 29:
//Problem Statement: Find First and Last Position of Element in Sorted Array

// Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

// If target is not found in the array, return [-1, -1].

// Follow up: Could you write an algorithm with O(log n) runtime complexity?

 

// Example 1:

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:

// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
// Example 3:

// Input: nums = [], target = 0
// Output: [-1,-1]
 

// Constraints:

// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums is a non-decreasing array.
// -109 <= target <= 109

//Solution: 
class Solution {

    int find(int[] nums, int target, int left) {
       
        int right=nums.length-1;
        while(left<=right) {
            int mid=(left+right)/2;
            if(nums[mid]<target) left=mid+1;
            else right=mid-1;
        }
        return left;
    }
    
    int[] searchRange(int[] nums, int target) {
        
        int left=find(nums, target, 0);
        
        if(left==nums.length || nums[left]!=target) return new int[] {-1, -1};
        
        return new int[] {left, find(nums, target+1, left)-1};
    }
}
//Complexity: O(logn)
