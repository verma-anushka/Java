
//Day 8: 
//Problem Statement: Letter Combinations of a Phone Number

// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



 

// Example 1:

// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// Example 2:

// Input: digits = ""
// Output: []
// Example 3:

// Input: digits = "2"
// Output: ["a","b","c"]
 

// Constraints:

// 0 <= digits.length <= 4
// digits[i] is a digit in the range ['2', '9'].

//Solution:
class Solution {
        
    String[] combinations=new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    private void dfs(int i, StringBuilder curr, String digits, List<String> ans) {
        
        if(i==digits.length()) {
            ans.add(curr.toString());
            return;
        }
        
        char curchar=digits.charAt(i);
        for(char c: combinations[curchar-'0'].toCharArray()) {
            curr.append(c);
            dfs(i+1, curr, digits, ans);
            curr.deleteCharAt(curr.length()-1);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans=new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        
        dfs(0, new StringBuilder(), digits, ans);
        return ans;
    }
    
}
//Complexity: O(n*n)

