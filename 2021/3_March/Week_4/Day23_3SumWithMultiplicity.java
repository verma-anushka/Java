
//Day 23: 
//Problem Statement: 3Sum With Multiplicity

// Given an integer array arr, and an integer target, return the number of tuples i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target.

// As the answer can be very large, return it modulo 109 + 7.

 

// Example 1:

// Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
// Output: 20
// Explanation: 
// Enumerating by the values (arr[i], arr[j], arr[k]):
// (1, 2, 5) occurs 8 times;
// (1, 3, 4) occurs 8 times;
// (2, 2, 4) occurs 2 times;
// (2, 3, 3) occurs 2 times.
// Example 2:

// Input: arr = [1,1,2,2,2,2], target = 5
// Output: 12
// Explanation: 
// arr[i] = 1, arr[j] = arr[k] = 2 occurs 12 times:
// We choose one 1 from [1,1] in 2 ways,
// and two 2s from [2,2,2,2] in 6 ways.
 

// Constraints:

// 3 <= arr.length <= 3000
// 0 <= arr[i] <= 100
// 0 <= target <= 300


//Solution :
class Solution {
    public int threeSumMulti(int[] arr, int target) {
                
        int MOD=1000000007;
        long ans=0;
        
        Arrays.sort(arr);       

        for(int i=0; i<arr.length; i++) {
            
            int t=target-arr[i];
            int j=i+1, k=arr.length-1;

            while(j<k) {
                
                if(arr[j]+arr[k]<t)
                    j++;
                else if(arr[j]+arr[k]>t)
                    k--;
                else if(arr[j]!=arr[k]) {
                
                    int left=1, right=1;
                    while(j+1<k && arr[j]==arr[j+1]) {
                        left++;
                        j++;
                    }
                    
                    while(k-1>j && arr[k]==arr[k-1]) {
                        right++;
                        k--;
                    }

                    ans+=left*right;
                    ans%=MOD;
                    j++;
                    k--;
                    
                } else {
                    ans+=(k-j+1)*(k-j)/2;
                    ans%=MOD;
                    break;
                }
            }
        }

        return (int) ans;
    }
}
//Complexity: O(n^2)
