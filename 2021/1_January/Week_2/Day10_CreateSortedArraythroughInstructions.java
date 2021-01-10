
//Day 10: 
//Problem Statement: Create Sorted Array through Instructions

// Given an integer array instructions, you are asked to create a sorted array from the elements in instructions. You start with an empty container nums. For each element from left to right in instructions, insert it into nums. The cost of each insertion is the minimum of the following:

// The number of elements currently in nums that are strictly less than instructions[i].
// The number of elements currently in nums that are strictly greater than instructions[i].
// For example, if inserting element 3 into nums = [1,2,3,5], the cost of insertion is min(2, 1) (elements 1 and 2 are less than 3, element 5 is greater than 3) and nums will become [1,2,3,3,5].

// Return the total cost to insert all elements from instructions into nums. Since the answer may be large, return it modulo 109 + 7

 

// Example 1:

// Input: instructions = [1,5,6,2]
// Output: 1
// Explanation: Begin with nums = [].
// Insert 1 with cost min(0, 0) = 0, now nums = [1].
// Insert 5 with cost min(1, 0) = 0, now nums = [1,5].
// Insert 6 with cost min(2, 0) = 0, now nums = [1,5,6].
// Insert 2 with cost min(1, 2) = 1, now nums = [1,2,5,6].
// The total cost is 0 + 0 + 0 + 1 = 1.
// Example 2:

// Input: instructions = [1,2,3,6,5,4]
// Output: 3
// Explanation: Begin with nums = [].
// Insert 1 with cost min(0, 0) = 0, now nums = [1].
// Insert 2 with cost min(1, 0) = 0, now nums = [1,2].
// Insert 3 with cost min(2, 0) = 0, now nums = [1,2,3].
// Insert 6 with cost min(3, 0) = 0, now nums = [1,2,3,6].
// Insert 5 with cost min(3, 1) = 1, now nums = [1,2,3,5,6].
// Insert 4 with cost min(3, 2) = 2, now nums = [1,2,3,4,5,6].
// The total cost is 0 + 0 + 0 + 0 + 1 + 2 = 3.
// Example 3:

// Input: instructions = [1,3,3,3,2,4,2,1,2]
// Output: 4
// Explanation: Begin with nums = [].
// Insert 1 with cost min(0, 0) = 0, now nums = [1].
// Insert 3 with cost min(1, 0) = 0, now nums = [1,3].
// Insert 3 with cost min(1, 0) = 0, now nums = [1,3,3].
// Insert 3 with cost min(1, 0) = 0, now nums = [1,3,3,3].
// Insert 2 with cost min(1, 3) = 1, now nums = [1,2,3,3,3].
// Insert 4 with cost min(5, 0) = 0, now nums = [1,2,3,3,3,4].
// ​​​​​​​Insert 2 with cost min(1, 4) = 1, now nums = [1,2,2,3,3,3,4].
// ​​​​​​​Insert 1 with cost min(0, 6) = 0, now nums = [1,1,2,2,3,3,3,4].
// ​​​​​​​Insert 2 with cost min(2, 4) = 2, now nums = [1,1,2,2,2,3,3,3,4].
// The total cost is 0 + 0 + 0 + 0 + 1 + 0 + 1 + 0 + 2 = 4.
 

// Constraints:

// 1 <= instructions.length <= 105
// 1 <= instructions[i] <= 105

//Solution #1:
class Solution {

    int total=0, mod=1000000007;
    int[] nums, dict;

    public int query(int num) {
        
        int sum=0;
        while(num>0) {
            sum=sum+nums[num];
            num-=num&(-num);
        }

        System.out.println(sum);
        return sum;

    }

    public void update(int num) {

        while(num<nums.length) {
            nums[num]++; 
            num+=num&(-num);
        }
        total++;
    }

    public int createSortedArray(int[] instructions) {

        long ans=0;
        
        nums=new int[100001];
        dict=new int[100001];
        
        for(int ins: instructions) {

            int less=query(ins-1);
            int more=total-less-dict[ins];
            
            System.out.println(less + " " + more);
            
            ans+=Math.min(less, more);
            update(ins);
            dict[ins]++;

        }
        return (int)(ans%mod);
    }
}
//Complexity: O(n)

//Solution #2:
class Solution {
    
    int []tree=new int[4000040];
    int MAXN=100001, MOD=1000000007;
            
    public int query(int idx, int si, int ei, int qs, int qe) {
        
        if(si>=qs && ei<=qe)
            return tree[idx];

        if(ei<qs || si>qe)
            return 0;
        
        int mid=si+(ei-si)/2;
        int left=query(2*idx+1, si, mid, qs, qe);
        int right=query(2*idx+2, mid+1, ei, qs, qe);
        
        return left+right;

    }
    
    public void update(int idx, int si, int ei, int pos) {
        
        if(si==ei) {
            tree[idx]++;
            return;
        } 
        
        int mid=si+(ei-si)/2;
        
		if(pos<=mid) 
			update(2*idx+1, si, mid, pos);
		else
			update(2*idx+2, mid+1, ei, pos);

        tree[idx]=tree[2*idx+1]+tree[2*idx+2];

    }
    
    public int createSortedArray(int []instructions) {
        
        int cost=0;
        
        for(int x: instructions) {

            int smaller=query(0, 0, MAXN, 0, x-1); 
            int greater=query(0, 0, MAXN, x+1, MAXN); 
            update(0, 0, MAXN, x);
            cost=(cost+Math.min(smaller, greater))%MOD;
        }
        
        return cost; 
    }

}
//Complexity: O(n)
