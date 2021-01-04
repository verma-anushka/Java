
//Day 27: 
//Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3438/
//Problem Statement: Find Right Interval

// Given an array of intervals where intervals[i] = [starti, endi]. For each interval i, check if there exists an interval j where startj >= endi, which can be called that interval j is on the right of interval i.

// For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "on the right of" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you should return the stored value of each interval as an array.

// NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

// Example 1:

// Input: intervals = [[1,2]]
// Output: [-1]
// Explanation: There is only one interval in the collection, so it outputs -1.
// Example 2:

// Input: intervals = [[3,4],[2,3],[1,2]]
// Output: [-1,0,1]
// Explanation: There is no satisfied "right" interval for [3,4].
// For [2,3], the interval [3,4] has minimum-"right" start point;
// For [1,2], the interval [2,3] has minimum-"right" start point.
// Example 3:

// Input: intervals = [[1,4],[2,3],[3,4]]
// Output: [-1,2,-1]
// Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
// For [2,3], the interval [3,4] has minimum-"right" start point.

// Constraints:

// 1 <= intervals.length <= 2 * 104
// intervals[i].length == 2
// -106 <= starti <= endi <= 106
// The start points of each interval is unique.

//Solution:
class Solution {

    public int binary_search(List<Pair<Pair<Integer, Integer>, Integer>> v, int num) {

        if (v.get(v.size() - 1).getKey().getKey() < num)
            return -1;

        int l = 0, r = v.size() - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (v.get(mid).getKey().getKey() >= num)
                r = mid - 1;
            else
                l = mid + 1;
        }

        return v.get(l).getValue();

    }

    public int[] findRightInterval(int[][] intervals) {

        int[] ans = new int[intervals.length];

        List<Pair<Pair<Integer, Integer>, Integer>> v = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            v.add(new Pair(new Pair(intervals[i][0], intervals[i][1]), i));
        }

        Collections.sort(v, (a, b) -> a.getKey().getKey() - b.getKey().getKey());

        for (int i = 0; i < intervals.length; i++) {
            ans[i] = binary_search(v, intervals[i][1]);
        }

        return ans;
    }
}
// Complexity: O(n*logn)
