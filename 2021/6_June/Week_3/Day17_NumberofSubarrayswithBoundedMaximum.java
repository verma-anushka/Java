
//Day 17: 
//Problem Statement: Number of Subarrays with Bounded Maximum

// Given an integer array nums and two integers left and right, return the number of contiguous non-empty subarrays such that the value of the maximum array element in that subarray is in the range [left, right].

// The test cases are generated so that the answer will fit in a 32-bit integer.

 

// Example 1:

// Input: nums = [2,1,4,3], left = 2, right = 3
// Output: 3
// Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
// Example 2:

// Input: nums = [2,9,2,5,6], left = 2, right = 8
// Output: 7
 

// Constraints:

// 1 <= nums.length <= 105
// 0 <= nums[i] <= 109
// 0 <= left <= right <= 109

//Solution:
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        
        int ans=0, low=0, mid=0;
        
        for(int num: nums) {
            
            if(num>right) mid=0;
            else ans += ++mid;
            
            if(num >= left) low=0;
            else ans -= ++low;
        
        }
        return ans;        
    }
}
//Complexity: O(n)
