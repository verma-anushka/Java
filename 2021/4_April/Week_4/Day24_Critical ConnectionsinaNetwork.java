//Day 24: 
//Problem Statement: Critical Connections in a Network

// There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.

// A critical connection is a connection that, if removed, will make some servers unable to reach some other server.

// Return all critical connections in the network in any order.

 

// Example 1:



// Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
// Output: [[1,3]]
// Explanation: [[3,1]] is also accepted.
 

// Constraints:

// 2 <= n <= 105
// n - 1 <= connections.length <= 105
// 0 <= ai, bi <= n - 1
// ai != bi
// There are no repeated connections.

//Solution:
class Solution {

    int time=0;
    int low[], discovery[]; 
    List<Integer>[] adjList;
    List<List<Integer>> ans=new ArrayList();
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        low=new int[n];
        discovery=new int[n];
        adjList=new ArrayList[n];

        for(List<Integer> edge: connections) {
            
            int v1=edge.get(0), v2=edge.get(1);
            
            if(adjList[v1]==null) adjList[v1]=new ArrayList<>();
            if(adjList[v2]==null) adjList[v2]=new ArrayList<>();
            
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        
        }
        
        boolean[] visited=new boolean[n];
        dfs(-1, 0, visited);
        return ans;
    }
    
    void dfs(int parent, int u, boolean visited[]) {
    
        visited[u]=true;
        low[u]=discovery[u]=time++;
        
        for(int child: adjList[u]) {
            if(child==parent) continue; 
            
            if(!visited[child]) {
                dfs(u, child, visited);

                low[u]=Math.min(low[u], low[child]);
                
                if(low[child]>discovery[u]) {
                    ans.add(Arrays.asList(u, child));
                }
            } else {
                low[u]=Math.min(low[u], discovery[child]);
            }
        }
    }
}
//Complexity: O(V + E)

