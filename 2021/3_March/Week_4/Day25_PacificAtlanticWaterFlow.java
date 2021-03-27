
//Day 25: 
//Problem Statement: Pacific Atlantic Water Flow

// You are given an m x n integer matrix heights representing the height of each unit cell in a continent. The Pacific ocean touches the continent's left and top edges, and the Atlantic ocean touches the continent's right and bottom edges.

// Water can only flow in four directions: up, down, left, and right. Water flows from a cell to an adjacent one with an equal or lower height.

// Return a list of grid coordinates where water can flow to both the Pacific and Atlantic oceans.

 

// Example 1:


// Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
// Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
// Example 2:

// Input: heights = [[2,1],[1,2]]
// Output: [[0,0],[0,1],[1,0],[1,1]]
 

// Constraints:

// m == heights.length
// n == heights[i].length
// 1 <= m, n <= 200
// 1 <= heights[i][j] <= 105

//Solution:
class Solution {
    
    public void dfs(int i, int j, int w, int h, int[][] matrix, byte[] dp, List<List<Integer>> ans) {
        
        int m=matrix.length, n=matrix[0].length, ij=i*n+j;
        
        if((dp[ij] & w)>0 || matrix[i][j]<h) 
            return;
        
        dp[ij]+=w;        
        h=matrix[i][j];
        
        if(dp[ij]==3) 
            ans.add(Arrays.asList(i, j));
        
        if(i+1<m) dfs(i+1, j, w, h, matrix, dp, ans);
        if(i>0) dfs(i-1, j, w, h, matrix, dp, ans);
        if(j+1<n) dfs(i, j+1, w, h, matrix, dp, ans);
        if(j>0) dfs(i, j-1, w, h, matrix, dp, ans);
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        
        List<List<Integer>> ans=new ArrayList<>();
        if(matrix.length==0) 
            return ans;
        
        int m=matrix.length, n=matrix[0].length;
        
        byte[] dp=new byte[m*n];
        
        for(int i=0; i<n; i++) {
            dfs(0, i, 1, matrix[0][i], matrix, dp, ans);
            dfs(m-1, i, 2, matrix[m-1][i], matrix, dp, ans);
        }   
        
        for(int i=0; i<m; i++) {
            dfs(i, 0, 1, matrix[i][0], matrix, dp, ans);
            dfs(i, n-1, 2, matrix[i][n-1], matrix, dp, ans);
        }
        
        return ans;
    }
}
//Complexity: O(m*n)


