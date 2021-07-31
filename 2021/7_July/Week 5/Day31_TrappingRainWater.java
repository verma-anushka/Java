
//Day 30: 
//Problem Statement: Trapping Rain Water

// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

// Example 1:


// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
// Example 2:

// Input: height = [4,2,0,3,2,5]
// Output: 9
 

// Constraints:

// n == height.length
// 0 <= n <= 3 * 104
// 0 <= height[i] <= 105

//Solution:
class Solution {
    public int trap(int[] height) {
        int size=height.length;
        if(size==0) return 0;
        
        int lmax=height[0], rmax=height[size-1];
        int l=1, r=size-2, ans=0;
        
        while(l<=r) {
            if(lmax<rmax) {
                if(height[l]<lmax) ans+=lmax-height[l++];
                else lmax=height[l++];
            } else {
                if(height[r]<rmax) ans+=rmax-height[r--];
                else rmax=height[r--];
            }
        }
        
        return ans;
    }
}
//Complexity: O(n)

