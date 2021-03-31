
//Day 30: 
//Problem Statement: Russian Doll Envelopes

// You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.

// One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.

// Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

// Note: You cannot rotate an envelope.

 

// Example 1:

// Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
// Output: 3
// Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
// Example 2:

// Input: envelopes = [[1,1],[1,1],[1,1]]
// Output: 1
 

// Constraints:

// 1 <= envelopes.length <= 5000
// envelopes[i].length == 2
// 1 <= wi, hi <= 104

//Solution:
class Solution {

    public int maxEnvelopes(int[][] envelopes) {

        int ans=0;
        int dp[]=new int[envelopes.length];   
        
        Arrays.sort(envelopes, (a, b) -> {
           if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
                
        for(int i=0; i<envelopes.length; i++) {
            dp[i]=1;  
            for(int j=0; j<i; j++) {
                if(envelopes[j][0]<envelopes[i][0] && envelopes[j][1]<envelopes[i][1] ) {
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }
            }
            ans=Math.max(ans, dp[i]);
        }
        
        return ans;
        
    }
}
//Complexity: O(n*n)

