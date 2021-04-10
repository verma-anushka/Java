
//Day 10: 
//Problem Statement: Longest Increasing Path in a Matrix

// Given an m x n integers matrix, return the length of the longest increasing path in matrix.

// From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

 

// Example 1:


// Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
// Output: 4
// Explanation: The longest increasing path is [1, 2, 6, 9].
// Example 2:


// Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
// Output: 4
// Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
// Example 3:

// Input: matrix = [[1]]
// Output: 1
 

// Constraints:

// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 200
// 0 <= matrix[i][j] <= 231 - 1

//Solution:
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int ylen=matrix.length, xlen=matrix[0].length, ans=0;
        int[][] memo=new int[ylen][xlen];
        for(int i=0; i<ylen; i++)
            for(int j=0; j<xlen; j++)
                ans= Math.max(ans, dfs(i, j, matrix, memo));
        
        return ans;
    }
    
    public int dfs(int y, int x, int[][] matrix, int[][] memo) {
        if(memo[y][x]>0) return memo[y][x];
        int val=matrix[y][x];
        memo[y][x]=1+Math.max(
            Math.max(y<matrix.length-1 && matrix[y+1][x]<val ? dfs(y+1, x, matrix, memo): 0,
                     y>0 && matrix[y-1][x]<val ? dfs(y-1, x, matrix, memo): 0),
            Math.max(x<matrix[0].length-1 && matrix[y][x+1]<val ? dfs(y, x+1, matrix, memo): 0,
                     x>0 && matrix[y][x-1] < val ? dfs(y, x-1, matrix, memo): 0));
        return memo[y][x];
    }
}
//Complexity: O(n*m)

