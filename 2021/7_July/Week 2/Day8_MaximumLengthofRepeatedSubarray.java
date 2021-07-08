
//Day 8: 
//Problem Statement: Maximum Length of Repeated Subarray

// Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.

 

// Example 1:

// Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
// Output: 3
// Explanation: The repeated subarray with maximum length is [3,2,1].
// Example 2:

// Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
// Output: 5
 

// Constraints:

// 1 <= nums1.length, nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 100

//Solution:
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        
        int [][]dp=new int[nums1.length+1][nums2.length+1];
        int ans=0;
        
        for(int i=0; i<=nums1.length; i++) {
            for(int j=0; j<=nums2.length; j++) {
                
                if(i==0 || j==0)
                    dp[i][j]=0;
                else {
                    if(nums1[i-1]==nums2[j-1])
                        dp[i][j]=dp[i-1][j-1]+1;
                    else
                        dp[i][j]=0;
                }
                ans=Math.max(ans, dp[i][j]);
            }
        }
      
        return ans;
    }
}
//Complexity: O(m*n)