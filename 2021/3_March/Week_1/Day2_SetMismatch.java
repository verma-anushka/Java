
//Day 2: 
//Problem Statement: Set Mismatch

// You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

// You are given an integer array nums representing the data status of this set after the error.

// Find the number that occurs twice and the number that is missing and return them in the form of an array.

 

// Example 1:

// Input: nums = [1,2,2,4]
// Output: [2,3]
// Example 2:

// Input: nums = [1,1]
// Output: [1,2]
 

// Constraints:

// 2 <= nums.length <= 104
// 1 <= nums[i] <= 104

//Solution:
class Solution {
    public int[] findErrorNums(int[] nums) {
        
        int []ans=new int[2];
        int missing=1, dup=0;
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i]==nums[i+1]) {
                dup=nums[i];
            } else if(nums[i+1]>nums[i]+1) {
                missing=nums[i]+1;
            }
        }
        
        ans[0]=dup;
        ans[1]=nums[nums.length-1]!=nums.length ? nums.length: missing;
        
        return ans;
    }
}
//Complexity: O(n*logn)

