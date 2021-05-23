
//Day 22: 
//Problem Statement: N-Queens

// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

// Example 1:


// Input: n = 4
// Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
// Example 2:

// Input: n = 1
// Output: [["Q"]]
 

// Constraints:

// 1 <= n <= 9

//Solution:
class Solution {
    
    List<List<String>> ans=new ArrayList<>();
    
    public boolean isSafe(int [][] board, int row, int col, int n) {
        for(int r=0; r<n; r++) {
            if(board[r][col]==1) return false;
        }
        
        int r=row, c=col;
        while(r>=0 && c>=0) {
            if(board[r][c]==1) return false;
            r--; c--;
        }
        
        r=row; c=col;
        while(r>=0 && c<n) {
            if(board[r][c]==1) return false;
            r--; c++;
        }
        
        return true;
    }
    
    public boolean NQueens(int [][] board, int row, int n) {
        
        if(row==n) {
        
            List<String> v=new ArrayList<>();
            for(int i=0; i<n; i++) {
                String s="";
                for(int j=0; j<n; j++) {
                    if(board[i][j]==1) s+="Q";
                    else s+=".";
                }
                v.add(s);
            }
            ans.add(v);
            
            return false;
        }
        
        for(int col=0; col<n; col++) {
            if(isSafe(board, row, col, n)) {
                board[row][col]=1;
                if(NQueens(board, row+1, n)) return true;
            }
            board[row][col]=0;

        }
        return false;
    }
    
    public List<List<String>> solveNQueens(int n) {
        
        int [][]board=new int[n][n];
        // List<List<Integer>> board=new List<Integer>();
        NQueens(board, 0, n);
        return ans;
    
    }
}
//Complexity: O(n*n)

