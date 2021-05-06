
//Day 5: 
//Problem Statement: Jump Game II

// Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

// Each element in the array represents your maximum jump length at that position.

// Your goal is to reach the last index in the minimum number of jumps.

// You can assume that you can always reach the last index.

 

// Example 1:

// Input: nums = [2,3,1,1,4]
// Output: 2
// Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
// Example 2:

// Input: nums = [2,3,0,1,4]
// Output: 2
 

// Constraints:

// 1 <= nums.length <= 1000
// 0 <= nums[i] <= 105

//Solution:
class Solution {
    public int jump(int[] nums) {
                
        int n=nums.length;
        int []dp=new int[n];
        for(int i=1; i<n; i++) {
            dp[i]=Integer.MAX_VALUE;
        }
        dp[0]=0;
        
        for(int i=1; i<n; i++) {
            for(int j=i-1; j>=0; j--) {
                if(dp[j]!=Integer.MAX_VALUE && j+nums[j]>=i) {
                    dp[i]=Math.min(dp[i], dp[j]+1);
                }
            }
        }
        
        return dp[n-1];
    }
}

//Complexity: O(n*n)

