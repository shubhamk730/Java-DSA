// all edges have unit weights

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUndirected {
 
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        int n = adj.size();
        int[] dist = new int[n];

        for(int i = 0; i < n; i++) {
            dist[i] = (int)1e9;
        }

        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {
            int node = q.poll();

            for(var neighbor : adj.get(node)) {
                if (dist[node] + 1 < dist[neighbor]) {
                    dist[neighbor] = dist[node] + 1;
                    q.add(neighbor);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(dist[i] == (int)1e9)dist[i] = -1;
        }
        

        return dist;
    }
}
