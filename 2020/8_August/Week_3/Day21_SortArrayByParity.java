
//Day 21: 
//Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3431/
//Problem Statement: Sort Array By Parity

// Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

// You may return any answer array that satisfies this condition.

// Example 1:

// Input: [3,1,2,4]
// Output: [2,4,3,1]
// The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

// Note:

// 1 <= A.length <= 5000
// 0 <= A[i] <= 5000

//Solution:
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] ans = new int[A.length];
        int k = A.length - 1;
        int i = 0;
        for (int a : A) {
            if (a % 2 == 0) {
                ans[i++] = a;
            } else
                ans[k--] = a;
        }
        return ans;
    }
}
// Complexity: O(n)
