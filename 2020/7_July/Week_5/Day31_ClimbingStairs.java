
//Day 31: 
//Problem Link: https://leetcode.com/explore/featured/card/july-leetcoding-challenge/548/week-5-july-29th-july-31st/3407/
//Problem Statement: Climbing Stairs

// You are climbing a stair case. It takes n steps to reach to the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

// Example 1:

// Input: 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps
// Example 2:

// Input: 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step
 

// Constraints:

// 1 <= n <= 45

//Solution:
class Solution {
    public int climbStairs(int n) {
        
        if (n == 1) return 1;
        
        int a=1, b=2;
        for (int i=3; i<=n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
//Complexity: O(n)

