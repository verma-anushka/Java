
//Day 17: 
//Problem Statement: Repeated DNA Sequences

// All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T', for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

// Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 

// Example 1:

// Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
// Output: ["AAAAACCCCC","CCCCCAAAAA"]
// Example 2:

// Input: s = "AAAAAAAAAAAAA"
// Output: ["AAAAAAAAAA"]
 

// Constraints:

// 0 <= s.length <= 105
// s[i] is 'A', 'C', 'G', or 'T'.

//Solution:
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
         
        List<String> ans=new ArrayList<String>();
        
        if(s.length()<=10)
            return ans;
        
        HashMap<String, Integer> mp=new HashMap<String, Integer>();
        
        String str="";
        for(int i=0; i<10; i++) {
            str+=s.charAt(i);
        }
        
        mp.put(str, mp.getOrDefault(str, 0)+1);
        
        for(int i=1; i<=s.length()-10; i++) {
            
            StringBuilder sb=new StringBuilder(str);
            sb.deleteCharAt(0);
            sb.append(s.charAt(i+9));
            str=sb.toString();
            mp.put(str, mp.getOrDefault(str, 0)+1);
        }
        
        for(String p:mp.keySet()) {
            if(mp.get(p)>1)
                ans.add(p);
        }

        return ans;
    
    }
}
//Complexity: O(n)

