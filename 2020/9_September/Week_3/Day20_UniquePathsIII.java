
//Day 20: 
//Problem Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3466/
//Problem Statement: Unique Paths III

// On a 2-dimensional grid, there are 4 types of squares:

//     1 represents the starting square.  There is exactly one starting square.
//     2 represents the ending square.  There is exactly one ending square.
//     0 represents empty squares we can walk over.
//     -1 represents obstacles that we cannot walk over.

// Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

 

// Example 1:

// Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
// Output: 2
// Explanation: We have the following two paths: 
// 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
// 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

// Example 2:

// Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
// Output: 4
// Explanation: We have the following four paths: 
// 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
// 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
// 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
// 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)

// Example 3:

// Input: [[0,1],[2,0]]
// Output: 0
// Explanation: 
// There is no path that walks over every empty square exactly once.
// Note that the starting and ending square can be anywhere in the grid.

 

// Note:

//     1 <= grid.length * grid[0].length <= 20

//Solution:
class Solution {

    public int dfs(int[][] grid, int si, int sj, int zeroes) {
        
        if(si<0 || si>=grid.length || sj<0 || sj>=grid[0].length || grid[si][sj]==-1) return 0;
        if(grid[si][sj]==2) return zeroes==0 ? 1 : 0;
        grid[si][sj]=-1;
        int ans=dfs(grid, si-1, sj, zeroes-1) + dfs(grid, si, sj-1, zeroes-1) + dfs(grid, si+1, sj, zeroes-1) + dfs(grid, si, sj+1, zeroes-1);
        grid[si][sj]=0;
        return ans;
        
    }
    
    public int uniquePathsIII(int[][] grid) {
        
        int si=0, sj=0, zeroes=1;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==0) zeroes++;
                else if(grid[i][j]==1) {
                    si=i; sj=j;
                }   
            }
        }
        
        return dfs(grid, si, sj, zeroes);
    }
    
}
//Complexity: O()

