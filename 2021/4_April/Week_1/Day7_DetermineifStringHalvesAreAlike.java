
//Day 7: 
//Problem Statement: Determine if String Halves Are Alike

// You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.

// Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.

// Return true if a and b are alike. Otherwise, return false.

 

// Example 1:

// Input: s = "book"
// Output: true
// Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
// Example 2:

// Input: s = "textbook"
// Output: false
// Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
// Notice that the vowel o is counted twice.
// Example 3:

// Input: s = "MerryChristmas"
// Output: false
// Example 4:

// Input: s = "AbCdEfGh"
// Output: true
 

// Constraints:

// 2 <= s.length <= 1000
// s.length is even.
// s consists of uppercase and lowercase letters.


//Solution:
class Solution {
     
    public boolean isVowel(char ch) {
        String str="aeiouAEIOU";
        return str.indexOf(ch)!=-1 ? true: false;
    }
    
    public boolean halvesAreAlike(String s) {
        int n=s.length();
        String s1=s.substring(0, n/2), s2=s.substring(n/2, n);
        // cout << s1 << " " << s2 << endl;
        
        int vowelS1=0, vowelS2=0;
        for(int i=0; i<s1.length(); i++) {
            if(isVowel(s1.charAt(i))) vowelS1++;
        }
        
        for(int i=0; i<s2.length(); i++) {
            if(isVowel(s2.charAt(i))) vowelS2++;
        }
        
        return vowelS1==vowelS2;    
    }
}
//Complexity: O(n)

