
//Day 5: 
//Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3413/
//Problem Statement: Add and Search Word - Data structure design

// Design a data structure that supports the following two operations:

// void addWord(word)
// bool search(word)
// search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

// Example:

// addWord("bad")
// addWord("dad")
// addWord("mad")
// search("pad") -> false
// search("bad") -> true
// search(".ad") -> true
// search("b..") -> true
// Note:
// You may assume that all words are consist of lowercase letters a-z.

//Solution #1:
class WordDictionary {

    WordDictionary[] children;
    boolean isWordEnd;
    /** Initialize your data structure here. */
    public WordDictionary() {
        children = new WordDictionary[26];
        for(int i=0; i<26; i++) children[i] = null;
        isWordEnd = false;
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        WordDictionary curr = this;
        for(char w:word.toCharArray()) {
            if( curr.children[w-'a'] == null) {
                curr.children[w-'a'] = new WordDictionary();
            }
            curr = curr.children[w-'a'];
        }
        curr.isWordEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        WordDictionary curr = this;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(c == '.') {
                for(WordDictionary child: curr.children) {
                    if(child != null && child.search(word.substring(i+1))) return true;
                }
                return false;
            } 
            if(curr.children[c-'a'] == null) {
                return false;       
            }
            curr = curr.children[c-'a'];
        }
        return curr != null && curr.isWordEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */


//Complexity: O(n)

