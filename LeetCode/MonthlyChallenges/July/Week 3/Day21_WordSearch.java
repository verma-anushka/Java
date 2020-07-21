
//Day 21: 
//Problem Link: https://leetcode.com/explore/featured/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3397/
//Problem Statement: Word Search

// Given a 2D board and a word, find if the word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

// Example:

// board =
// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]

// Given word = "ABCCED", return true.
// Given word = "SEE", return true.
// Given word = "ABCB", return false.
 

// Constraints:

// board and word consists only of lowercase and uppercase English letters.
// 1 <= board.length <= 200
// 1 <= board[i].length <= 200
// 1 <= word.length <= 10^3

//Solution:
class Solution {
    
    public boolean wordsearch(char[][] board, int i, int j, String word, int idx) {

        if(idx==word.length()) return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] != word.charAt(idx))
            return false;
        
        char temp = board[i][j];
        board[i][j] = '*';
        
        boolean found = wordsearch(board, i+1, j, word, idx+1) || 
                     wordsearch(board, i-1, j, word, idx+1) || 
                     wordsearch(board, i, j+1, word, idx+1) || 
                     wordsearch(board, i, j-1, word, idx+1);

        board[i][j] = temp;
        return found;
    }
    
    public boolean exist(char[][] board, String word) {
        int m=board.length; if(m==0) return false;
        int n=board[0].length; if(n==0) return false;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == word.charAt(0)) 
                    if(wordsearch(board, i, j, word, 0)) 
                        return true;
            }
        }
        return false;
    }
}
//Complexity: O(2^n)
