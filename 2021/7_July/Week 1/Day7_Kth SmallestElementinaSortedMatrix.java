
//Day 7: 
//Problem Statement: Kth Smallest Element in a Sorted Matrix

// Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest element in the matrix.

// Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 

// Example 1:

// Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
// Output: 13
// Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
// Example 2:

// Input: matrix = [[-5]], k = 1
// Output: -5
 

// Constraints:

// n == matrix.length
// n == matrix[i].length
// 1 <= n <= 300
// -109 <= matrix[i][j] <= 109
// All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
// 1 <= k <= n2


//Solution:
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m=matrix.length, n=matrix[0].length; 
        int left=matrix[0][0], right=matrix[m-1][n-1], ans=-1;
        
        while(left<=right) {
            int mid=(left+right)/2;
            if(countSmallerOrEqual(matrix, mid, m, n)>=k) {
                ans=mid;
                right=mid-1;
            } else left=mid+1;
        }
        return ans;
    }
    
    public int countSmallerOrEqual(int[][] matrix, int x, int m, int n) {
        int count=0, c=n-1;
        for(int r=0; r<m; r++) {
            while(c>=0 && matrix[r][c]>x) c--;
            count+=c+1;
        }
        return count;
    }

}
//Complexity: O((m+n))

