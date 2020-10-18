
//Day 18: 
//Problem Statement: Best Time to Buy and Sell Stock IV

// You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

// Design an algorithm to find the maximum profit. You may complete at most k transactions.

// Notice that you may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

// Example 1:

// Input: k = 2, prices = [2,4,1]
// Output: 2
// Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
// Example 2:

// Input: k = 2, prices = [3,2,6,5,0,3]
// Output: 7
// Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 

// Constraints:

// 0 <= k <= 109
// 0 <= prices.length <= 1000
// 0 <= prices[i] <= 1000

//Solution:
class Solution {
    public int maxProfit(int k, int[] prices) {
        
        if(k==0 || prices.length<=1) 
            return 0;
        
        int[][] dp=new int[2][k];
        
        Arrays.fill(dp[1], Integer.MIN_VALUE);
        
        for(int price: prices) {
            
            dp[0][0]=Math.max(dp[0][0], dp[1][0]+price);
            dp[1][0]=Math.max(dp[1][0], -price);
            
            for(int trans = 2; trans<=k; trans++) {
                
                dp[0][trans-1] = Math.max(dp[0][trans-1], dp[1][trans-1]+price);
                dp[1][trans-1] = Math.max(dp[1][trans-1], dp[0][trans-2]-price);
            
            }
        }
        
        return dp[0][k-1];
    
    }
}
//Complexity: O(n)
