
//Day 17: 
//Problem Link: https://leetcode.com/explore/featured/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3393/
//Problem Statement: Top K Frequent Elements

//Given a non-empty array of integers, return the k most frequent elements.

//Example 1:

//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
//Example 2:

//Input: nums = [1], k = 1
//Output: [1]
//Note:

//You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
//Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
//It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
//You can return the answer in any order.

//Solution #1:
class Solution {  

    public int[] topKFrequent(int[] nums, int k) {

        if(k==nums.length) return nums;
        
        Map<Integer, Integer> mp = new HashMap();
        for(int num:nums)
            mp.put(num, mp.getOrDefault(num, 0)+1);

        Queue<Integer> pq = new PriorityQueue((a,b) -> mp.get(b) - mp.get(a));
        for(int m: mp.keySet()) pq.add(m);
        
        int []ans = new int[k];
        for(int i=0; i<k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}

//Complexity: O(n*logn)

//Solution #2:
class NumberComparator implements Comparator<Pair<Integer, Integer>> {               
    public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) { 
        if(p1.getValue() < p2.getValue()) {
            return 1;    
        } else {
            return -1;
        }
    } 
} 

class Solution {  

    public int[] topKFrequent(int[] nums, int k) {
        
    if(k==nums.length) return nums;
        Arrays.sort(nums);    
        Queue<Pair<Integer, Integer>> pq = new PriorityQueue(k, new NumberComparator());
        int num=nums[0], pos=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != num) {
                pq.add(new Pair(num, i-pos));
                num=nums[i];
                pos=i;
            }
        }
        pq.add(new Pair(nums[nums.length-1], nums.length-pos));
        
        int[] ans = new int[k];
        for(int i=0; i<k; i++) {
            ans[i] = pq.poll().getKey();
        }
        return ans;

    }
}

//Complexity: O(n*logn)

