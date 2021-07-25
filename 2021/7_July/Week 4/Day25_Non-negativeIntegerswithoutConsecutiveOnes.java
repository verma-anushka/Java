
//Day 25: 
//Problem Statement: Non-negative Integers without Consecutive Ones

// Given a positive integer n, return the number of the integers in the range [0, n] whose binary representations do not contain consecutive ones.

 

// Example 1:

// Input: n = 5
// Output: 5
// Explanation:
// Here are the non-negative integers <= 5 with their corresponding binary representations:
// 0 : 0
// 1 : 1
// 2 : 10
// 3 : 11
// 4 : 100
// 5 : 101
// Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule. 
// Example 2:

// Input: n = 1
// Output: 2
// Example 3:

// Input: n = 2
// Output: 3
 

// Constraints:

// 1 <= n <= 109

//Solution:
class Solution {
    public int findIntegers(int n) {
        
        int ans=2, size=1;
        int[] st=new int[100];
        st[0]=1;

        while(size!=0) {
            int l=st[--size];
            int lo=l<<1;
            if((l&1)==0 && lo+1<=n){
                ans++;
                st[size++]=lo+1;
            }
            if(lo<=n) {
                ans++;
                st[size++]=lo;
            }
        }
        return ans;
    }
} 
//Complexity: O(n)

