
//Day 26: 
//Problem Statement: Count of Smaller Numbers After Self

// You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

 

// Example 1:

// Input: nums = [5,2,6,1]
// Output: [2,1,1,0]
// Explanation:
// To the right of 5 there are 2 smaller elements (2 and 1).
// To the right of 2 there is only 1 smaller element (1).
// To the right of 6 there is 1 smaller element (1).
// To the right of 1 there is 0 smaller element.
// Example 2:

// Input: nums = [-1]
// Output: [0]
// Example 3:

// Input: nums = [-1,-1]
// Output: [0,0]
 

// Constraints:

// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104

//Solution:
class Solution {
    
    public List<Integer> countSmaller(int[] nums) {
        
        List<Integer> ans=new ArrayList<Integer>();
        ArrayList<Integer> sorted=new ArrayList<Integer>();
 
        for(int i=nums.length-1; i>=0; i--) {
            
            if(sorted.isEmpty()) {
                sorted.add(nums[i]);
                ans.add(0);
            } else if(nums[i]>sorted.get(sorted.size()-1)) {
                sorted.add(sorted.size(), nums[i]);
                ans.add(sorted.size()-1);
            } else {
                int l=0, r=sorted.size()-1;

                while(l<r) {
                    
                    int m=l+(r-l)/2;
                    if(nums[i]>sorted.get(m))
                        l=m+1;
                    else
                        r=m;
                }

                sorted.add(r, nums[i]);
                ans.add(r);
            }    
        }

        Collections.reverse(ans);
        return ans;
    }
}
//Complexity: O(n^2*logn)

