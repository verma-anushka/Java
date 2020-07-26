
//Day 25: 
//Problem Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3401/
//Problem Statement: Find Minimum in Rotated Sorted Array II

//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

//(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

//Find the minimum element.

//The array may contain duplicates.

//Example 1:

//Input: [1,3,5]
//Output: 1
//Example 2:

//Input: [2,2,2,0,1]
//Output: 0
//Note:

//This is a follow up problem to Find Minimum in Rotated Sorted Array.
//Would allow duplicates affect the run-time complexity? How and why?

//Solution #1:
class Solution {
    public int findMin(int[] nums) {
        
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i]>nums[i+1]) return nums[i+1];
        }
        return nums[0];
    }
}
//Complexity: O(n)


//Solution #2:
class Solution {
    public int findMin(int[] nums) {
        
        int si=0, ei=nums.length-1;
        while(si<ei) {
            int mid=si+(ei-si)/2;
            if(nums[ei] == nums[mid]) {
                ei--;
            } else if(nums[mid]>nums[ei]) {
                si=mid+1;
            } else {
                ei=mid;
            }
        }
        return nums[si];
    }
}
//Complexity: O(log n) || Worst case-> O(n)

