
//Day 16: 
//Problem Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3462/
//Problem Statement: Maximum XOR of Two Numbers in an Array

// Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 ≤ i ≤ j < n.

// Follow up: Could you do this in O(n) runtime?

 

// Example 1:

// Input: nums = [3,10,5,25,2,8]
// Output: 28
// Explanation: The maximum result is 5 XOR 25 = 28.

// Example 2:

// Input: nums = [0]
// Output: 0

// Example 3:

// Input: nums = [2,4]
// Output: 6

// Example 4:

// Input: nums = [8,10,2]
// Output: 10

// Example 5:

// Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
// Output: 127

 

// Constraints:

//     1 <= nums.length <= 2 * 104
//     0 <= nums[i] <= 231 - 1


//Solution:
class Solution {
    public int findMaximumXOR(int[] nums) {
        HashSet<Integer> se= new HashSet<>();
        int ans=0, mask=0; 
        
        for (int i=30; i>=0; i--) { 
            
            mask |= (1 << i);
            
            for (int j=0; j<nums.length; j++) {  
                se.add(nums[j] & mask); 
            } 
            
            int temp=ans | (1 << i); 
            
            for (int s:se) { 
                if (se.contains(temp ^ s)) { 
                    ans = temp; 
                    break; 
                } 
            } 
            se.clear(); 
        } 
  
        return ans;
    }
}
//Complexity: O(n)

