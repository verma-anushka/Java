
//Day 14: 
//Problem Statement: Palindrome Partitioning

// Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

// A palindrome string is a string that reads the same backward as forward.

 

// Example 1:

// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]
// Example 2:

// Input: s = "a"
// Output: [["a"]]
 

// Constraints:

// 1 <= s.length <= 16
// s contains only lowercase English letters.

//Solution:
class Solution {

    private boolean isPalindrome(String s) {
        String reverse=new StringBuilder(s).reverse().toString();
        return s.equals(reverse);
    }
    
    private void partitionUtil(List<List<String>> ans, List<String> curr, String input) {
        
        if(input.length() == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i=0; i<input.length(); i++) {
            
            String left=input.substring(0, i+1);

            if(isPalindrome(left)) {
                curr.add(left);
                String right=input.substring(i+1, input.length());
                partitionUtil(ans, curr, right);
                curr.remove(curr.size()-1);
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        
        List<List<String>> ans=new ArrayList<>();
        if(s==null || s.length()==0)
            return ans;

        partitionUtil(ans, new ArrayList<>(), s);
        return ans;
    }

}
//Complexity: O(n)

