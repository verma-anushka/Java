
//Day 16: 
//Problem Statement: 4Sum

// Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

// 0 <= a, b, c, d < n
// a, b, c, and d are distinct.
// nums[a] + nums[b] + nums[c] + nums[d] == target
// You may return the answer in any order.

 

// Example 1:

// Input: nums = [1,0,-1,0,-2,2], target = 0
// Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// Example 2:

// Input: nums = [2,2,2,2,2], target = 8
// Output: [[2,2,2,2]]
 

// Constraints:

// 1 <= nums.length <= 200
// -109 <= nums[i] <= 109
// -109 <= target <= 109

//Solution:
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> ans=new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int l=j+1, r=n-1;
                int left=target-nums[i]-nums[j];
                
                while(l<r) {
                    if(nums[l]+nums[r]==left) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++; r--;
                        
                        while(l<r && nums[l-1]==nums[l]) l++;
                    } else if(nums[l]+nums[r]>left) {
                        r--;
                    } else {
                        l++;
                    }
                }
                
                while(j+1<n && nums[j]==nums[j+1]) j++;
            }
            
            while(i+1<n && nums[i]==nums[i+1]) i++;
        }
        
        return ans;
    }
}
//Complexity: O(n^3)

