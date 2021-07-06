
//Day 5: 
//Problem Statement: Reshape the Matrix

// In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.

// You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.

// The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.

// If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

 

// Example 1:


// Input: mat = [[1,2],[3,4]], r = 1, c = 4
// Output: [[1,2,3,4]]
// Example 2:


// Input: mat = [[1,2],[3,4]], r = 2, c = 4
// Output: [[1,2],[3,4]]
 

// Constraints:

// m == mat.length
// n == mat[i].length
// 1 <= m, n <= 100
// -1000 <= mat[i][j] <= 1000
// 1 <= r, c <= 300

//Solution #1:
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
               
        int m=mat.length, n=mat[0].length, mn=m*n;
        if(r*c!=mn) return mat;
        
        int[][] ans=new int[r][c];
        // vector<vector<int>> ans(r, vector<int>(c));
        for(int i=0; i<mn; i++) {
            ans[i/c][i%c] = mat[i/n][i%n];
        }
        
        return ans;
    }
}
//Complexity: O(m*n)

//Solution #2:
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        
        int m=mat.length, n=mat[0].length, mn=m*n;
        if(r*c!=mn) return mat;
        
        int[][] ans=new int[r][c];
        for(int j=0; j<n; j++) {
            for(int i=0; i<m; i++) {
                int row=(n*i+j)/c;
                int col=(n*i+j)%c;
                ans[row][col]=mat[i][j];                
            }
        }
        
        return ans;
    }
}
//Complexity: O(m*n)

