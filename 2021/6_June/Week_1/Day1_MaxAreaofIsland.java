
//Day 1:
//Problem Statement: Max Area of Island

// You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

// The area of an island is the number of cells with a value 1 in the island.

// Return the maximum area of an island in grid. If there is no island, return 0.

 

// Example 1:


// Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
// Output: 6
// Explanation: The answer is not 11, because the island must be connected 4-directionally.
// Example 2:

// Input: grid = [[0,0,0,0,0,0,0,0]]
// Output: 0
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 50
// grid[i][j] is either 0 or 1.


//Solution:
class Solution {
    private int n, m;
    
    private int dfs(int i, int j, int[][] grid) {
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]<1) return 0;
        grid[i][j]=0;
        return 1 + dfs(i-1, j, grid) + dfs(i, j-1, grid) + dfs(i+1, j, grid) + dfs(i, j+1, grid);
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int ans=0;
        n=grid.length;
        m=grid[0].length;
        
        for(int i=0; i<n; i++) { 
            for(int j=0; j<m; j++) {
                if(grid[i][j]>0) 
                    ans=Math.max(ans, dfs(i, j, grid));
            }
        }
        
        return ans;
    }
}
//Complexity: O(n*m)

