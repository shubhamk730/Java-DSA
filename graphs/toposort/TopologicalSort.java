package toposort;
// Wokrs only for Directed Acyclic Graph

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
public class TopologicalSort {

    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, Deque<Integer> queue) {
        if(vis[node] == 1) return;

        vis[node] = 1;

        for(var neighbour : adj.get(node)) {
            if(vis[neighbour] == 0) {
                dfs(neighbour, adj, vis, queue);
            }
        }

        queue.add(node);
    }

     static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        int n = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();

        int[] vis = new int[n];
        for(int i = 0; i < n; i++) {
            if(vis[i] ==0) {
                dfs(i, adj, vis, queue);
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.pollLast();
            ans.add(node);
        }
        
        return ans;
    }

    public static void main(String[] args) {
        
    }
    
}
