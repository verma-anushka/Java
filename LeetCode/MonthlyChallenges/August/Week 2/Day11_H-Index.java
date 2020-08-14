
//Day 11: 
//Problem Link: https://leetcode.com/explore/featured/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3420/
//Problem Statement: H-Index

// Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

// According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

// Example:

// Input: citations = [3,0,6,1,5]
// Output: 3 
// Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had 
//              received 3, 0, 6, 1, 5 citations respectively. 
//              Since the researcher has 3 papers with at least 3 citations each and the remaining 
//              two with no more than 3 citations each, her h-index is 3.
// Note: If there are several possible values for h, the maximum one is taken as the h-index.

//Solution #1:
class Solution {
    public int hIndex(int[] cs) {
        
        int size = cs.length;
        
        int []buckets = new int[size+1];
        
        for (int c:cs) buckets[Math.min(size, c)]++;
        
        int ans=0;
        for (int i=size; i>=0; i--) {
            ans+=buckets[i];
            if (ans>=i) return i;
        }
        return 0;
    }
}
//Complexity: O(n)
