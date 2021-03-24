//Day 24: 
//Problem Statement: Advantage Shuffle

// Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].

// Return any permutation of A that maximizes its advantage with respect to B.

 

// Example 1:

// Input: A = [2,7,11,15], B = [1,10,4,11]
// Output: [2,11,7,15]
// Example 2:

// Input: A = [12,24,8,32], B = [13,25,32,11]
// Output: [24,32,8,12]
 

// Note:

// 1 <= A.length = B.length <= 10000
// 0 <= A[i] <= 10^9
// 0 <= B[i] <= 10^9

//Solution:
class Solution {
    public int[] advantageCount(int[] a, int[] b) {
        
        int[] ans=new int[a.length];
        Arrays.sort(a);
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((x, y) -> y[1]-x[1]);
        
        for(int i=0; i<b.length; i++) {
            pq.offer(new int[]{i, b[i]});
        }
        
        int slow=0, fast=a.length-1;
        
        while(!pq.isEmpty()) {
            int[] top=pq.poll();
            ans[top[0]] = top[1]>=a[fast] ? a[slow++]: a[fast--];
        }
        
        return ans;
    
    }
}
//Complexity: O(n*logn)

