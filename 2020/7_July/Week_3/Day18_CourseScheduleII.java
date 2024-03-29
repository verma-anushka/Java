
//Day 18: 
//Problem Link: https://leetcode.com/explore/featured/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3394/
//Problem Statement: Course Schedule II

//There are a total of n courses you have to take, labeled from 0 to n-1.

//Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

//Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

//There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

//Example 1:

//Input: 2, [[1,0]] 
//Output: [0,1]
//Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
//           course 0. So the correct course order is [0,1] .
//Example 2:

//Input: 4, [[1,0],[2,0],[3,1],[3,2]]
//Output: [0,1,2,3] or [0,2,1,3]
//Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
//             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
//             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
//Note:

//The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
//You may assume that there are no duplicate edges in the input prerequisites.

//Solution:
class Solution {
    
    public boolean dfs(int c, List<Integer>[] adjlist, int[] visited, List<Integer> s) {
        
        visited[c]=1;
        for(int v:adjlist[c]) {
            if(visited[v] == 1) return true;
            if(visited[v] == 0 && dfs(v, adjlist, visited, s)) return true;
        }
        visited[c]=2;
        s.add(c);
        return false;
    }
    
    public int[] findOrder(int n, int[][] prereq) {

        List<Integer>[] adjlist = new LinkedList[n];
        for(int i=0; i<n; i++) 
            adjlist[i] = new LinkedList<Integer>();
        
        for(int[] pre:prereq)
            adjlist[pre[1]].add(pre[0]);

        int[] visited = new int[n];
        List<Integer> s = new LinkedList<Integer>();

        for(int i=0; i<n; i++) {
            if(visited[i]==0 && dfs(i, adjlist, visited, s)) return new int[0];
        }
        
        Collections.reverse(s);
        int[] ans = s.stream().mapToInt(Integer::intValue).toArray();
        return ans;

    }
}
//Complexity: O(n*e)
