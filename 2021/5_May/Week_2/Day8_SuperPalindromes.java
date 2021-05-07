
//Day 8: 
//Problem Statement: Super Palindromes

// Let's say a positive integer is a super-palindrome if it is a palindrome, and it is also the square of a palindrome.

// Given two positive integers left and right represented as strings, return the number of super-palindromes integers in the inclusive range [left, right].

 

// Example 1:

// Input: left = "4", right = "1000"
// Output: 4
// Explanation: 4, 9, 121, and 484 are superpalindromes.
// Note that 676 is not a superpalindrome: 26 * 26 = 676, but 26 is not a palindrome.
// Example 2:

// Input: left = "1", right = "2"
// Output: 1
 

// Constraints:

// 1 <= left.length, right.length <= 18
// left and right consist of only digits.
// left and right cannot have leading zeros.
// left and right represent integers in the range [1, 1018 - 1].
// left is less than or equal to right.

//Solution:
class Solution {
    
    private boolean isPalindrome(long num) {
        long rev=0, temp=num;
        while(temp>0) {
            rev=rev*10+temp%10;
            temp/=10;
        }
        return rev==num;
    }
    
    private long createPalindrome(long prefix, long suffix) {
        while(suffix>0) {
            prefix=prefix*10+suffix%10;
            suffix/=10;
        }
        return prefix;
    }
    
    public int superpalindromesInRange(String left, String right) {
        
        int ans=0;
        long num=0, l=Long.parseLong(left), r=Long.parseLong(right);
        long sqrtl=(long)Math.sqrt(l), sqrtr=(long)Math.sqrt(r);
        
        for(long i=1; num<=sqrtr; i++) {
            
            num=createPalindrome(i, i);
            if(num>=sqrtl && num<=sqrtr && isPalindrome(num*num))
                ans++;
            
            num=createPalindrome(i, i/10);
            if(num>=sqrtl && num<=sqrtr && isPalindrome(num*num))
                ans++;
        }
        
        return ans;
    
    }
}
//Complexity: O(right^(1/4)*log(right))

