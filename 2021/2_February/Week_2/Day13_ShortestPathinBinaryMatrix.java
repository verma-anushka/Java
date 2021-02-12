
//Day 13: 
//Problem Statement: Shortest Path in Binary Matrix

// In an N by N square grid, each cell is either empty (0) or blocked (1).

// A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:

// Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
// C_1 is at location (0, 0) (ie. has value grid[0][0])
// C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
// If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
// Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.

 

// Example 1:

// Input: [[0,1],[1,0]]


// Output: 2

// Example 2:

// Input: [[0,0,0],[1,1,0],[1,1,0]]


// Output: 4

// Note:

// 1 <= grid.length == grid[0].length <= 100
// grid[r][c] is 0 or 1

//Solution:
class Solution {
    
    // int [][]dir={{1,1}, {0,1}, {1,0}, {0,-1}, {-1,0}, {-1, -1}, {1, -1}, {-1, 1}};
    int[] dir={-1, 0, 1};

    
    public int shortestPathBinaryMatrix(int[][] grid) {
                
        int ans=0, rows=grid.length, cols=grid[0].length;
        if(grid[0][0]==1 || grid[rows-1][cols-1] == 1) return -1;
        
        Queue<int[]> q=new LinkedList();        
        q.add(new int[]{0, 0});
        
        int size=1;
        
        while(!q.isEmpty()) {
            
            int[] curr=q.remove();
            
            if(curr[0]==rows-1 && curr[1]==cols-1) 
                return ans+1;
            
            for(int i: dir) {
                for(int j: dir) {
                    
                    if(i==0 && j==0) continue;
                    int nextRow=curr[0]+i, nextCol=curr[1]+j;
                    // System.out.println(nextRow + " " + nextCol);

                    if(nextRow<0 || nextCol<0 || nextRow==rows || nextCol==cols || grid[nextRow][nextCol]==1) continue;
                    
                    grid[nextRow][nextCol]=1;
                    q.add(new int[]{nextRow, nextCol});
                    
                }
            }
            
            if(--size==0) {
                ans++;
                size=q.size();
            }
        }
        
        return -1;
    }
}
//Complexity: O(n^2)

