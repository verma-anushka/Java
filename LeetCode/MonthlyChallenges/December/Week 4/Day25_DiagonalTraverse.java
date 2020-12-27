
//Day 25: 
//Problem Statement: Diagonal Traverse

// Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

 

// Example:

// Input:
// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]

// Output:  [1,2,4,7,5,3,6,8,9]

// Explanation:

 

// Note:

// The total number of elements of the given matrix will not exceed 10,000.

//Solution:
class Solution {
    public int[] findDiagonalOrder(int[][] nums) {
                
        int rows=nums.length;
        if(rows==0) return new int[0];
        
        int cols=nums[0].length;
        if(cols==0) return new int[0];
        
        ArrayList<Integer> diagonal=new ArrayList<>();
        int []ans=new int[rows*cols];
        int k=0;

        for(int i=0; i<rows+cols-1; i++) {
            
            diagonal.clear();
            
            int r=i<cols ? 0: i-cols+1;
            int c=i<cols ? i: cols-1;
            
            while(r<rows && c>-1) {
                diagonal.add(nums[r][c]);
                ++r; --c;
            }
             
            if(i%2 == 0) Collections.reverse(diagonal);
            
            for(int d:diagonal) ans[k++]=d;
        }
        
        return ans;
    }
}
//Complexity: O(rows+cols)


