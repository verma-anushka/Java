
//Day 30: 
//Problem Statement: Largest Rectangle in Histogram

// Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

 


// Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

 


// The largest rectangle is shown in the shaded area, which has area = 10 unit.

 

// Example:

// Input: [2,1,5,6,2,3]
// Output: 10

//Solution:
class Solution {
    public int largestRectangleArea(int[] heights) {
                
        int maxArea=0;
        Stack<Integer> st=new Stack<>();
        
        for(int i=0; i<=heights.length; ) {
            int h=(i==heights.length ? 0: heights[i]);
            if(st.isEmpty() || h>=heights[st.peek()]) {
                st.push(i++);
            } else {
                int ht=heights[st.pop()];
                int w=i-(st.isEmpty() ? 0: st.peek()+1);
                maxArea=Math.max(maxArea, (ht*w));
            }
        }
        
        return maxArea;
    }
}
//Complexity: O(n)
