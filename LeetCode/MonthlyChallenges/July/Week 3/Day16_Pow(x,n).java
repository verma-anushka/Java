
//Day 16: 
//Problem Link: https://leetcode.com/explore/featured/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3392/
//Problem Statement:Pow(x, n)

//Implement pow(x, n), which calculates x raised to the power n (xn).

//Example 1:

//Input: 2.00000, 10
//Output: 1024.00000
//Example 2:

//Input: 2.10000, 3
//Output: 9.26100
//Example 3:

//Input: 2.00000, -2
//Output: 0.25000
//Explanation: 2-2 = 1/22 = 1/4 = 0.25
//Note:

//-100.0 < x < 100.0
//n is a 32-bit signed integer, within the range [−231, 231 − 1]

//Solution:
class Solution {

    public double pow(double x, long n){
        
        if(n < 0) return pow(1/x, -n);
        if(n == 0) return 1.0;
        if(n == 1) return x;
        
        double ans=pow(x*x, n/2);
        if(n%2 != 0) ans *= x;
        return ans;
    }
    
    public double myPow(double x, int n) {
        return pow(x,n);
    }
    
}
//Complexity: O(logn)

