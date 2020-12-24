
//Day 23: 
//Problem Statement: Next Greater Element III

// Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.

// Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.

 

// Example 1:

// Input: n = 12
// Output: 21
// Example 2:

// Input: n = 21
// Output: -1
 

// Constraints:

// 1 <= n <= 231 - 1


//Solution:
class Solution {
        
    private void reverse(char[] ch, int si) {
        int l=si, r=ch.length-1;
        while(l<r) {
            swap(ch, l, r);
            l++; r--;
        }
    }
    
    private void swap(char[] ch, int i, int j) {
        char temp=ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
    }
    
    public int nextGreaterElement(int n) {
        
        char[] ch = ("" + n).toCharArray();
        int idx=ch.length - 2;
        
        while(idx>=0 && ch[idx]>=ch[idx+1])
            idx--;
   
        if(idx==-1) return -1;
        
        int idx2=ch.length-1;
        while(idx2>=idx && ch[idx2]<=ch[idx])
            idx2--;
        
        swap(ch, idx, idx2);
        reverse(ch, idx+1);
        
        Long ans=Long.parseLong(new String(ch));
        
        if(ans<=Integer.MAX_VALUE) return ans.intValue();
        else return -1;
        
    }
}
//Complexity: O(n*n!)
