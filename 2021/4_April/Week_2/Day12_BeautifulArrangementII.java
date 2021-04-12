
//Day 12: 
//Problem Statement: Beautiful Arrangement II

// Given two integers n and k, construct a list answer that contains n different positive integers ranging from 1 to n and obeys the following requirement:

// Suppose this list is answer = [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.
// Return the list answer. If there multiple valid answers, return any of them.

 

// Example 1:

// Input: n = 3, k = 1
// Output: [1,2,3]
// Explanation: The [1,2,3] has three different positive integers ranging from 1 to 3, and the [1,1] has exactly 1 distinct integer: 1
// Example 2:

// Input: n = 3, k = 2
// Output: [1,3,2]
// Explanation: The [1,3,2] has three different positive integers ranging from 1 to 3, and the [2,1] has exactly 2 distinct integers: 1 and 2.
 

// Constraints:

// 1 <= k < n <= 104

//Solution #1:
class Solution {
public:
    vector<int> constructArray(int n, int k) {
        
        vector<int> ans;
        int low=1, high=k+1;
        
        for(int i=0; i<=k; i++) {
            if(i%2==0) {
                ans.push_back(low);
                low++;
            } else {
                ans.push_back(high);
                high--;
            }
        }
        
        for(int i=k+1; i<n ; i++) {
            ans.push_back(i+1);
        }
        
        return ans;
    }
};
//Complexity: O(n)

//Solution #2:
class Solution {
public:
    vector<int> constructArray(int n, int k) {
         
        vector<int> ans(n);
        
        for(int i=0, a=1, z=k+1; i<=k; i++) {
            ans[i] = i%2 ? z--: a++;
        }  
        
        for(int i=k+1; i<n; i++) {
            ans[i] = i+1;
        }
        
        return ans;
    }
};

class Solution {
    public int[] constructArray(int n, int k) {
            
        int []ans=new int[n];
        
        for(int i=0, a=1, z=k+1; i<=k; i++) {
            ans[i] = i%2==1 ? z--: a++;
        }  
        
        for(int i=k+1; i<n; i++) {
            ans[i] = i+1;
        }
        
        return ans;
        
    }
}

//Complexity: O(n)

