
//Day 15: 
//Problem Statement: Squares of a Sorted Array

// Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

// Example 1:

// Input: nums = [-4,-1,0,3,10]
// Output: [0,1,9,16,100]
// Explanation: After squaring, the array becomes [16,1,0,9,100].
// After sorting, it becomes [0,1,9,16,100].
// Example 2:

// Input: nums = [-7,-3,2,3,11]
// Output: [4,9,9,49,121]
 

// Constraints:

// 1 <= nums.length <= 104
// -104 <= nums[i] <= 104
// nums is sorted in non-decreasing order.

//Solution:
class Solution {
    public int[] sortedSquares(int[] a) {
        
        int []ans=new int[a.length];
        int j=0, k=0;
        while (j<a.length && a[j]<0) j++;

        int i=j-1;
        while(i>=0 && j<a.length) {
            if(a[i]*a[i]<a[j]*a[j]) ans[k++]=a[i]*a[i--];
            else ans[k++]=a[j]*a[j++];
        }
        
        while(i>=0) ans[k++]=a[i]*a[i--];
        while(j<a.length) ans[k++]=a[j]*a[j++];

        return ans;
        
    }
}
//Complexity: O(n)

