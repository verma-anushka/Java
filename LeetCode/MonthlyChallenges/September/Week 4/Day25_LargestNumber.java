
//Day 25: 
//Problem Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3472/
//Problem Statement: Largest Number
// Given a list of non-negative integers nums, arrange them such that they form the largest number.

// Note: The result may be very large, so you need to return a string instead of an integer.

 

// Example 1:

// Input: nums = [10,2]
// Output: "210"

// Example 2:

// Input: nums = [3,30,34,5,9]
// Output: "9534330"

// Example 3:

// Input: nums = [1]
// Output: "1"

// Example 4:

// Input: nums = [10]
// Output: "10"

 

// Constraints:

//     1 <= nums.length <= 100
//     0 <= nums[i] <= 109



//Solution:
class Solution {
    public String largestNumber(int[] nums) {
        
        String ans="";
        ArrayList<String> strnums = new ArrayList<String>();
        for (int num: nums)
            strnums.add(Integer.toString(num));
        
        Collections.sort(strnums, Collections.reverseOrder());
        // reverse(strnums.begin(), strnums.end());
        
        boolean flag = false;
        while (!flag) {
            int i=0;            
            flag=true;
            
            while (i<strnums.size()-1) {
                if ( (strnums.get(i)+strnums.get(i+1)).compareTo(strnums.get(i+1)+strnums.get(i)) < 0 ) {
                    
                    Collections.swap(strnums, i, i+1);
                    flag=false;
                }
                i++;
            }
        }
        
        for (String num: strnums) ans += num;
        if (ans.charAt(0) == '0') return "0";
        return ans; 
  
    }
}
//Complexity: O(n*logn)

