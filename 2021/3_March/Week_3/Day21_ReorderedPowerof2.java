
//Day 21: 
//Problem Statement: Reordered Power of 2

// Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.

// Return true if and only if we can do this in a way such that the resulting number is a power of 2.

 

// Example 1:

// Input: 1
// Output: true
// Example 2:

// Input: 10
// Output: false
// Example 3:

// Input: 16
// Output: true
// Example 4:

// Input: 24
// Output: false
// Example 5:

// Input: 46
// Output: true
 

// Note:

// 1 <= N <= 10^9

//Solution:
class Solution {
    
    private char[] sortnum(int n) {
        
        char[] sortedNum=String.valueOf(n).toCharArray();
        Arrays.sort(sortedNum);
        return sortedNum;
        
    }
    
    public boolean reorderedPowerOf2(int n) {
         
        char[] num=sortnum(n);
        
        for(int i=0; i<32; i++)
            if(Arrays.equals(num, sortnum(1<<i))) 
                return true;
        
        return false;
    }
}
//Complexity: O(n*logn)

