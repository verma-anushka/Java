
//Day 27: 
//Problem Statement: Partition Equal Subset Sum

// Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

 

// Example 1:

// Input: nums = [1,5,11,5]
// Output: true
// Explanation: The array can be partitioned as [1, 5, 5] and [11].
// Example 2:

// Input: nums = [1,2,3,5]
// Output: false
// Explanation: The array cannot be partitioned into equal sum subsets.
 

// Constraints:

// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100

//Solution:
class Solution {
    
    public boolean subsetSumToK(int []nums, int k) {
     	
        int n=nums.length;
        boolean dp[][] = new boolean[n+1][k+1];

        // for(int i=0; i<=n; i++)
        //     dp[i] = new bool[k+1];

        for(int i=0; i<=n; i++) {
            for(int j=0; j<=k; j++) {

                if(j==0)
                    dp[i][j]=true;

                else if(i==0)
                    dp[i][j]=false;

                else {
                    
                    if(nums[i-1] <= j)
                        dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                    else 
                       dp[i][j] = dp[i-1][j];
                
                }
            }
        }

        return dp[n][k];
    
    }

    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        
        if(sum%2 != 0) 
            return false;
        else 
            return subsetSumToK(nums, sum/2);
                
    }
}
//Complexity: O(sum*n)

