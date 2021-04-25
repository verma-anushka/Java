
//Day 25: 
//Problem Statement: Rotate Image

// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 

// Example 1:


// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]
// Example 2:


// Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
// Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// Example 3:

// Input: matrix = [[1]]
// Output: [[1]]
// Example 4:

// Input: matrix = [[1,2],[3,4]]
// Output: [[3,1],[4,2]]
 

// Constraints:

// matrix.length == n
// matrix[i].length == n
// 1 <= n <= 20
// -1000 <= matrix[i][j] <= 1000

//Solution #1:
class Solution {
    public void rotate(int[][] matrix) {

        int size=m.length*m.length;
        
        int row=0, col=m.length-1;
        int row_pointer=0, col_pointer=m.length-1;
        
        while(size>0) {
        
            int first=m[row][row_pointer];
            int second=m[row_pointer][col];
            int third=m[col][col_pointer];;
            int fourth=m[col_pointer][row];

            m[row][row_pointer]=fourth;        
            m[row_pointer][col]=first;
            m[col][col_pointer]=second;
            m[col_pointer][row]=third;

            row_pointer++;
            col_pointer--;

            size-=4;
            
            if(row_pointer>=col) {
                row++; col--;
                row_pointer=row;
                col_pointer=col;
            }            
            
        }
    }
}
//Complexity: O(n)

//Solution #2:
class Solution {
    public void rotate(int[][] matrix) {
          
        int n=matrix.length;
        for(int i=0; i<(n+1)/2; i++) {
            for(int j=0; j<n/2; j++) {
                int temp=matrix[n-1-j][i];
                matrix[n-1-j][i]=matrix[n-1-i][n-j-1];
                matrix[n-1-i][n-j-1]=matrix[j][n-1-i];
                matrix[j][n-1-i]=matrix[i][j];
                matrix[i][j]=temp;
            }
        }
    }
}
//Complexity: O(n)


