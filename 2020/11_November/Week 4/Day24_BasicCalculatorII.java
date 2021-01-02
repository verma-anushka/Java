//Day 24: 
//Problem Statement: Basic Calculator II

// Given a string s which represents an expression, evaluate this expression and return its value. 

// The integer division should truncate toward zero.

 

// Example 1:

// Input: s = "3+2*2"
// Output: 7
// Example 2:

// Input: s = " 3/2 "
// Output: 1
// Example 3:

// Input: s = " 3+5 / 2 "
// Output: 5
 

// Constraints:

// 1 <= s.length <= 3 * 105
// s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
// s represents a valid expression.
// All the integers in the expression are non-negative integers in the range [0, 231 - 1].
// The answer is guaranteed to fit in a 32-bit integer.

//Solution:
class Solution {
    public int calculate(String s) {
                
        if(s==null || s.length()==0) return 0;
        
        char sign='+';
        int num=0, temp=0, ans=0;
        
        for(int i=0; i<s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                num=num*10+s.charAt(i)-'0';
            }
            
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i)!=' ' || i==s.length()-1) {                
                
                switch(sign) {
                    case '+':
                        ans+=temp;
                        temp=num;
                        break;
                    
                    case '-':
                        ans+=temp;
                        temp=-num;
                        break;
                        
                    case '*': 
                        temp*=num;
                        break;
                        
                    case '/' :
                        temp/=num;;
                        break;
                } 
                
                num=0;
                sign=s.charAt(i);
            }
        }
        
        return ans+temp;
    }
}

//Complexity: O(n)

