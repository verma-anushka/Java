
//Day 16: 
//Problem Statement: Generate Parentheses

// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

// Example 1:

// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:

// Input: n = 1
// Output: ["()"]
 

// Constraints:

// 1 <= n <= 8

//Solution:
class Solution {

    public List<String> generateParenthesis(int n) {
        String str="";
        List<String> ans=new ArrayList<>();
        generateParenthesisUtil(ans, str, 0, 0, n);
        return ans;
    }

    public void generateParenthesisUtil(List<String> ans, String str, int leftcount, int rightcount, int n) {
        if(leftcount==n && leftcount==rightcount) {
            ans.add(str);
        }

        if(leftcount>n || rightcount>n) {
            return;
        }

        generateParenthesisUtil(ans, str+'(', leftcount+1, rightcount, n);

        if(leftcount > rightcount) {
            generateParenthesisUtil(ans, str+')', leftcount, rightcount+1, n);
        }
    }
}
//Complexity: O(n)

