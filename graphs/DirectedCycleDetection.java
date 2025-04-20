import java.util.ArrayList;

public class DirectedCycleDetection {

    // true -> has cycle, false -> no cycle
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int[] isPath, int node) {
        if(vis[node] == 1 && isPath[node] == 1) return true;
        if(vis[node] == 1 && isPath[node] == 0) return false;


        
        vis[node] = 1;
        isPath[node] = 1;
        for(var neighbour : adj.get(node)) {
            if(dfs(adj, vis, isPath, neighbour)) {
                return true;
            }
        }
        isPath[node] = 0;

        return false;
    }
    

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        int[] vis = new int[n];
        int[] isPath = new int[n];

        for(int i =0; i < n; i++) {
            if(vis[i] == 0 && dfs(adj, vis, isPath, i)) {
                return true;
            }
        }
        return false;
    }

}
