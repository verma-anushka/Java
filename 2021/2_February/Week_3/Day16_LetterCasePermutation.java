
//Day 16: 
//Problem Statement: Letter Case Permutation

// Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.

// Return a list of all possible strings we could create. You can return the output in any order.

 

// Example 1:

// Input: S = "a1b2"
// Output: ["a1b2","a1B2","A1b2","A1B2"]
// Example 2:

// Input: S = "3z4"
// Output: ["3z4","3Z4"]
// Example 3:

// Input: S = "12345"
// Output: ["12345"]
// Example 4:

// Input: S = "0"
// Output: ["0"]
 

// Constraints:

// S will be a string with length between 1 and 12.
// S will consist only of letters or digits.

//Solution:
class Solution {
        
    List<String> ansList=new ArrayList<>();

    public void letterCasePermutationUtil(String s, int n, String ans) {
        if(ans.length()==n) {
            ansList.add(ans);
            return;   
        }
        
        char ch=s.charAt(0), temp='\0';
        
        if(Character.isLowerCase(ch))
            temp=Character.toUpperCase(ch);
        else if(Character.isUpperCase(ch))
            temp=Character.toLowerCase(ch);
        
        if((ch>=65 && ch<=90) || (ch>=97 && ch<=122)) {
            letterCasePermutationUtil(s.substring(1), n, ans+temp);
            letterCasePermutationUtil(s.substring(1), n, ans+ch);
        } else
            letterCasePermutationUtil(s.substring(1), n, ans+ch);
    }
    
    public List<String> letterCasePermutation(String s) {
        letterCasePermutationUtil(s, s.length(), "");
        return ansList;
    }
    
}
//Complexity: O(2^n)

