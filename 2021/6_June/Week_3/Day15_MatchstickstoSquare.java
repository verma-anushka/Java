
//Day 15: 
//Problem Statement: Matchsticks to Square

// You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

// Return true if you can make this square and false otherwise.

 

// Example 1:


// Input: matchsticks = [1,1,2,2,2]
// Output: true
// Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
// Example 2:

// Input: matchsticks = [3,3,3,3,4]
// Output: false
// Explanation: You cannot find a way to form a square with all the matchsticks.
 

// Constraints:

// 1 <= matchsticks.length <= 15
// 1 <= matchsticks[i] <= 108

//Solution:
class Solution {
    
    public boolean makesquareBacktrack(int[] matchsticks, boolean []visited, int target, int curr, int i, int k) {
        if(k==1)
            return true;
        if(curr==target)
            return makesquareBacktrack(matchsticks, visited, target, 0, 0, k-1);

        for(int j=i; j<matchsticks.length; j++) {
            if(visited[j] || curr+matchsticks[j]>target) 
                continue;
            
            visited[j]=true;
            if(makesquareBacktrack(matchsticks, visited, target, curr+matchsticks[j], j+1, k)) 
                return true;
                
            visited[j]=false;
        }
        return false;
    }
    
    
    public boolean makesquare(int[] nums) {
        
        int sum=0;
        for(int num: nums)
            sum+=num;
        
        if(nums.length<4 || sum%4!=0) return false;
        boolean []visited=new boolean[nums.length];
        return makesquareBacktrack(nums, visited, sum/4, 0, 0, 4);
    }
}
//Complexity: O(n*n)

