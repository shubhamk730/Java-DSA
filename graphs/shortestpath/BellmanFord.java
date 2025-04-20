package shortestpath;

// Bellman-Ford algorithm is used to find the shortest path from a single source vertex to all other vertices in a weighted graph.
// It can handle graphs with negative edge weights, but it cannot handle graphs with negative cycles.
// Relax all the edges n - 1 times
public class BellmanFord {
    
    static int[] bellmanFord(int V, int[][] edges, int src) {
        // Write your code here
        int[] dist = new int[V];
        
        for( int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;
        for(int i = 0; i < V - 1; i++ ) {
            for(var edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if(dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        for(var edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if(dist[u] + wt < dist[v]) {
                return new int[] {-1};
            }
        }

        for( int i = 0; i < V; i++) {
            if(dist[i] == Integer.MAX_VALUE) dist[i] = (int)10e8;
        }

        return dist;
    }

    public static void main(String[] args) {
        
    }

}
