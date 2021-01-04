
//Day 18: 
//Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3429/
//Problem Statement: Goat Latin

// A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

// We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

// The rules of Goat Latin are as follows:

// If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
// For example, the word 'apple' becomes 'applema'.

// If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
// For example, the word "goat" becomes "oatgma".

// Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
// For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
// Return the final sentence representing the conversion from S to Goat Latin. 

// Example 1:

// Input: "I speak Goat Latin"
// Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
// Example 2:

// Input: "The quick brown fox jumped over the lazy dog"
// Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"

// Notes:

// S contains only uppercase, lowercase and spaces. Exactly one space between each word.
// 1 <= S.length <= 150.

//Solution:
class Solution {
    public String toGoatLatin(String s) {
        StringBuilder ans = new StringBuilder();
        // StringBuilder ans="", word;

        String a = "a";

        for (String word : s.split(" ")) {
            char ch = Character.toLowerCase(word.charAt(0));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                ans.append(word).append("ma").append(a).append(" ");
            } else {
                ans.append(word.substring(1)).append(word.charAt(0)).append("ma").append(a).append(" ");
            }
            a += "a";

        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }
}
// Complexity: O(n)
