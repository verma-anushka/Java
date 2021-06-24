//Day 24: 
//Problem Statement: Out of Boundary Paths

// There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.

// Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.

 

// Example 1:


// Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
// Output: 6
// Example 2:


// Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
// Output: 12
 

// Constraints:

// 1 <= m, n <= 50
// 0 <= maxMove <= 50
// 0 <= startRow < m
// 0 <= startColumn < n

//Solution:
class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        if(maxMove==0) return 0;
        int[][] dpcurr=new int[m+2][n+2], dplast=new int[m+2][n+2];
        
        for(int i=1; i<=m; i++) {
            dpcurr[i][1]++;
            dpcurr[i][n]++;
        }
        
        for(int j=1; j<=n; j++) {
            dpcurr[1][j]++;
            dpcurr[m][j]++;
        }
        
        int ans=dpcurr[startRow+1][startColumn+1];
        
        for(int k=1; k<maxMove; k++) {
            int[][] temp=dpcurr;
            dpcurr=dplast;
            dplast=temp;
            
            for(int i=1; i<=m; i++) {
                for(int j=1; j<=n; j++) {
                    dpcurr[i][j]=(int) (((long)dplast[i-1][j] + dplast[i+1][j] + dplast[i][j-1] + dplast[i][j+1]) % 1000000007L);
                }
            }
            ans=(ans+dpcurr[startRow+1][startColumn+1]) % 1000000007;
        }
        
        return ans;
    
    }
}
//Complexity: O(m*n)

