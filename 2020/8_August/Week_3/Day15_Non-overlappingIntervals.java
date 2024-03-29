
//Day 15: 
//Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3425/
//Problem Statement: Non-overlapping Intervals

// Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

// Example 1:

// Input: [[1,2],[2,3],[3,4],[1,3]]
// Output: 1
// Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
// Example 2:

// Input: [[1,2],[1,2],[1,2]]
// Output: 2
// Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
// Example 3:

// Input: [[1,2],[2,3]]
// Output: 0
// Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

// Note:

// You may assume the interval's end point is always bigger than its start point.
// Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.

// Solution:
class Solution {
    public int eraseOverlapIntervals(int[][] arr) {

        int ans = 0, prev = 0;
        Arrays.sort(arr, (a, b) -> (a[0] - b[0]));

        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] >= arr[prev][1]) {
                prev = i;
            } else {
                ans++;
                if (arr[i][1] < arr[prev][1])
                    prev = i;
            }
        }

        return ans;
    }
}
// Complexity: O(logn)
