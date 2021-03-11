
//Day 11: 
//Problem Statement: Coin Change

// You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.

 

// Example 1:

// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1
// Example 2:

// Input: coins = [2], amount = 3
// Output: -1
// Example 3:

// Input: coins = [1], amount = 0
// Output: 0
// Example 4:

// Input: coins = [1], amount = 1
// Output: 1
// Example 5:

// Input: coins = [1], amount = 2
// Output: 2
 

// Constraints:

// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104

//Solution:
class Solution {
    public int coinChange(int[] coins, int amt) {
        
        int []dp=new int[amt+1];
        
        for(int j=0; j<=amt; j++) {
            dp[j]=Integer.MAX_VALUE;
            if(j%coins[0]==0) dp[j]=j/coins[0];
        }
        
        for(int i=1; i<coins.length; i++) {
            for(int j=1; j<=amt; j++) {
                if(j>=coins[i] && dp[j-coins[i]]!=Integer.MAX_VALUE)
                    dp[j] = Math.min(1+dp[j-coins[i]], dp[j]);
                // else
                //     dp[i][j]=dp[i-1][j];                
            }
        }
        return dp[amt] == Integer.MAX_VALUE ? -1: dp[amt];
    }
}

//Complexity: O(n*amt)

