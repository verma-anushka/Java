
//Day 18: 
//Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3428/
//Problem Statement: Numbers With Same Consecutive Differences

// Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.

// Note that every number in the answer must not have leading zeros except for the number 0 itself. For example, 01 has one leading zero and is invalid, but 0 is valid.

// You may return the answer in any order.

// Example 1:

// Input: N = 3, K = 7
// Output: [181,292,707,818,929]
// Explanation: Note that 070 is not a valid number, because it has leading zeroes.
// Example 2:

// Input: N = 2, K = 1
// Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]

// Note:

// 1 <= N <= 9
// 0 <= K <= 9

//Solution:
class Solution {

    public void numsSameConsecDiffUtil(int num, int n, int k, List<Integer> ans) {

        if (n == 0) {
            ans.add(num);
            return;
        }

        int last = num % 10;
        if (last >= k)
            numsSameConsecDiffUtil(num * 10 + last - k, n - 1, k, ans);
        if (k > 0 && last + k < 10)
            numsSameConsecDiffUtil(num * 10 + last + k, n - 1, k, ans);

    }

    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ans = new ArrayList<>();
        if (n == 1)
            ans.add(0);
        for (int i = 1; i < 10; i++) {
            numsSameConsecDiffUtil(i, n - 1, k, ans);
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
// Complexity: O()
