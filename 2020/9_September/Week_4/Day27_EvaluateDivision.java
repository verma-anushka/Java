
//Day 27: 
//Problem Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3474/
//Problem Statement: Evaluate Division

// You are given equations in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating-point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

// The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.

 

// Example 1:

// Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
// Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
// Explanation: 
// Given: a / b = 2.0, b / c = 3.0
// queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
// return: [6.0, 0.5, -1.0, 1.0, -1.0 ]

// Example 2:

// Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
// Output: [3.75000,0.40000,5.00000,0.20000]

// Example 3:

// Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
// Output: [0.50000,2.00000,-1.00000,-1.00000]

 

// Constraints:

//     1 <= equations.length <= 20
//     equations[i].length == 2
//     1 <= equations[i][0].length, equations[i][1].length <= 5
//     values.length == equations.length
//     0.0 < values[i] <= 20.0
//     1 <= queries.length <= 20
//     queries[i].length == 2
//     1 <= queries[i][0].length, queries[i][1].length <= 5
//     equations[i][0], equations[i][1], queries[i][0], queries[i][1] consist of lower case English letters and digits.


//Solution:
class Solution {
    
    Map<String, Map<String, Double>> graph=new HashMap<>();;
    
    double eval(String src, String dest, Set<String> visited) {

        if(src.equals(dest))
            return graph.containsKey(src) ? 1: -1;
        
        if(!graph.containsKey(src) || !graph.containsKey(dest) || visited.contains(src))        
            return -1;
        
        Map<String, Double> child=graph.get(src);
        if(child.containsKey(dest))
            return child.get(dest);
        
        visited.add(src);
        
        for(String key: child.keySet()) {            
            double ans=eval(key, dest, visited);
            if(ans!=-1)
                return child.get(key)*ans;
        }        

        visited.remove(src);
        return -1;        
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        for(int i=0; i<equations.size(); i++) {

            List<String> equation=equations.get(i);
            if(!graph.containsKey(equation.get(0)))
                graph.put(equation.get(0), new HashMap<>());
            
            if(!graph.containsKey(equation.get(1)))
                graph.put(equation.get(1), new HashMap<>());
            
            graph.get(equation.get(0)).put(equation.get(1), values[i]);
            graph.get(equation.get(1)).put(equation.get(0), 1/values[i]);
            
        }
        
        double[] ans=new double[queries.size()];
        
        for(int i=0; i<queries.size(); i++) {
            List<String> query=queries.get(i);
            ans[i]=eval(query.get(0), query.get(1), new HashSet<>());
        }
        return ans;
    }

}
//Complexity: O()

