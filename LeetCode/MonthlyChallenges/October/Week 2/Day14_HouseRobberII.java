
//Day 14: 
//Problem Statement: House Robber II

// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given a list of non-negative integers nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

// Example 1:

// Input: nums = [2,3,2]
// Output: 3
// Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
// Example 2:

// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.
// Example 3:

// Input: nums = [0]
// Output: 0
 

// Constraints:

// 1 <= nums.length <= 100
// 0 <= nums[i] <= 1000

//Solution :
class Solution {
    
    public int rob(int[] nums) {
        if (nums.length==1) return nums[0];
        if (nums.length==2) return Math.max(nums[0], nums[1]);
        
        int []nums1=new int[nums.length];
        int []nums2=new int[nums.length];
        
        
        for(int i=0; i<nums.length-1; i++) {
            nums1[i]=nums[i];
            nums2[i]=nums[i+1];
        }
        
        return Math.max(houseRobber(nums1), houseRobber(nums2));
    
    }
    
    public int houseRobber(int[] nums) {

        int []dp=new int[nums.length];
        
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0], nums[1]);
        
        for(int i=2; i<nums.length; i++)
            dp[i]=Math.max(dp[i-1], nums[i]+dp[i-2]);
        
        return dp[nums.length-1];
    
    }
}

//Complexity: O(n*n)
