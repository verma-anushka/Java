
//Day 17: 
//Problem Statement: Three Equal Parts

// You are given an array arr which consists of only zeros and ones, divide the array into three non-empty parts such that all of these parts represent the same binary value.

// If it is possible, return any [i, j] with i + 1 < j, such that:

// arr[0], arr[1], ..., arr[i] is the first part,
// arr[i + 1], arr[i + 2], ..., arr[j - 1] is the second part, and
// arr[j], arr[j + 1], ..., arr[arr.length - 1] is the third part.
// All three parts have equal binary values.
// If it is not possible, return [-1, -1].

// Note that the entire part is used when considering what binary value it represents. For example, [1,1,0] represents 6 in decimal, not 3. Also, leading zeros are allowed, so [0,1,1] and [1,1] represent the same value.

 

// Example 1:

// Input: arr = [1,0,1,0,1]
// Output: [0,3]
// Example 2:

// Input: arr = [1,1,0,1,1]
// Output: [-1,-1]
// Example 3:

// Input: arr = [1,1,0,0,1]
// Output: [0,2]
 

// Constraints:

// 3 <= arr.length <= 3 * 104
// arr[i] is 0 or 1

//Solution:
class Solution {
    public int[] threeEqualParts(int[] arr) {
        
        int ones=0;
        for(int num: arr) {
            ones+=num;
            // if(num==1)
            //     count++;
        }
        
        if(ones==0)
            return new int[]{0, 2};
        
        if(ones%3!=0)
            return new int[]{-1, -1};
        
        int p1=0, p2=0, p3=0;
        ones=ones/3;
        int temp=0;
        
        for(int i=0; i<arr.length; i++) {  
            if(arr[i]==1) { 
                if(temp==0)
                    p1=i;
                else if(temp==ones)
                    p2=i;
                else if(temp==2*ones)
                    p3=i;
                temp++;
            }
        
        }

        int prevp2=p2, prevp3=p3;
        while(p1<prevp2 && p2<prevp3 && p3<arr.length) {
            if(arr[p1]!=arr[p2] || arr[p2]!=arr[p3])
                return new int[]{-1, -1};
            p1++;
            p2++;
            p3++;
        }
        
        if(p3==arr.length) {
            return new int[]{p1-1, p2};
        }
        
        return new int[]{-1, -1};
    }
}
//Complexity: O(n)

