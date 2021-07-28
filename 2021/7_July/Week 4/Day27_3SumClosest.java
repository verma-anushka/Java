
//Day 27: 
//Problem Statement: 3Sum Closest

// Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 

// Example 1:

// Input: nums = [-1,2,1,-4], target = 1
// Output: 2
// Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 

// Constraints:

// 3 <= nums.length <= 10^3
// -10^3 <= nums[i] <= 10^3
// -10^4 <= target <= 10^4

//Solution:
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        int n=nums.length;
        Arrays.sort(nums);
        
        int mindiff=Integer.MAX_VALUE, ans=0;
        
        for(int i=0; i<n-2; i++) {
            int l=i+1, r=n-1;
            
            while(l<r) {
                
                int sum=nums[i]+nums[l]+nums[r];
                int diff=Math.abs(target-sum);
                
                if(diff<mindiff) {
                    mindiff=diff;
                    ans=sum;
                    if(mindiff==0) return ans;
                }
                
                if(sum<target) l++;
                else r--;
            }
        }
        
        return ans;
    }
}
//Complexity: O(n*logn)

