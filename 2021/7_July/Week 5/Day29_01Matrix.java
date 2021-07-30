//Day 29:
//Problem Statement: 01 Matrix

// Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

// The distance between two adjacent cells is 1.

 

// Example 1:


// Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
// Output: [[0,0,0],[0,1,0],[0,0,0]]
// Example 2:


// Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
// Output: [[0,0,0],[0,1,0],[1,2,1]]
 

// Constraints:

// m == mat.length
// n == mat[i].length
// 1 <= m, n <= 104
// 1 <= m * n <= 104
// mat[i][j] is either 0 or 1.
// There is at least one 0 in mat.


//Solution: 
class Solution {
    public int[][] updateMatrix(int[][] mat) {

        if(mat==null || mat.length==0) return mat;
        int n=mat.length, m=mat[0].length;
        Queue<int []> q=new LinkedList<>();
        boolean[][] visited=new boolean[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(mat[i][j]==0) {
                    q.offer(new int[]{i, j});
                    visited[i][j]=true;
                }
            }
        }
        
       int [][] directions={{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

        while(!q.isEmpty()) {

            int size=q.size();
            for(int i=0; i<size; i++) {
                
                int [] curr=q.poll();
                int first=curr[0];
                int second=curr[1];
                
                for(int[] dir: directions) {
                    int x=first + dir[0];
                    int y=second + dir[1];
                    
                    // isValid
                    if(x<0 || x>n-1 || y<0 || y>m-1 || visited[x][y])
                       continue;
                    
                    mat[x][y]=mat[first][second]+1;
                    q.offer(new int[]{x, y});
                    visited[x][y]=true;
                }
            }
            
        }
        return mat;
    }
}
//Complexity: O(m*n)
