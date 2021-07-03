
//Day 3: 
//Problem Statement: Max Sum of Rectangle No Larger Than K

// Given an m x n matrix matrix and an integer k, return the max sum of a rectangle in the matrix such that its sum is no larger than k.

// It is guaranteed that there will be a rectangle with a sum no larger than k.

 

// Example 1:


// Input: matrix = [[1,0,1],[0,-2,3]], k = 2
// Output: 2
// Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2, and 2 is the max number no larger than k (k = 2).
// Example 2:

// Input: matrix = [[2,2,-1]], k = 3
// Output: 3
 

// Constraints:

// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -100 <= matrix[i][j] <= 100
// -105 <= k <= 105
 

// Follow up: What if the number of rows is much larger than the number of columns?


//Solution:
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        
        int ans=Integer.MIN_VALUE;

        for(int i=0; i<matrix[0].length; i++) {
            
            int[] sums=new int[matrix.length];
            
            for(int m=i; m<matrix[0].length; m++) {
                for(int j=0; j<matrix.length; j++) {
                    sums[j]+=matrix[j][m];
                    if(sums[j]==k) 
                        return k;  
                    if(sums[j]<k) 
                        ans=Math.max(ans, sums[j]);
                }
                
                for(int j=0; j<matrix.length; j++) {
                    int prefixSum=0;
                    for(int n=j; n<matrix.length; n++) {
                        prefixSum+=sums[n];
                        if(prefixSum==k) 
                            return k;
                        if(prefixSum<k) 
                            ans=Math.max(ans, prefixSum);
                    }
                }
            }
        }
        
        return ans;
        
    }
}
//Complexity: O(m*nlogn)
