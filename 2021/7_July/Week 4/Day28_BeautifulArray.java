
//Day 28: 
//Problem Statement: Beautiful Array

// An array nums of length n is beautiful if:

// nums is a permutation of the integers in the range [1, n].
// For every 0 <= i < j < n, there is no index k with i < k < j where 2 * nums[k] == nums[i] + nums[j].
// Given the integer n, return any beautiful array nums of length n. There will be at least one valid answer for the given n.

 

// Example 1:

// Input: n = 4
// Output: [2,1,4,3]
// Example 2:

// Input: n = 5
// Output: [3,1,2,5,4]
 

// Constraints:

// 1 <= n <= 1000

//Solution:
class Solution {
    public int[] beautifulArray(int n) {
        
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(1);
    
        while(ans.size()<n) {
        
            ArrayList<Integer> curr=new ArrayList<>();
            // for(int num: ans) {
            //     if(num*2<=n)
            //         curr.push_back(num*2);
            // }
            
            for(int num: ans) {
                if(num*2-1<=n)
                    curr.add(num*2-1);
            }

            for(int num: ans) {
                if(num*2<=n)
                    curr.add(num*2);
            }            
            
            ans=curr;
        }
        
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
//Complexity: O(n)

