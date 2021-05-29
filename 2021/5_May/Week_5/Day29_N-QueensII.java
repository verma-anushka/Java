
//Day 29:
//Problem Statement: N-Queens II

// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

// Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 

// Example 1:


// Input: n = 4
// Output: 2
// Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
// Example 2:

// Input: n = 1
// Output: 1
 

// Constraints:

// 1 <= n <= 9

//Solution:
class Solution {
        
    int ans=0;
    
    public boolean isSafe(int [][]board, int row, int col, int n) {
        
        for(int r=0; r<n; r++) {
            if(board[r][col] == 1) return false;
        }
        
        int r=row, c=col;
        while(r>=0 && c>=0) {
            if(board[r][c] == 1) return false;
            r--; c--;
        }
        
        r=row; c=col;
        while(r>=0 && c<n) {
            if(board[r][c] == 1) return false;
            r--; c++;
        }
        return true;
    }
    
    public boolean nqueens(int [][]board, int row, int n) {
        
        if(row==n) {
            ans++;
            return false;
        }
        
        for(int col=0; col<n; col++) {
            if(isSafe(board, row, col, n)) {
                board[row][col] = 1;
                if(nqueens(board, row+1, n)) return true;
            }
            board[row][col]=0;
        }
        return false;
    }
    
    public int totalNQueens(int n) {
        int [][]board=new int[n][n];
        nqueens(board, 0, n);
        return ans;
    }
}
//Complexity: O(n*n)
