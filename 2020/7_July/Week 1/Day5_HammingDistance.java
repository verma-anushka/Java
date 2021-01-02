
//Day 5: 
//Problem Link: https://leetcode.com/explore/featured/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3381/
//Problem Statement: Hamming Distance

// The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

// Given two integers x and y, calculate the Hamming distance.

// Note:
// 0 ≤ x, y < 231.

// Example:

// Input: x = 1, y = 4

// Output: 2

// Explanation:
// 1   (0 0 0 1)
// 4   (0 1 0 0)
//        ↑   ↑

// The above arrows point to positions where the corresponding bits are different.

//Solution:
class Solution {
    public int hammingDistance(int x, int y) {
        int ans=0;
        while(x>0 || y>0) {
            ans += (x%2) ^ (y%2);
            x >>= 1; y >>= 1;
        }
        return ans;
    }
}

//Complexity: O(n)

