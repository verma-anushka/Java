
//Day 11: 
//Problem Link: https://leetcode.com/explore/featured/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3387/
//Problem Statement: Subsets

// Given a set of distinct integers, nums, return all possible subsets (the power set).

// Note: The solution set must not contain duplicate subsets.

// Example:

// Input: nums = [1,2,3]
// Output:
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]

//Solution:
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());
        
        for(int i=0; i<nums.length; i++) {
            int size = ans.size();
            // cout << size << endl;
            for(int j=0; j<size; j++) {
                List<Integer> temp = new ArrayList<Integer>(ans.get(j));                
                temp.add(nums[i]);
                ans.add(temp);
            }
        }
        
        return ans;
    }
}
//Complexity: O(n^2)

