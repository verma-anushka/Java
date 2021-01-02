
//Day 23: 
//Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3434/
//Problem Statement: Stream of Characters

// Implement the StreamChecker class as follows:

// StreamChecker(words): Constructor, init the data structure with the given words.
// query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, including this letter just queried) spell one of the words in the given list.
 

// Example:

// StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
// streamChecker.query('a');          // return false
// streamChecker.query('b');          // return false
// streamChecker.query('c');          // return false
// streamChecker.query('d');          // return true, because 'cd' is in the wordlist
// streamChecker.query('e');          // return false
// streamChecker.query('f');          // return true, because 'f' is in the wordlist
// streamChecker.query('g');          // return false
// streamChecker.query('h');          // return false
// streamChecker.query('i');          // return false
// streamChecker.query('j');          // return false
// streamChecker.query('k');          // return false
// streamChecker.query('l');          // return true, because 'kl' is in the wordlist
 

// Note:

// 1 <= words.length <= 2000
// 1 <= words[i].length <= 2000
// Words will only consist of lowercase English letters.
// Queries will only consist of lowercase English letters.
// The number of queries is at most 40000.


//Solution:
class Trie {
    
    public Trie children[];
    public boolean isEnd;

    public Trie() {
        isEnd=false;
        children=new Trie[26];
        // for(int i=0; i<26; i++) {
        //     children[i]=null;
        // }
    }
    
    public void insert(String s) {
        Trie t=this;
        
        for(char c: s.toCharArray()) {
            if(t.children[c-'a'] == null) {
                t.children[c-'a'] = new Trie();
            }
            t = t.children[c-'a'];
        }
        t.isEnd = true;
        
    }
    
    public boolean search(Deque<Character> input) {
        Trie t=this;
        
        for(char c: input) {
            
            if(t.children[c-'a'] == null)
                return false;
            
            t = t.children[c-'a'];
            
            if(t.isEnd) 
                return true;
        }
        return false;
    }

};


class StreamChecker {
    
    public Trie t = new Trie();
    Deque<Character> input = new LinkedList();
    
    public StreamChecker(String[] words) {
        
        for(String w: words) {
            String wrev = new StringBuilder(w).reverse().toString();
            t.insert(wrev);
        }
    }
    
    public boolean query(char c) {
        input.addFirst(c);
        return t.search(input);
    }
};

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
//Complexity: O(n)
