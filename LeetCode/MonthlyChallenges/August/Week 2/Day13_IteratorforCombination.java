
//Day 13: 
//Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3422/
//Problem Statement: Iterator for Combination

// Design an Iterator class, which has:

// A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
// A function next() that returns the next combination of length combinationLength in lexicographical order.
// A function hasNext() that returns True if and only if there exists a next combination.
 

// Example:

// CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

// iterator.next(); // returns "ab"
// iterator.hasNext(); // returns true
// iterator.next(); // returns "ac"
// iterator.hasNext(); // returns true
// iterator.next(); // returns "bc"
// iterator.hasNext(); // returns false
 

// Constraints:

// 1 <= combinationLength <= characters.length <= 15
// There will be at most 10^4 function calls per test.
// It's guaranteed that all calls of the function next are valid.

//Solution:
class CombinationIterator {
    
    String s;
    Queue<String> q= new PriorityQueue<>();
    
    public void getComb(int si, int len, String comb) {
        if(len==0) {
            q.add(comb);
            return;
        }
        
        for(int i=si; i<=s.length()-len; i++) {
            getComb(i+1, len-1, comb+s.charAt(i));
        }   
    }
    
    public CombinationIterator(String characters, int combinationLength) {
        s=characters;
        String comb="";
        getComb(0, combinationLength, comb);
    }
    
    public String next() {
        String str=q.poll();
        return str;
    }
    
    public boolean hasNext() {
        return !q.isEmpty();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//Complexity: O()
