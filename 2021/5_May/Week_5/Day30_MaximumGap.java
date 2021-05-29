
//Day 30: 
//Problem Statement: Maximum Gap

// Given an integer array nums, return the maximum difference between two successive elements in its sorted form. If the array contains less than two elements, return 0.

// You must write an algorithm that runs in linear time and uses linear extra space.

 

// Example 1:

// Input: nums = [3,6,9,1]
// Output: 3
// Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.
// Example 2:

// Input: nums = [10]
// Output: 0
// Explanation: The array contains less than 2 elements, therefore return 0.
 

// Constraints:

// 1 <= nums.length <= 105
// 0 <= nums[i] <= 109

//Solution: 
class Solution {
    public int maximumGap(int[] nums) {
        
        if(nums.length<2) return 0;
        
        int high=0, low=Integer.MAX_VALUE, ans=0;
        for(int n: nums) {
            high=Math.max(high, n); 
            low=Math.min(low, n);            
        }
        
        int bsize=Math.max((high-low)/(nums.length-1), 1);
        List<List<Integer>> buckets=new ArrayList<>();
        
        for(int i=(high-low)/bsize; i>=0; i--) {
            buckets.add(new ArrayList<>());            
        }
        
        for(int n: nums) {
            buckets.get((n-low)/bsize).add(n);            
        }
        
        int currhigh=0;
        for(List<Integer> b: buckets) {
            if(b.isEmpty()) continue;
            int prevhigh=currhigh>0 ? currhigh: b.get(0), currlow=b.get(0);
            for(int n: b) {
                currhigh=Math.max(currhigh, n); 
                currlow=Math.min(currlow, n);                
            }
            
            ans=Math.max(ans, currlow-prevhigh);
        }
        
        return ans;
    }
}
//Complexity: O(n^2)

