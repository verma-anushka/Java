
//Day 23: 
//Problem Statement: Find the Shortest Superstring

// Given an array of strings words, return the smallest string that contains each string in words as a substring. If there are multiple valid strings of the smallest length, return any of them.

// You may assume that no string in words is a substring of another string in words.

 

// Example 1:

// Input: words = ["alex","loves","leetcode"]
// Output: "alexlovesleetcode"
// Explanation: All permutations of "alex","loves","leetcode" would also be accepted.
// Example 2:

// Input: words = ["catg","ctaagt","gcta","ttca","atgcatc"]
// Output: "gctaagttcatgcatc"
 

// Constraints:

// 1 <= words.length <= 12
// 1 <= words[i].length <= 20
// words[i] consists of lowercase English letters.
// All the strings of words are unique.


//Solution:
class Solution {
    
    Map<Pair<Integer, Integer>, String> dp=new HashMap<>();
    
    String shortestSuperstringUtil(String words[], int lastIndex, boolean visited[]) {
        
        int h=Arrays.hashCode(visited);
        Pair<Integer, Integer> p=new Pair<>(h, lastIndex);
        if(dp.containsKey(p)) 
            return dp.get(p);
        
        String ans="";
        for(int i=0; i<words.length; i++) {
            if(visited[i]) continue;
            
            if(lastIndex==-1) {
                visited[i]=true;
                String temp=words[i]+shortestSuperstringUtil(words, i, visited);
                ans=ans.equals("") ? temp: (ans.length()<temp.length() ? ans: temp);
                visited[i]=false;
            } else {
                int len=0;
                for(len=Math.min(words[lastIndex].length(), words[i].length()); len>0; len--) {
                   if(words[lastIndex].substring(words[lastIndex].length()-len).equals(words[i].substring(0, len)))
                       break;
                }
                
                visited[i]=true;
                String temp=words[i].substring(len)+shortestSuperstringUtil(words, i, visited);
                ans=ans.equals("") ? temp: (ans.length()<temp.length() ? ans: temp);
                visited[i]=false;
            }
        }
        
        dp.put(p, ans);
        return ans;
    }
    
    public String shortestSuperstring(String[] words) {
        return shortestSuperstringUtil(words, -1, new boolean[words.length]);
    }
}

//Complexity: O(n*n)