
//Day 2: 
//Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3410/
//Problem Statement: Design HashSet

// Design a HashSet without using any built-in hash table libraries.

// To be specific, your design should include these functions:

// add(value): Insert a value into the HashSet. 
// contains(value) : Return whether the value exists in the HashSet or not.
// remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

// Example:

// MyHashSet hashSet = new MyHashSet();
// hashSet.add(1);         
// hashSet.add(2);         
// hashSet.contains(1);    // returns true
// hashSet.contains(3);    // returns false (not found)
// hashSet.add(2);          
// hashSet.contains(2);    // returns true
// hashSet.remove(2);          
// hashSet.contains(2);    // returns false (already removed)

// Note:

// All values will be in the range of [0, 1000000].
// The number of operations will be in the range of [1, 10000].
// Please do not use the built-in HashSet library.

//Solution:
class MyHashSet {
    
    int size;
    List<Integer>[] hashtable;

    int hash(int key) {
        return key%size;
    }
    /** Initialize your data structure here. */
    public MyHashSet() {
        size = 15000;
        hashtable = new LinkedList[size];
    }
    
    public void add(int key) {
        int idx=hash(key);
        if(hashtable[idx] == null) hashtable[idx] = new LinkedList<>();
        if(hashtable[idx].indexOf(key) == -1)
            hashtable[idx].add(key);
    }
    
    public void remove(int key) {
        int idx=hash(key);
        if(hashtable[idx] == null) return;
        int i=hashtable[idx].indexOf(key);
        if(i != -1)
            hashtable[idx].remove(i);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int idx=hash(key);
        if(hashtable[idx] == null || hashtable[idx].indexOf(key) == -1) return false;
        return true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

//Complexity: O(n)

