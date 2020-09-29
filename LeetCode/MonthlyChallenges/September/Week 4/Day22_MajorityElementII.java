
//Day 22: 
//Problem Link: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3337/
//Problem Statement: Majority Element II

// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

// Follow-up: Could you solve the problem in linear time and in O(1) space?

// Example 1:

// Input: nums = [3,2,3]
// Output: [3]

// Example 2:

// Input: nums = [1]
// Output: [1]

// Example 3:

// Input: nums = [1,2]
// Output: [1,2]

 

// Constraints:

//     1 <= nums.length <= 5 * 104
//     -109 <= nums[i] <= 109


//Solution:
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> ans=new ArrayList<>();
        Map<Integer, Integer> mp=new HashMap<>();
        for(int num: nums) {
            mp.put(num, mp.getOrDefault(num, 0)+1);
        }
        for(Map.Entry<Integer, Integer> m: mp.entrySet()) {            
            if(m.getValue() > Math.floor(nums.length/3)) {
                ans.add(m.getKey());
            }
        }
        return ans;
    }
}
//Complexity: O(n)

