
//Day 12: 
//Problem Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3457/
//Problem Statement: Combination Sum III

// Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

//     Only numbers 1 through 9 are used.
//     Each number is used at most once.

// Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

 

// Example 1:

// Input: k = 3, n = 7
// Output: [[1,2,4]]
// Explanation:
// 1 + 2 + 4 = 7
// There are no other valid combinations.

// Example 2:

// Input: k = 3, n = 9
// Output: [[1,2,6],[1,3,5],[2,3,4]]
// Explanation:
// 1 + 2 + 6 = 9
// 1 + 3 + 5 = 9
// 2 + 3 + 4 = 9
// There are no other valid combinations.

// Example 3:

// Input: k = 4, n = 1
// Output: []
// Explanation: There are no valid combinations. [1,2,1] is not valid because 1 is used twice.

// Example 4:

// Input: k = 3, n = 2
// Output: []
// Explanation: There are no valid combinations.

// Example 5:

// Input: k = 9, n = 45
// Output: [[1,2,3,4,5,6,7,8,9]]
// Explanation:
// 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
// ​​​​​​​There are no other valid combinations.

 

// Constraints:

//     2 <= k <= 9
//     1 <= n <= 60


//Solution:
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        combinationSum3Util(ans, current, n, k, 1);
        return ans;
        
    }
    
    public void combinationSum3Util(List<List<Integer>> ans, List<Integer> current, int n, int k, int si) {
        
        if(n==0 && k==0) {
            
            // System.out.println(current.size());
            ans.add(new ArrayList<Integer>(current));
            return;
        }
        
        if(k==0)
            return;
        
        for(int i=si; i<10; i++) {
            current.add(i);
            combinationSum3Util(ans, current, n-i, k-1, i+1);
            current.remove(current.size()-1);
        }
        return;
    }
}
//Complexity: O()

