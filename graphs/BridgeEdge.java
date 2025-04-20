import java.util.ArrayList;
import java.util.List;

public class BridgeEdge {

    public void dfs(int node, int parent, int step, int[] tin, int[] low, List<List<Integer>> ans, List<List<Integer>> adj) {
        tin[node] = low[node] = step++;
        for(int it : adj.get(node)) {
            if(it == parent) continue;  
            if(tin[it] == 0){
                dfs(it, node, step, tin, low, ans, adj);
                low[node] = Math.min(low[node], low[it]);
                if(low[it] > tin[node]) {
                    ans.add(List.of(node, it));
                }
            } else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }
    }

    // Torjan's ALgorithm to find if an edge is a bridge or not
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(var edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }


        int[] tin = new int[n];
        int[] low = new int[n];
        int step = 1;
        dfs(0, -1, step, tin, low, ans, adj);
        return ans;
    }
    


    public static void main(String[] args) {
        
    }

    
}
