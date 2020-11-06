
//Day 4: 
//Problem Statement: Minimum Height Trees

// A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.

// Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

// Return a list of all MHTs' root labels. You can return the answer in any order.

// The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

 

// Example 1:


// Input: n = 4, edges = [[1,0],[1,2],[1,3]]
// Output: [1]
// Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
// Example 2:


// Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
// Output: [3,4]
// Example 3:

// Input: n = 1, edges = []
// Output: [0]
// Example 4:

// Input: n = 2, edges = [[0,1]]
// Output: [0,1]
 

// Constraints:

// 1 <= n <= 2 * 104
// edges.length == n - 1
// 0 <= ai, bi < n
// ai != bi
// All the pairs (ai, bi) are distinct.
// The given input is guaranteed to be a tree and there will be no repeated edges.

//Solution:
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        List<Integer> ans=new ArrayList<>();
        if(n==1) ans.add(0);

		int []degree=new int[n];
		Map<Integer, List<Integer>> mp=new HashMap<>();
        
        for(int[] e: edges) {
			if(!mp.containsKey(e[0]))
				mp.put(e[0], new ArrayList<>());

			if(!mp.containsKey(e[1]))
				 mp.put(e[1], new ArrayList<>());

			mp.get(e[0]).add(e[1]);
			mp.get(e[1]).add(e[0]);
			degree[e[0]]++;
			degree[e[1]]++;
		}

		Queue<Integer> queue=new LinkedList<>();

		for(int i=0; i<n; i++) { 
			if(degree[i]==1)
				queue.offer(i);
		}

		while(!queue.isEmpty()){
			List<Integer> temp=new ArrayList<>();
			int size=queue.size();
			for(int i=0; i<size; i++) {
				int top=queue.poll();
				temp.add(top);
				for(int neighbour: mp.get(top)) {
					degree[neighbour]--;
					if(degree[neighbour] == 1){
						queue.offer(neighbour);
					}
				}
			}
			ans=temp;
		}
        
		return ans;
    }
}

//Complexity: O(n*n)
