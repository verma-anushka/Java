
//Day 27: 
//Problem Statement: Candy

// There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

// You are giving candies to these children subjected to the following requirements:

// Each child must have at least one candy.
// Children with a higher rating get more candies than their neighbors.
// Return the minimum number of candies you need to have to distribute the candies to the children.

 

// Example 1:

// Input: ratings = [1,0,2]
// Output: 5
// Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
// Example 2:

// Input: ratings = [1,2,2]
// Output: 4
// Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
// The third child gets 1 candy because it satisfies the above two conditions.
 

// Constraints:

// n == ratings.length
// 1 <= n <= 2 * 104
// 0 <= ratings[i] <= 2 * 104

//Solution:
class Solution {
    public int candy(int[] ratings) {
        
        int[] a=new int[ratings.length], b=new int[ratings.length];
        
        a[0]=1;
        for(int i=1; i<ratings.length; i++) {
            if(ratings[i]>ratings[i-1]) 
                a[i]=a[i-1]+1;
            else
                a[i]=1;    
        }
        
        b[ratings.length-1]=1;
        for(int i=ratings.length-2; i>=0; i--) {
            if(ratings[i]>ratings[i+1])
                b[i]=b[i+1]+1;
            else
                b[i]=1;
        }
        
        int ans=0;
        for(int i=0; i<ratings.length; i++){
            a[i]=Math.max(a[i], b[i]);
            ans+=a[i];
        }
        
        return ans;
    }
}
//Complexity: O(n)

