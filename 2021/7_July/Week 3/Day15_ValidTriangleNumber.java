
//Day 15: 
//Problem Statement: Valid Triangle Number

// Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

 

// Example 1:

// Input: nums = [2,2,3,4]
// Output: 3
// Explanation: Valid combinations are: 
// 2,3,4 (using the first 2)
// 2,3,4 (using the second 2)
// 2,2,3
// Example 2:

// Input: nums = [4,2,3,4]
// Output: 4
 

// Constraints:

// 1 <= nums.length <= 1000
// 0 <= nums[i] <= 1000

//Solution:
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        for(int i=nums.length-1; i>1; i--) {
            int l=0, r=i-1;
            while(l<r) {
                if(nums[l]+nums[r]>nums[i]) {
                    ans+=r-l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }
}
//Complexity: O(n*logn)

