
//Day 6: 
//Problem Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3450/
//Problem Statement: Image Overlap

// You are given two images img1 and img2 both of size n x n, represented as binary, square matrices of the same size. (A binary matrix has only 0s and 1s as values.)

// We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.

// (Note also that a translation does not include any kind of rotation.)

// What is the largest possible overlap?

 

// Example 1:

// Input: img1 = [[1,1,0],[0,1,0],[0,1,0]], img2 = [[0,0,0],[0,1,1],[0,0,1]]
// Output: 3
// Explanation: We slide img1 to right by 1 unit and down by 1 unit.

// The number of positions that have a 1 in both images is 3. (Shown in red)

// Example 2:

// Input: img1 = [[1]], img2 = [[1]]
// Output: 1

// Example 3:

// Input: img1 = [[0]], img2 = [[0]]
// Output: 0

 

// Constraints:

//     n == img1.length
//     n == img1[i].length
//     n == img2.length
//     n == img2[i].length
//     1 <= n <= 30
//     img1[i][j] is 0 or 1.
//     img2[i][j] is 0 or 1.



//Solution:
class Solution {
    
    public int largestOverlap(int[][] a, int[][] b) {
        int n=a.length;
        int[][] c = new int[3*n-2][3*n-2];
        for(int i=0; i<3*n-2; i++) {
            for(int j=0; j<3*n-2; j++) {
                c[i][j]=0;
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                c[i+n-1][j+n-1] = b[i][j];
            }
        }

        int ans=0;
        for(int xshift=0; xshift<2*n-1; xshift++) {
            for(int yshift=0; yshift<2*n-1; yshift++) {
                ans=Math.max(ans, largestOverlapUtil(a, c, xshift, yshift));
            }
        }
        return ans;
    }
    
    public int largestOverlapUtil(int[][] a, int[][] c, int xshift, int yshift) {
        int temp=0;
        for(int i=0;i<a.length;i++) {
            for(int j=0; j<a[0].length; j++) {
                temp += a[i][j] * c[i+yshift][j+xshift];
            }
        }
        return temp;
    }
}
//Complexity: O(n^4)

