package toposort;
/*
Summary :-
    Graph Construction

        Build an adjacency list using Pair(node, weight) from the given edge list.

    Topological Sort (DFS-based)

        Perform a DFS traversal.

        Push each node to a stack after all its neighbors are visited.

        This gives a valid topological order for the DAG.

    Initialize Distances

        Create a dist[] array of size V (number of vertices).

        Set all distances to ∞ (e.g., 1e9).

        Set dist[startNode] = 0 (source node is 0 in this case).

    Relax Edges in Topological Order

        Pop nodes from the stack (which is in topological order).

        For each neighbor of the current node, apply the relaxation step:


            if (dist[u] + weight < dist[v]) 
                dist[v] = dist[u] + weight;


        This ensures the shortest path is always calculated using the least costly route.

    Handle Unreachable Nodes

        After processing all nodes, replace any distance still set to ∞ with -1, indicating those nodes are not reachable from the source.

    📌 Key Concepts Used
    Topological Sort

    DAG (Directed Acyclic Graph)

    Shortest Path via Relaxation (like Dijkstra but no priority queue since graph is a DAG)

    DFS for ordering
*/ 

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair {
    public final int node;
    public final int weight;
    
    public Pair(int first, int second) {
        this.node = first;
        this.weight = second;
    }
}

public class ShortestPathDAG {

    public static void dfs(int node, List<List<Pair>> graph, int[] vis, Stack<Integer> st) {
        if(vis[node] == 1) return;

        vis[node] = 1;

        for(var neighbour : graph.get(node)) {
            if(vis[neighbour.node] == 0) {
                dfs(neighbour.node, graph, vis, st);
            } 
        }

        st.push(node);
    }

    
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        int startNode = 0;
        int[] dist = new int[V];
        int[] vis = new int[V];

        List<List<Pair>> graph  = new ArrayList<>();
        
        for(int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for(var edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            int weight = edge[2];

            graph.get(src).add(new Pair(dest, weight));
        }
        
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < V; i++) {
            if(vis[i] == 0) dfs(i, graph, vis, st);
        }
        for(int i = 0; i < V; i++) {
            dist[i] = (int)1e9;
        }

        dist[startNode] = 0;


        while (!st.empty()) {
            int node = st.pop();

            for(var neighbours : graph.get(node)) {
                int n = neighbours.node;
                int wt = neighbours.weight;

                if(dist[node] + wt < dist[n]) {
                    dist[n] = wt + dist[node];
                }
            }
            
        }

        for(int i = 0; i < V; i++) {
            if (dist[i] == (int)1e9) {
                dist[i] = -1;
            }
        }

        
        
        return dist;
    }

}
