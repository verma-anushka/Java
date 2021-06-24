
//Day 25: 
//Problem Statement: Redundant Connection

// In this problem, a tree is an undirected graph that is connected and has no cycles.

// You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

// Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.

 

// Example 1:


// Input: edges = [[1,2],[1,3],[2,3]]
// Output: [2,3]
// Example 2:


// Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
// Output: [1,4]
 

// Constraints:

// n == edges.length
// 3 <= n <= 1000
// edges[i].length == 2
// 1 <= ai < bi <= edges.length
// ai != bi
// There are no repeated edges.
// The given graph is connected.

//Solution:
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent=new int[1005];
        int[] rank=new int[1005];
        int e1=-1, e2=-1;
        
        for(int i=0; i<1005; i++) {
            parent[i]=i; rank[i]=0;
        }
        
        for(int[] edge: edges) {
            if(findParent(edge[0], parent)==findParent(edge[1], parent)) {
                e1=edge[0]; e2=edge[1];
            } else
                unionSet(edge[0], edge[1], rank, parent);
        }
        
        return new int[]{e1, e2};
    }
    
    int findParent(int node, int[] parent) {
        if(parent[node]==node)
            return node;
        
        return parent[node]=findParent(parent[node], parent);
    }
    
    void unionSet(int u, int v, int[] rank, int[] parent) {
        
        u=findParent(u, parent);
        v=findParent(v, parent);
        
        if(rank[u]>rank[v])
            parent[v]=u;
        else if(rank[v]>rank[u])
            parent[u]=v;
        else {
            parent[v]=u;
            rank[u]++;
        }
    }
    
}
//Complexity: O(n)


