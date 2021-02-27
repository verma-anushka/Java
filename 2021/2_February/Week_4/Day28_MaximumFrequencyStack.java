
//Day 28: 
//Problem Statement: Maximum Frequency Stack

// Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.

// Implement the FreqStack class:

// FreqStack() constructs an empty frequency stack.
// void push(int val) pushes an integer val onto the top of the stack.
// int pop() removes and returns the most frequent element in the stack.
// If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
 

// Example 1:

// Input
// ["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
// [[], [5], [7], [5], [7], [4], [5], [], [], [], []]
// Output
// [null, null, null, null, null, null, null, 5, 7, 5, 4]

// Explanation
// FreqStack freqStack = new FreqStack();
// freqStack.push(5); // The stack is [5]
// freqStack.push(7); // The stack is [5,7]
// freqStack.push(5); // The stack is [5,7,5]
// freqStack.push(7); // The stack is [5,7,5,7]
// freqStack.push(4); // The stack is [5,7,5,7,4]
// freqStack.push(5); // The stack is [5,7,5,7,4,5]
// freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
// freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
// freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
// freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
 

// Constraints:

// 0 <= val <= 109
// At most 2 * 104 calls will be made to push and pop.
// It is guaranteed that there will be at least one element in the stack before calling pop.

//Solution:
class FreqStack {

    int maxFreq;
    HashMap<Integer, Integer> freq;
    HashMap<Integer, Stack<Integer>> freqStack;

    public FreqStack() {
        maxFreq=0;
        freq=new HashMap<>();
        freqStack=new HashMap<>();
    }
    
    public void push(int x) {
        freq.put(x, freq.getOrDefault(x, 0)+1);
        maxFreq=Math.max(maxFreq, freq.get(x));
        
        if(!freqStack.containsKey(freq.get(x)))
            freqStack.put(freq.get(x), new Stack<Integer>());
        
        freqStack.get(freq.get(x)).push(x);
    }
    
    public int pop() {
    
        int top=freqStack.get(maxFreq).pop();
        freq.put(top, freq.get(top)-1);
                
        if(freqStack.get(maxFreq).empty()) {
            freqStack.remove(maxFreq);
            maxFreq--;
        }
        return top;
        
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
    
//Complexity: O(n)
    
    