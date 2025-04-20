import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventualSafeStates {
    public boolean dfs(List<List<Integer>> adj, int[] vis, int node) {
        if(vis[node] == 1) return true;
        if(vis[node] == 2) return false;


        
        vis[node] = 1;

        for(var neighbour : adj.get(node)) {
            if(dfs(adj, vis, neighbour)) {
                return true;
            }
        }

        vis[node] = 2;

        return false;
    }

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        // code here
        int n = adj.size();
        int[] vis = new int[n];
        List<Integer> ans = new ArrayList<>();

        for(int i =0; i < n; i++) {
            if(!dfs(adj, vis, i)) {
                ans.add(i);
            }
        }

        Collections.sort(ans);

        return ans;
    }
}
