
//Day 6: 
//Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3414/
//Problem Statement: Find All Duplicates in an Array

// Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

// Find all the elements that appear twice in this array.

// Could you do it without extra space and in O(n) runtime?

// Example:
// Input:
// [4,3,2,7,8,2,3,1]

// Output:
// [2,3]

//Solution #1:
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans= new LinkedList<>() ;
        for(int i=0; i<nums.length; i++) {
            int idx = Math.abs(nums[i])-1;
            if(nums[idx] < 0) ans.add(Math.abs(nums[i]));
            else nums[idx]=-nums[idx];
        }
        return ans;
    }
}
//Complexity: O(n)

