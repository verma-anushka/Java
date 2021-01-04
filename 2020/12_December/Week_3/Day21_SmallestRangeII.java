
//Day 21: 
//Problem Statement: Smallest Range II

// Given an array A of integers, for each integer A[i] we need to choose either x = -K or x = K, and add x to A[i] (only once).

// After this process, we have some array B.

// Return the smallest possible difference between the maximum value of B and the minimum value of B.

 

// Example 1:

// Input: A = [1], K = 0
// Output: 0
// Explanation: B = [1]
// Example 2:

// Input: A = [0,10], K = 2
// Output: 6
// Explanation: B = [2,8]
// Example 3:

// Input: A = [1,3,6], K = 3
// Output: 3
// Explanation: B = [4,6,3]
 

// Note:

// 1 <= A.length <= 10000
// 0 <= A[i] <= 10000
// 0 <= K <= 10000

//Solution:
class Solution {
    public int smallestRangeII(int[] a, int k) {
        
        Arrays.sort(a);
        
        int maxnum=a[a.length-1], minnum=a[0], ans=maxnum-minnum;
        
        for(int i=0; i<a.length-1; i++) {
            maxnum = Math.max(maxnum, a[i]+2*k);
            minnum = Math.min(a[i+1], a[0]+2*k);
            ans = Math.min(ans, maxnum-minnum);
        }
        
        return ans;
        
    }
}
//Complexity: O(n*logn)

