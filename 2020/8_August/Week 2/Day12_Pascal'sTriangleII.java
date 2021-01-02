
//Day 12: 
//Problem Link: https://leetcode.com/explore/featured/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3421/
//Problem Statement: Pascal's Triangle II

// Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

// Note that the row index starts from 0.


// In Pascal's triangle, each number is the sum of the two numbers directly above it.

// Example:

// Input: 3
// Output: [1,3,3,1]
// Follow up:

// Could you optimize your algorithm to use only O(k) extra space?

//Solution #1:
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> r = new ArrayList<>(rowIndex+1);
        for(int i=0; i<=rowIndex; i++) r.add(1);
        if (rowIndex == 0) return r;
        
        List<Integer> rmo = getRow(rowIndex-1);        
        for (int i=1; i<rowIndex; i++)
            r.set(i, rmo.get(i-1) + rmo.get(i));
        
        return r;
    }
}
//Complexity: O(n*2)

