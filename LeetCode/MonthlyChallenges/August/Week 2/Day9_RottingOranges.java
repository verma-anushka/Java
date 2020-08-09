
//Day 9: 
//Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3418/
//Problem Statement: Rotting Oranges

// In a given grid, each cell can have one of three values:

// the value 0 representing an empty cell;
// the value 1 representing a fresh orange;
// the value 2 representing a rotten orange.
// Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

//Solution:
class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> q=new LinkedList();
        
        int r=grid.length;
        // if(!r) return -1;
        
        int c=grid[0].length;
        // if(!c) return -1;

        int fresh=0, time=0;
        
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {       
                if(grid[i][j] == 2) q.add(new int[]{i, j});
                else if(grid[i][j] == 1) fresh++;
            }
        }
        
        while(!q.isEmpty()) {
            int size=q.size();
            for(int i=0; i<size; i++) {
                
                int x=q.peek()[0], y=q.peek()[1];
                q.remove();
                
                if(x>0 && grid[x-1][y] == 1) {
                    grid[x-1][y]=2;
                    fresh--;
                    q.add(new int[]{x-1, y});
                }
                if(x<r-1 && grid[x+1][y] == 1) {
                    grid[x+1][y]=2;
                    fresh--;
                    q.add(new int[]{x+1, y});
                }
                if(y>0 && grid[x][y-1] == 1) {
                    grid[x][y-1]=2;
                    fresh--;
                    q.add(new int[]{x, y-1});
                }
                if(y<c-1 && grid[x][y+1] == 1) {
                    grid[x][y+1]=2;
                    fresh--;
                    q.add(new int[]{x, y+1});
                }
            }
            
            if(!q.isEmpty()) time++;
        }
        return fresh == 0 ? time : -1;
    }
}
//Complexity: O(n)

