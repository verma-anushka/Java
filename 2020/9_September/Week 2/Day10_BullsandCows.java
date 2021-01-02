
//Day 10: 
//Problem Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3455/
//Problem Statement: Bulls and Cows

// You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.

// Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. 

// Please note that both secret number and friend's guess may contain duplicate digits.

 

// Example 1:

// Input: secret = "1807", guess = "7810"
// Output: "1A3B"
// Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1, and 7.

// Example 2:

// Input: secret = "1123", guess = "0111"
// Output: "1A1B"
// Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.

// Example 3:

// Input: secret = "1", guess = "0"
// Output: "0A0B"

// Example 4:

// Input: secret = "1", guess = "1"
// Output: "1A0B"

 

// Constraints:

//     1 <= secret.length, guess.length <= 1000
//     secret.length == guess.length
//     secret and guess consist of digits only.

//Solution:
class Solution {
    public String getHint(String secret, String guess) {
        int b=0, c=0;
        int []v=new int[10];
        for(int i=0; i<10; i++) {
            v[i]=0;
        }
        
        for(int i=0; i<secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) b++;
            else v[secret.charAt(i)-'0']++;
        }

        for(int i=0; i<guess.length(); i++) {
            if(secret.charAt(i) != guess.charAt(i) && v[guess.charAt(i)-'0'] > 0) {
                c++;
                v[guess.charAt(i)-'0']--;
            }
        }
        String ans = b + "A" + c + "B";
        return ans;
    }
}
//Complexity: O(n)

