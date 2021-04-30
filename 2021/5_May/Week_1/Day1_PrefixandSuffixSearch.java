
//Day 1:
//Problem Statement: Prefix and Suffix Search

// Design a special dictionary with some words that searchs the words in it by a prefix and a suffix.

// Implement the WordFilter class:

// WordFilter(string[] words) Initializes the object with the words in the dictionary.
// f(string prefix, string suffix) Returns the index of the word in the dictionary, which has the prefix prefix and the suffix suffix. If there is more than one valid index, return the largest of them. If there is no such word in the dictionary, return -1.
 

// Example 1:

// Input
// ["WordFilter", "f"]
// [[["apple"]], ["a", "e"]]
// Output
// [null, 0]

// Explanation
// WordFilter wordFilter = new WordFilter(["apple"]);
// wordFilter.f("a", "e"); // return 0, because the word at index 0 has prefix = "a" and suffix = 'e".
 

// Constraints:

// 1 <= words.length <= 15000
// 1 <= words[i].length <= 10
// 1 <= prefix.length, suffix.length <= 10
// words[i], prefix and suffix consist of lower-case English letters only.
// At most 15000 calls will be made to the function f.

//Solution:
class TrieNode {
    public TrieNode[] children=new TrieNode[26];
    public List<Integer> vals=new ArrayList<>();
}

class WordFilter {
    private TrieNode preTrie=new TrieNode(), suffTrie=new TrieNode();
    
    public WordFilter(String[] words) {

        for(int i=0; i<words.length; i++) {
            char[] word=words[i].toCharArray();
            int n=word.length;
            insert(word, i, preTrie, 0, n, 1);
            insert(word, i, suffTrie, n-1, -1, -1);
        }
    }
    
    private void insert(char[] word, int i, TrieNode trie, int si, int ei, int jump) {
        
        for(int j=si; j!=ei; j+=jump) {
            int val=word[j]-'a';
            if(trie.children[val]==null) {
                trie.children[val]=new TrieNode();
            }
            trie=trie.children[val];
            trie.vals.add(i);
        }
    }
    
    private List<Integer> get(char[] word, TrieNode trie, int si, int ei, int jump) {
        for(int i=si; i!=ei; i+=jump) {
            trie=trie.children[word[i]-'a'];
            if(trie==null) return new ArrayList<>();
        }
        
        return trie.vals;
    }
    
    public int f(String pre, String suff) {
        
        List<Integer> preVals=get(pre.toCharArray(), preTrie, 0, pre.length(), 1);
        List<Integer> suffVals=get(suff.toCharArray(), suffTrie, suff.length()-1, -1, -1);
        int s=suffVals.size()-1, p=preVals.size()-1;
        
        while(s>=0 && p>=0) {
            int suffVal=suffVals.get(s), preVal=preVals.get(p);
            if(suffVal==preVal) return suffVal;
            
            if(suffVal>preVal) s--;
            else p--;
        }
        
        return -1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */

//Complexity: O(n*k+Q(n+k)) where n -> number of words, k -> maximum length of a word, Q -> number of queries. 

