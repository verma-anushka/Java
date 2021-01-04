
//Day 27: 
//Problem Statement: Jump Game IV

// Given an array of integers arr, you are initially positioned at the first index of the array.

// In one step you can jump from index i to index:

// i + 1 where: i + 1 < arr.length.
// i - 1 where: i - 1 >= 0.
// j where: arr[i] == arr[j] and i != j.
// Return the minimum number of steps to reach the last index of the array.

// Notice that you can not jump outside of the array at any time.

 

// Example 1:

// Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
// Output: 3
// Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
// Example 2:

// Input: arr = [7]
// Output: 0
// Explanation: Start index is the last index. You don't need to jump.
// Example 3:

// Input: arr = [7,6,9,6,9,6,9,7]
// Output: 1
// Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
// Example 4:

// Input: arr = [6,1,9]
// Output: 2
// Example 5:

// Input: arr = [11,22,7,7,7,7,7,7,7,22,13]
// Output: 3
 

// Constraints:

// 1 <= arr.length <= 5 * 10^4
// -10^8 <= arr[i] <= 10^8

//Solution:
class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> mp=new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            List<Integer> indices=mp.getOrDefault(arr[i], new ArrayList<>());
            indices.add(i);
            mp.put(arr[i], indices);
        }
        
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);

        int level=0;
        boolean[] visited=new boolean[arr.length];
        
        
        while(!q.isEmpty()) {
        
            
            int size=q.size();
            
            while(size-->0) {
                Integer head=q.poll();
                
                if(head==arr.length-1) return level;
                
                if(head<0 || head>=arr.length || visited[head])
                    continue;
                
                if(head-1>0 && !visited[head-1]) 
                    q.offer(head-1);
                
                
                if(head+1<arr.length && !visited[head+1])
                    q.offer(head+1);
                
                if(mp.containsKey(arr[head])) {
                    for(int index: mp.get(arr[head])) {
                        if(index>=0 && index<arr.length && !visited[index])
                            q.offer(index);
                    }
                    mp.remove(arr[head]);
                }
                
                visited[head] = true;
            }
            
            level++;
                
        }
        
        return -1;
    }
}
//Complexity: O(n)

