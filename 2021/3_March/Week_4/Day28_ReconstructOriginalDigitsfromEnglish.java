
//Day 28: 
//Problem Statement: Reconstruct Original Digits from English

// Given a string s containing an out-of-order English representation of digits 0-9, return the digits in ascending order.

 

// Example 1:

// Input: s = "owoztneoer"
// Output: "012"
// Example 2:

// Input: s = "fviefuro"
// Output: "45"
 

// Constraints:

// 1 <= s.length <= 105
// s[i] is one of the characters ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"].
// s is guaranteed to be valid.

//Solution:
class Solution {
    
    int[] DIGITS={0, 2, 4, 6, 8, 5, 7, 3, 9, 1}, CHARS={25, 22, 20, 23, 6, 5, 18, 7, 8, 14};
    int[][] REMS={{14}, {14}, {5, 14}, {18, 8}, {8, 7}, {8}, {}, {}, {}, {}};
    
    public String originalDigits(String s) {
        
        int[] freq=new int[26], ans=new int[10];
        char[] str=s.toCharArray();
        
        for(char c: str) 
            freq[c-97]++;
        
        for(int i=0; i<10; i++) {
            int count=freq[CHARS[i]];
            for(int rem: REMS[i]) 
                freq[rem]-=count;
            ans[DIGITS[i]]=count;
        }
        
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<10; i++) {
            
            char c=(char)(i+48);
            for(int j=0; j<ans[i]; j++)
                sb.append(c);
        }
        
        return sb.toString();
    
    }
}
//Complexity: O(n)

