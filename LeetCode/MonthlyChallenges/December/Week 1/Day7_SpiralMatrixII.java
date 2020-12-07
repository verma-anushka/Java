
//Day 7: 
//Problem Statement: Spiral Matrix II

// Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

 

// Example 1:


// Input: n = 3
// Output: [[1,2,3],[8,9,4],[7,6,5]]
// Example 2:

// Input: n = 1
// Output: [[1]]
 

// Constraints:

// 1 <= n <= 20


//Solution:
class Solution {
    public int[][] generateMatrix(int n) {
        
        int [][]ans=new int[n][n];
        int rs=0, cs=0, re=n-1, ce=n-1, num=1;
        
        while(num<=n*n) {
            
            int c=cs;
            while(c<=ce)
                ans[rs][c++]=num++;
            rs++;
            
            int r=rs;
            while(r<=re)
                ans[r++][ce]=num++;
            c=--ce;
            
            while(c>=cs)
                ans[re][c--]=num++;
            r=--re;
                
            while(r>=rs)
                ans[r--][cs]=num++;
            cs++;
            
        }
        
        return ans;
    }
}
//Complexity: O(n*n)

