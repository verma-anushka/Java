
//Day 30: 
//Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/553/week-5-august-29th-august-31st/3442/
//Problem Statement: Largest Component Size by Common Factor

// Given a non-empty array of unique positive integers A, consider the following graph:

// There are A.length nodes, labelled A[0] to A[A.length - 1];
// There is an edge between A[i] and A[j] if and only if A[i] and A[j] share a common factor greater than 1.
// Return the size of the largest connected component in the graph.

// Example 1:

// Input: [4,6,15,35]
// Output: 4

// Example 2:

// Input: [20,50,9,63]
// Output: 2

// Example 3:

// Input: [2,3,6,7,4,12,21,39]
// Output: 8

// Note:

// 1 <= A.length <= 20000
// 1 <= A[i] <= 100000

//Solution:
class Solution {

    public void getUnion(int[] parent, int i, int j) {
        int pi = find(parent, i);
        int pj = find(parent, j);
        if (pi != pj)
            parent[pj] = pi;
    }

    public int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        parent[i] = find(parent, parent[i]);
        return parent[i];
    }

    public int largestComponentSize(int[] a) {

        int ans = 0;
        int[] parent = new int[100001];

        for (int i = 0; i < 100001; i++)
            parent[i] = -1;
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 2; j <= Math.sqrt(a[i]); j++) {
                if (a[i] % j == 0) {
                    getUnion(parent, j, a[i]);
                    getUnion(parent, a[i], a[i] / j);
                }
            }
        }

        for (int i = 0; i < a.length; i++) {

            int pi = find(parent, a[i]);
            ans = Math.max(ans, 1 + mp.getOrDefault(pi, 0));
            mp.put(pi, mp.getOrDefault(pi, 0) + 1);

        }

        return ans;
    }

}
// Complexity: O(n)
