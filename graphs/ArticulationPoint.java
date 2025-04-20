
// Articulation point is a vertex in a graph such that removing it and all edges incident to it increases the number of connected components in the graph.
// In other words, an articulation point is a vertex that, when removed, disconnects the graph.
// Articulation points are important in network design, reliability analysis, and other applications where the robustness of a network is a concern.
// To find articulation points in a graph, we can use Depth First Search (DFS) and keep track of the discovery time and the lowest point reachable from each vertex.

import java.util.ArrayList;

public class ArticulationPoint {
    
    private int timer = 1;

    public void dfs(int node, int parent, int[] tin, int[] low, int[] mark, ArrayList<ArrayList<Integer>> adj) {
        tin[node] = low[node] = timer++;
        int child = 0;
        for(int it : adj.get(node)) {
            if(it == parent) continue;
            if(tin[it] == 0) {
                child++;
                dfs(it, node, tin, low, mark, adj);
                low[node] = Math.min(low[node], low[it]);
                if(low[it] >= tin[node] && parent != -1) {
                    mark[node] = 1;
                }
            } else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }

        if(parent == -1 && child > 1) {
            mark[node] = 1;
        }
    }

    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        int[] tin = new int[V];
        int[] low = new int[V];
        int[] mark = new int[V];

        for(int i = 0; i < V; i++) {
            if(tin[i] == 0) {
                dfs(i, -1, tin, low, mark, adj);
            }
        }

        for(int i = 0; i < V; i++) {
            if(mark[i] == 1) {
                ans.add(i);
            }
        }

        if(ans.size() == 0) {
            ans.add(-1);
        }

        return ans;
    }

    public static void main(String[] args) {
        
    }
}
