
//Day 16: 
//Problem Statement: Search a 2D Matrix

// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
 

// Example 1:


// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
// Output: true
// Example 2:


// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
// Output: false
// Example 3:

// Input: matrix = [], target = 0
// Output: false
 

// Constraints:

// m == matrix.length
// n == matrix[i].length
// 0 <= m, n <= 100
// -104 <= matrix[i][j], target <= 104 

//Solution:
class Solution {
    public boolean searchMatrix(int[][] matrix, int t) {
        
        if(matrix.length == 0) return false;
        
        int r=0, c=matrix[0].length-1;
        
        while(r<matrix.length && c>=0) {
            
            if(matrix[r][c] == t) return true;
            else if(matrix[r][c] < t) r++;
            else {
                int i=0, j=c;
                while(i<=j) {
                    int mid=i+(j-i)/2;
                    if(matrix[r][mid]==t) return true;
                    else if(matrix[r][mid] < t) i+=1;
                    else j-=1;
                }
                return false;
            }
            // c--;
        }
        return false;
    }
}

//Complexity: O(r+c)

