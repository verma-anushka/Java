
//Day 17: 
//Problem Statement: 4Sum II

// Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

// To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

// Example:

// Input:
// A = [ 1, 2]
// B = [-2,-1]
// C = [-1, 2]
// D = [ 0, 2]

// Output:
// 2

// Explanation:
// The two tuples are:
// 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
// 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0

//Solution:
class Solution {
    public int fourSumCount(int[] a, int[] b, int[] c, int[] d) {

        int ans=0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        
        for(int i=0; i<a.length; i++) {
            for(int j=0; j<b.length; j++) {
                int sum=a[i]+b[j];
                if(!mp.containsKey(sum))
                    mp.put(sum, 1);
                else
                    mp.put(sum, mp.get(sum)+1);
            }
        }
        
        for(int i=0; i<c.length; i++) {
            for(int j=0; j<d.length; j++) {
                if(mp.containsKey(-c[i]-d[j]))
                    ans+=mp.get(-c[i]-d[j]);
            }
        }
        
        return ans;
    }
}
//Complexity: O(n)

