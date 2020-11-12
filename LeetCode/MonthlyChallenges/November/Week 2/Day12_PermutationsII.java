
//Day 12: 
//Problem Statement: Permutations II

// Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

// Example 1:

// Input: nums = [1,1,2]
// Output:
// [[1,1,2],
//  [1,2,1],
//  [2,1,1]]
// Example 2:

// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

// Constraints:

// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10

//Solution:
class Solution {

    private void permuteUniqueUtil(Map<Integer, Integer> mp, Integer[] p, int i, List<List<Integer>> ans) {
        
        if(i==p.length)
            ans.add(Arrays.asList(Arrays.copyOf(p, p.length)));
        
        for(int key: mp.keySet()) {
            if(mp.get(key)>0) {
                mp.put(key, mp.get(key)-1);
                p[i]=key;
                permuteUniqueUtil(mp, p, i+1, ans);
                mp.put(key, mp.get(key)+1);
            }
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> ans=new ArrayList<>();
        Map<Integer, Integer> mp=new HashMap<>();
        
        for(int n: nums)
            mp.put(n, mp.getOrDefault(n, 0)+1);
        
        permuteUniqueUtil(mp, new Integer[nums.length], 0, ans);
        return ans;
    }

}
//Complexity: O(n*n!)

