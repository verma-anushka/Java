
//Day 22: 
//Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3433/
//Problem Statement: Random Point in Non-overlapping Rectangles

// Given a list of non-overlapping axis-aligned rectangles rects, write a function pick which randomly and uniformily picks an integer point in the space covered by the rectangles.

// Note:

// An integer point is a point that has integer coordinates. 
// A point on the perimeter of a rectangle is included in the space covered by the rectangles. 
// ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer coordinates of the bottom-left corner, and [x2, y2] are the integer coordinates of the top-right corner.
// length and width of each rectangle does not exceed 2000.
// 1 <= rects.length <= 100
// pick return a point as an array of integer coordinates [p_x, p_y]
// pick is called at most 10000 times.
// Example 1:

// Input: 
// ["Solution","pick","pick","pick"]
// [[[[1,1,5,5]]],[],[],[]]
// Output: 
// [null,[4,1],[4,1],[3,3]]
// Example 2:

// Input: 
// ["Solution","pick","pick","pick","pick","pick"]
// [[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
// Output: 
// [null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
// Explanation of Input Syntax:

// The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array of rectangles rects. pick has no arguments. Arguments are always wrapped with a list, even if there aren't any.

//Solution:
class Solution {
    int pts;
    Random random;
    ArrayList<Integer> rectcount;
    int [][]rects;

    public Solution(int[][] rects) {
        pts=0;
        rectcount = new ArrayList<>();
        // rects=new int[rects.length];
        // for(int i=0; i<rects.length; i++) {
        //     rects[i] = new int[rects.length];
        // }
        
        this.rects=rects;
        for(int[] rect: rects) {
            pts += (rect[2]-rect[0]+1)*(rect[3]-rect[1]+1);
            rectcount.add(pts);
        }
    }
    
    public int[] pick() {
        random = new Random();
        int idx = random.nextInt(pts);
        int l=0, r=rects.length-1;
        while(l<r) {
            int mid=l+(r-l)/2;
            if(rectcount.get(mid) <= idx) {
                l=mid+1;
            } else {
                r=mid;
            }
        }
        
        int[] rect=rects[l];
        int x=rect[2]-rect[0]+1;
        int y=rect[3]-rect[1]+1;
        
        int ptsrect = x*y;
        int ptsi = rectcount.get(l)-ptsrect;
        int offset = idx-ptsi;
        
        return new int[]{rect[0]+offset%x, rect[1]+offset/x};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
//Complexity: O(n)
