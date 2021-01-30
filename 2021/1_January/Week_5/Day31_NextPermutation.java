
//Day 31: 
//Problem Statement: Next Permutation

// Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

// If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

// The replacement must be in place and use only constant extra memory.

 

// Example 1:

// Input: nums = [1,2,3]
// Output: [1,3,2]
// Example 2:

// Input: nums = [3,2,1]
// Output: [1,2,3]
// Example 3:

// Input: nums = [1,1,5]
// Output: [1,5,1]
// Example 4:

// Input: nums = [1]
// Output: [1]
 

// Constraints:

// 1 <= nums.length <= 100
// 0 <= nums[i] <= 100

//Solution: 
class Solution {
    private void swap(int[] nums, int a, int b) {
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;        
    }
    
    private void reverse(int a[], int si) { 
        for(int i=si; i<a.length/2; i++) { 
            int temp=a[i]; 
            a[i]=a[a.length-i-1]; 
            a[a.length-i-1]=temp; 
        } 
    } 
    
    public void nextPermutation(int[] nums) {
                
        int n=nums.length;
        if(n<2) return;
        
        int i=n-1, j=n-1;        
        while(i>0 && nums[i-1]>=nums[i]) i--;
        
        if(i==0) {
            reverse(nums, 0);
            // Collections.reverse(Arrays.asList(nums)); 
            return;
        }        
        i--;
        
        while(j>i && nums[j]<=nums[i]) j--;
        
        swap(nums, i, j);
        // Collections.swap(Arrays.asList(nums), i, j); 
        
        reverse(nums, i+1);
        // reverse(nums.begin()+i+1, nums.end());
    }
}
//Complexity: O(n)

