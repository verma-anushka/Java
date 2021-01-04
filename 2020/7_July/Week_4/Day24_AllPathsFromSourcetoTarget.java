//Day 24: 
//Problem Link: https://leetcode.com/explore/featured/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3400/
//Problem Statement: All Paths From Source to Target

// Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

// The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

// Example:
// Input: [[1,2], [3], [3], []] 
// Output: [[0,1,3],[0,2,3]] 
// Explanation: The graph looks like this:
// 0--->1
// |    |
// v    v
// 2--->3
// There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
// Note:

// The number of nodes in the graph will be in the range [2, 15].
// You can print different paths in any order, but you should keep the order of nodes inside one path.

//Solution:
class Solution {
    
    public void dfs(int[][] graph, List<Integer> path, int vertex, List<List<Integer>> ans) {
        path.add(vertex);
        if(vertex == graph.length-1) ans.add(new LinkedList(path));
        else for(int v:graph[vertex]) dfs(graph, path, v, ans);
        path.remove(path.size()-1);
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        List<Integer> path = new LinkedList<Integer>();
        dfs(graph, path, 0, ans);
        return ans;
    }
}
//Complexity: O(n*n)

