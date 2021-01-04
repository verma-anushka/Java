
//Day 28: 
//Problem Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3475/
//Problem Statement: Subarray Product Less Than K

// Your are given an array of positive integers nums.

// Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

// Example 1:

// Input: nums = [10, 5, 2, 6], k = 100
// Output: 8
// Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
// Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

// Note:
// 0 < nums.length <= 50000.
// 0 < nums[i] < 1000.
// 0 <= k < 10^6.

//Solution:
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int si=0, ei=0, prod=1, ans=0;

        while(ei<nums.length) {
            
            prod *= nums[ei];

            while(si < nums.length && prod >= k) {
                prod /= nums[si];
                si++;
            }

            if(prod < k) ans += ei-si+1;
            ei++;

        }

        return ans;
    }
}
//Complexity: O(n*n)

