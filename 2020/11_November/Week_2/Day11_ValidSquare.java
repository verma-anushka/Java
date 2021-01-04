
//Day 11: 
//Problem Statement: Valid Square

// Given the coordinates of four points in 2D space p1, p2, p3 and p4, return true if the four points construct a square.

// The coordinate of a point pi is represented as [xi, yi]. The input is not given in any order.

// A valid square has four equal sides with positive length and four equal angles (90-degree angles).

 

// Example 1:

// Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
// Output: true
// Example 2:

// Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
// Output: false
// Example 3:

// Input: p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
// Output: true
 

// Constraints:

// p1.length == p2.length == p3.length == p4.length == 2
// -104 <= xi, yi <= 104

// Solution:
class Solution {    
            
    List<Double> side=new LinkedList<Double>();
    List<Double> diagonal=new LinkedList<Double>();
    
    private boolean isValid(int[] p1, int[] p2, int[] p3, int[] p4) {
        
        List<int[]> points=new LinkedList<int[]>();
    
        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);
        
        for(int i=0; i<4; i++) {
            int[] point=points.get(i);
            for (int j=i+1; j<4; j++) {
                int[] p=points.get(j);
                if(point[0]==p[0] && point[1]==p[1]) return false;
            }
        }
        
        return true;
    }
    
    private void add(double d) {
        
        if(side.size()==0 || side.get(0).equals(d)) 
            side.add(d);
        else if(diagonal.size()==0 || diagonal.get(0).equals(d)) 
            diagonal.add(d);
    
    }
    
    private boolean isDiagonal(int[] p1, int[] p2) {
    
        return p1[0]!=p2[0] && p1[1]!=p2[1];
   
    }
    
    private double getDistance(int[] p1, int[] p2) {
    
        int x1=p1[0], y1=p1[1];
        int x2=p2[0], y2=p2[1];
        
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    
    }
    
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {        
        
        if(!isValid(p1, p2, p3, p4)) 
            return false;
        
        add(getDistance(p1, p2));
        add(getDistance(p2, p3));
        add(getDistance(p3, p4));
        add(getDistance(p4, p1));
        add(getDistance(p1, p3));
        add(getDistance(p2, p4));
        
        return side.size()+diagonal.size()==6;
    
    }
       
}
//Complexity: O(1)

