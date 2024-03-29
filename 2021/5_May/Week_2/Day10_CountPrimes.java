
//Day 10: 
//Problem Statement: Count Primes

// Count the number of prime numbers less than a non-negative number, n.

 

// Example 1:

// Input: n = 10
// Output: 4
// Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
// Example 2:

// Input: n = 0
// Output: 0
// Example 3:

// Input: n = 1
// Output: 0
 

// Constraints:

// 0 <= n <= 5 * 106

//Solution:
class Solution {
    public int countPrimes(int n) {
        
        if(n<3) return 0;
        int ans=n-2;
        
        boolean []primes=new boolean[n];
        primes[0]=primes[1]=false;
        
        for(int i=2; i<n; i++) {
            primes[i]=true;
        }
        
        for(int i=2; i*i<n; i++) {
            if(primes[i]) {
                for(int j=i*i; j<n; j+=i) {
                    if(primes[j]) {
                        primes[j]=false;
                        ans--;
                    }
                }
            }
        }
        
        return ans;
    }
}
//Complexity: O(n*log(logn))

