
//Day 14: 
//Problem Link: https://leetcode.com/explore/featured/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3390/
//Problem Statement: Angle Between Hands of a Clock

// Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.

 

// Example 1:



// Input: hour = 12, minutes = 30
// Output: 165
// Example 2:



// Input: hour = 3, minutes = 30
// Output: 75
// Example 3:



// Input: hour = 3, minutes = 15
// Output: 7.5
// Example 4:

// Input: hour = 4, minutes = 50
// Output: 155
// Example 5:

// Input: hour = 12, minutes = 0
// Output: 0
 

// Constraints:

// 1 <= hour <= 12
// 0 <= minutes <= 59
// Answers within 10^-5 of the actual value will be accepted as correct.

//Solution:
class Solution {
    public double angleClock(int hour, int mins) {
        double h=(hour%12 + (double)mins/60)*30;
        double m=mins*6;
        double ans= Math.abs(h-m);
        if(ans>180) ans=360-ans;
        return ans;
    }
}

//Complexity: O(1)

