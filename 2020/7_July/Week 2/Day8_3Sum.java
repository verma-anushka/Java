
//Day 8: 
//Problem Link: https://leetcode.com/explore/featured/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3384/
//Problem Statement: Power of Two

// Given an integer, write a function to determine if it is a power of two.

// Example 1:

// Input: 1
// Output: true 
// Explanation: 20 = 1
// Example 2:

// Input: 16
// Output: true
// Explanation: 24 = 16
// Example 3:

// Input: 218
// Output: false

//Solution:
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(nums.length<2) return ans;

        Arrays.sort(nums);
        
        for(int i=0; i<nums.length-2; i++) {
            
            if(i==0 || (i>0 && nums[i] != nums[i-1])) {
            
                int si=i+1, ei=nums.length-1;
                int sum = 0-nums[i];
        
                while(si<ei) {
                    if((nums[si] + nums[ei]) == sum) {
                        
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[si]);
                        temp.add(nums[ei]);
                        
//                         for(int j=0; j<temp.size(); j++) {
//                             System.out.println(temp.get(j));
//                         }
                        ans.add(temp);
                        
                        // for(int j=0; j<ans.size(); j++) {
                        //     for(int k=0; k<ans.get(j).size(); k++) {
                        //         System.out.println(ans.get(j).get(k));
                        //     }
                        // }

                        while(si<ei && nums[si] == nums[si+1]) si++;
                        while(si<ei && nums[ei] == nums[ei-1]) ei--;
                        si++; ei--;

                    } 
                    else if(nums[si] + nums[ei] < sum) si++;
                    else ei--;
                }
            }
        }
        return ans;
    }
}

//Complexity: O(n^2)

