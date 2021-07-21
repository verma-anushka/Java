
//Day 21: 
//Problem Statement: Push Dominoes

// There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.

// After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.

// When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.

// For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.

// You are given a string dominoes representing the initial state where:

// dominoes[i] = 'L', if the ith domino has been pushed to the left,
// dominoes[i] = 'R', if the ith domino has been pushed to the right, and
// dominoes[i] = '.', if the ith domino has not been pushed.
// Return a string representing the final state.

 

// Example 1:

// Input: dominoes = "RR.L"
// Output: "RR.L"
// Explanation: The first domino expends no additional force on the second domino.
// Example 2:


// Input: dominoes = ".L.R...LR..L.."
// Output: "LL.RR.LLRRLL.."
 

// Constraints:

// n == dominoes.length
// 1 <= n <= 105
// dominoes[i] is either 'L', 'R', or '.'.

//Solution:
class Solution {
    public String pushDominoes(String dominoes) {
        
        int leftIdx=-1, rightIdx=-1, length=dominoes.length();
        int[] dp=new int[length];
        char[] ans=new char[length];
        
        for(int i=length-1; i>=0; i--) {
            if(dominoes.charAt(i)=='L')
                leftIdx=i;
            else if(dominoes.charAt(i)=='R')
                leftIdx=-1;
            
            dp[i]=leftIdx;
        }
        
        for(int i=0; i<length; i++) {
            if(dominoes.charAt(i)=='L')
                rightIdx=-1;
            else if(dominoes.charAt(i)=='R')
                rightIdx=i;
            
            int leftDist = dp[i]==-1 ? length: dp[i]-i;
            int rightDist = rightIdx==-1 ? length: i-rightIdx;
            
            if(leftDist==rightDist)
                ans[i]='.';    
            else if(leftDist<rightDist)
                ans[i]='L';
            else
                ans[i]='R';
        }
        
        return new String(ans);
    }
}
//Complexity: O(n)

