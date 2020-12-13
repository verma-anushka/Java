
//Day 13: 
//Problem Statement: Burst Balloons

// You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

// If you burst the ith balloon, you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

// Return the maximum coins you can collect by bursting the balloons wisely.

 

// Example 1:

// Input: nums = [3,1,5,8]
// Output: 167
// Explanation:
// nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
// coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
// Example 2:

// Input: nums = [1,5]
// Output: 10
 

// Constraints:

// n == nums.length
// 1 <= n <= 500
// 0 <= nums[i] <= 100

//Solution:
class Solution {
        
    int [][]dp=new int[500][500];
   
    public int maxCoins(int[] nums) {
        
        if(nums.length==0) 
            return 0;
        
        return maxCoinsUtil(0, nums.length-1, nums);
    }
    
    public int maxCoinsUtil(int si, int ei, int[] nums) {
        
        if(si>ei)
            return 0;
        
        if(dp[si][ei] != 0)
            return dp[si][ei];
        
        int ans=0, left=1, right=1;
        
        if(si-1>=0) 
            left=nums[si-1];
        
        if(ei+1<nums.length) 
            right=nums[ei+1];
        
        for(int i=si; i<=ei; i++) {
            ans = Math.max(ans, nums[i]*left*right + maxCoinsUtil(si, i-1, nums) + maxCoinsUtil(i+1, ei, nums));
        }
        
        dp[si][ei]=ans;
        return ans;

    }

}
//Complexity: O(n^2)

