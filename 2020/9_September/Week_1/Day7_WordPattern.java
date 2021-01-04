
//Day 7: 
//Problem Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3451/
//Problem Statement: Word Pattern

// Given a pattern and a string s, find if s follows the same pattern.

// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

 

// Example 1:

// Input: pattern = "abba", s = "dog cat cat dog"
// Output: true

// Example 2:

// Input: pattern = "abba", s = "dog cat cat fish"
// Output: false

// Example 3:

// Input: pattern = "aaaa", s = "dog cat cat dog"
// Output: false

// Example 4:

// Input: pattern = "abba", s = "dog dog dog dog"
// Output: false

 

// Constraints:

//     1 <= pattern.length <= 300
//     pattern contains only lower-case English letters.
//     1 <= s.length <= 3000
//     s contains only lower-case English letters and spaces ' '.
//     s does not contain any leading or trailing spaces.
//     All the words in s are separated by a single space.


//Solution:
class Solution {
    public boolean wordPattern(String pattern, String str) {
        
        int i=0;
        string word;
        stringstream ss(str);
        unordered_map<char, string> mpchar;
        unordered_map<string, char> mpword;
        
        while(ss >> word) {
            char c=pattern[i];
            if(mpchar.count(c) != mpword.count(word)) return false;
            
            if(mpchar.count(c)) {
                if(mpword[word] != c || mpchar[c] != word) 
                    return false;
            } else {
                mpchar[c] = word;
                mpword[word] = c;
            }
            
            i++;
        }
        
        return i==pattern.size();
    }
}
//Complexity: O(n)

