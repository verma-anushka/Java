
//Day 7: 
//Problem Link: https://leetcode.com/explore/featured/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3383/
//Problem Statement: Island Perimeter

// You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

// Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

// The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
// Example:

// Input:
// [[0,1,0,0],
//  [1,1,1,0],
//  [0,1,0,0],
//  [1,1,0,0]]

// Output: 16

// Explanation: The perimeter is the 16 yellow stripes in the image below:

//Solution:
class Solution {
    public int islandPerimeter(int[][] grid) {
        
        int ans=0;
        if(grid.length==0) return ans;
        if(grid[0].length==0) return ans;
    
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==1)
                {
                    ans+=4;
                    if(i>0) ans-=grid[i-1][j];
                    if(j>0) ans-=grid[i][j-1];
                    if(i<grid.length-1) ans-=grid[i+1][j];
                    if(j<grid[0].length-1) ans-=grid[i][j+1];
                } 
            }
            // System.out.println(ans);
        }
        return ans;
        
    }
}

//Complexity: O(n)

