
//Day 14: 
//Problem Statement: Minimum Operations to Reduce X to Zero

// You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.

// Return the minimum number of operations to reduce x to exactly 0 if it's possible, otherwise, return -1.

 

// Example 1:

// Input: nums = [1,1,4,2,3], x = 5
// Output: 2
// Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
// Example 2:

// Input: nums = [5,6,7,8,9], x = 4
// Output: -1
// Example 3:

// Input: nums = [3,2,20,1,1,3], x = 10
// Output: 5
// Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 

// Constraints:

// 1 <= nums.length <= 105
// 1 <= nums[i] <= 104
// 1 <= x <= 109

//Solution:
class Solution {
    
    public int minOperations(int []nums, int x) {
        int sum=0;
        if((nums[0]>x) && (nums[nums.length-1]>x))
            return -1;
        for(int num: nums)
            sum+=num;
        if(sum==x) return nums.length;
        int temp=findMaxSub(nums, sum-x);
        return temp<=0 ? -1: nums.length-temp;
    }
    
    public int findMaxSub(int []nums, int k) {
        int sum=0, ans=0;
        HashMap<Integer, Integer> mp=new HashMap<>();
        // unordered_map<int, int> mp;
        for(int i=0; i<nums.length; i++) {

            sum+=nums[i];
            
            if(sum==k)
                ans=i+1;
            
            if(!mp.containsKey(sum))
                mp.put(sum, i);

            if(mp.containsKey(sum-k))
                ans=Math.max(ans, i-mp.get(sum-k));
        }
        return ans;
    }
}

//Complexity: O(n)

