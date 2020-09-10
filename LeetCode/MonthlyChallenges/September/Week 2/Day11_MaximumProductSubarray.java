
//Day 11: 
//Problem Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3456/
//Problem Statement: Maximum Product Subarray

// Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

// Example 1:

// Input: [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.

// Example 2:

// Input: [-2,0,-1]
// Output: 0
// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.



//Solution:
class Solution {
    public int maxProduct(int[] nums) {

        int ans = nums[0];
        int maxprod=nums[0];
        int minprod=nums[0];
        
        for(int i=1 ; i<nums.length ; i++) {
            curr_maxprod= Math.max(prev_maxprod*nums[i], Math.max(prev_minprod*nums[i], nums[i]) );
            curr_minprod= Math.min(prev_maxprod*nums[i], Math.min(prev_minprod*nums[i], nums[i]) );
            ans = Math.max(ans, curr_maxprod);
            prev_maxprod=curr_maxprod;           
            prev_minprod=curr_minprod;
        }
        
        return ans;
    }
}
//Complexity: O(n)
