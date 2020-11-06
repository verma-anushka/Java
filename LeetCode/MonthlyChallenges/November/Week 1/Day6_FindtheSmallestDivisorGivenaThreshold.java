
//Day 6: 
//Problem Statement: Find the Smallest Divisor Given a Threshold

// Given an array of integers nums and an integer threshold, we will choose a positive integer divisor and divide all the array by it and sum the result of the division. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.

// Each result of division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

// It is guaranteed that there will be an answer.

 

// Example 1:

// Input: nums = [1,2,5,9], threshold = 6
// Output: 5
// Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
// If the divisor is 4 we can get a sum to 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2). 
// Example 2:

// Input: nums = [2,3,5,7,11], threshold = 11
// Output: 3
// Example 3:

// Input: nums = [19], threshold = 5
// Output: 4
 

// Constraints:

// 1 <= nums.length <= 5 * 104
// 1 <= nums[i] <= 106
// nums.length <= threshold <= 106

//Solution:
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        
        int maxV=Integer.MIN_VALUE;
        long sums=0;
        
        for(int i: nums) {
            sums+=i;
            maxV=Math.max(maxV, i);
        }
        
        int left=1, right=maxV+1;
        while(left < right) {
            
            int mid=left+(right-left)/2;
            if(getSum(nums, mid) > threshold) 
                left=mid+1;
            else 
                right=mid;
        }
        return left;    
    }
    
    public int getSum(int[] nums, int d) {
        int ans=0;        
        for(Integer i: nums)
            ans += Math.ceil(i.floatValue()/d);
        return ans;
    }
    
}
//Complexity: O(n*logn)
