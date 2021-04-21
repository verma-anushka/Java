
//Day 16: 
//Problem Statement: Remove All Adjacent Duplicates in String II

// You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

// We repeatedly make k duplicate removals on s until we no longer can.

// Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

 

// Example 1:

// Input: s = "abcd", k = 2
// Output: "abcd"
// Explanation: There's nothing to delete.
// Example 2:

// Input: s = "deeedbbcccbdaa", k = 3
// Output: "aa"
// Explanation: 
// First delete "eee" and "ccc", get "ddbbbdaa"
// Then delete "bbb", get "dddaa"
// Finally delete "ddd", get "aa"
// Example 3:

// Input: s = "pbbcggttciiippooaais", k = 2
// Output: "ps"
 

// Constraints:

// 1 <= s.length <= 105
// 2 <= k <= 104
// s only contains lower case English letters.

//Solution #1:
class Solution {
    public String removeDuplicates(String s, int k) {
        for(int i=1, count=1; i<s.length(); i++) {
            count=s.charAt(i)==s.charAt(i-1) ? count+1: 1;
            if(count==k) 
                s=removeDuplicates(s.substring(0, i-k+1)+s.substring(i+1), k);
        }
    }
}
//Complexity: O(n^2)

// Solution #2:
class Solution {
    public String removeDuplicates(String s, int k) {

        char[] str=s.toCharArray();
        Stack<Integer> st=new Stack<>();
        st.add(0);

        int i, j;
        for(i=1, j=1; j<s.length(); i++, j++) {
            
            str[i]=str[j];
            if(i== 0 || str[i]!=str[i-1]) st.add(i);
            else if(i-st.peek()+1==k) i=st.pop()-1;
        }
        
        return new String(str, 0, i);
    
    }
}
//Complexity: O(n)


