
//Day 31: 
//Problem Statement: Search Suggestions System

// Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products after each character of searchWord is typed. 
// Suggested products should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

// Return list of lists of the suggested products after each character of searchWord is typed. 

 

// Example 1:

// Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
// Output: [
// ["mobile","moneypot","monitor"],
// ["mobile","moneypot","monitor"],
// ["mouse","mousepad"],
// ["mouse","mousepad"],
// ["mouse","mousepad"]
// ]
// Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
// After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
// After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
// Example 2:

// Input: products = ["havana"], searchWord = "havana"
// Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
// Example 3:

// Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
// Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
// Example 4:

// Input: products = ["havana"], searchWord = "tatiana"
// Output: [[],[],[],[],[],[],[]]
 

// Constraints:

// 1 <= products.length <= 1000
// There are no repeated elements in products.
// 1 <= Σ products[i].length <= 2 * 10^4
// All characters of products[i] are lower-case English letters.
// 1 <= searchWord.length <= 1000
// All characters of searchWord are lower-case English letters.

//Solution: 
class Solution {
    public int maximumGap(int[] nums) {
        
        if(nums.length<2) return 0;
        
        int high=0, low=Integer.MAX_VALUE, ans=0;
        for(int n: nums) {
            high=Math.max(high, n); 
            low=Math.min(low, n);            
        }
        
        int bsize=Math.max((high-low)/(nums.length-1), 1);
        List<List<Integer>> buckets=new ArrayList<>();
        
        for(int i=(high-low)/bsize; i>=0; i--) {
            buckets.add(new ArrayList<>());            
        }
        
        for(int n: nums) {
            buckets.get((n-low)/bsize).add(n);            
        }
        
        int currhigh=0;
        for(List<Integer> b: buckets) {
            if(b.isEmpty()) continue;
            int prevhigh=currhigh>0 ? currhigh: b.get(0), currlow=b.get(0);
            for(int n: b) {
                currhigh=Math.max(currhigh, n); 
                currlow=Math.min(currlow, n);                
            }
            
            ans=Math.max(ans, currlow-prevhigh);
        }
        
        return ans;
    }
}
//Complexity: O(n^2)

