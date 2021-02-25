
//Day 25: 
//Problem Statement: Shortest Unsorted Continuous Subarray

// Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

// Return the shortest such subarray and output its length.

 

// Example 1:

// Input: nums = [2,6,4,8,10,9,15]
// Output: 5
// Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
// Example 2:

// Input: nums = [1,2,3,4]
// Output: 0
// Example 3:

// Input: nums = [1]
// Output: 0
 

// Constraints:

// 1 <= nums.length <= 104
// -105 <= nums[i] <= 105
 

// Follow up: Can you solve it in O(n) time complexity?

//Solution:
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int n=nums.length, left=-1, right=-1, max_num=nums[0], min_num=nums[n-1];
        
        for(int i=1; i<n; i++) {
            
            int a=nums[i], b=nums[n-i-1];
            
            if(a<max_num) right=i;
            else max_num=a;
            
            if(b>min_num) left=i;
            else min_num=b;
        }
        
        return Math.max(0, left+right-n+2);
    
    }
}
//Complexity: O(n)
