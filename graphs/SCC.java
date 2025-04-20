// Description: Strongly Connected Components (SCC) in a directed graph, not for undirected graphs.
// Author: Your Name
// Date: 2023-10-01
// This code implements Kosaraju's algorithm to find strongly connected components in a directed graph.
    // 1. Step 1: Perform a DFS on the original graph and store the vertices in a stack based on their finishing times.
    // 2. Step 2: Reverse the graph.
    // 3. Step 3: Perform DFS on the reversed graph in the order defined by the stack.
    

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class SCC {

    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> st) {
        vis[node] = 1;
        for(var neighbour : adj.get(node)) {
            if (vis[neighbour] == 0) {
                dfs(neighbour, adj, vis, st);
            }
        }
        st.push(node);
    }

    public void dfs2(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, ArrayList<Integer> ans) {
        vis[node] = 1;
        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs2(it, adj, vis, ans);
            }
        }
        ans.add(node);
    }

    public ArrayList<ArrayList<Integer>> tarjans(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();

        // Step 1: Perform DFS and fill the stack
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, adj, vis, st);  
            }
        }
        
        
        // Step 2: Reverse the graph
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }

        for(int i = 0; i < V; i++) {
            for(int it : adj.get(i)) {
                adjRev.get(it).add(i);
            }
        }

        // Step 3: Perform DFS on the reversed graph
        int[] vis2 = new int[V];

        while (!st.isEmpty()) {
            int node = st.pop();

            if (vis2[node] == 0) {
                ArrayList<Integer> temp = new ArrayList<>();
                dfs2(node, adjRev, vis2, temp);
                ans.add(temp);
            }
        }

        // Sort the components
        for (int i = 0; i < ans.size(); i++) {
            Collections.sort(ans.get(i));
        }
        Collections.sort(ans, (a, b) -> {
            if (a.get(0) == b.get(0)) {
                return 0;
            }
            return a.get(0) < b.get(0) ? -1 : 1;
        });

        return ans;
    
    }
    
    public static void main(String[] args) {
        
    }
}
