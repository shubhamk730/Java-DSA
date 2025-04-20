package mst;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// Prim's algorithm is used to find the minimum spanning tree of a weighted undirected graph.
class Node implements Comparable<Node> {
    public int node;
    public int parent;
    public int wt;

    public Node(int node, int parent, int wt) {
        this.node = node;
        this.parent = parent;
        this.wt = wt;
    }

    @Override
    public int compareTo(Node other) {
        if (this.wt == other.wt)
            return this.node - other.node;
        return this.wt - other.wt;
    }
}

class Pair {
    public int u;
    public int v;

    public Pair(int u, int v) {
        this.u = u;
        this.v = v;
    }
}

public class Prims {
    
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        int sum = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] vis = new int[V];
        ArrayList<Pair> mst = new ArrayList<>();
        pq.add(new Node(0, -1, 0));

        while(!pq.isEmpty()) {
            int parent = pq.peek().parent;
            int node = pq.peek().node; 
            int wt = pq.peek().wt;
            pq.poll();

            if(vis[node] == 1) continue;

            vis[node] = 1;
            if(parent != -1) {
                sum += wt; 
                mst.add(new Pair(parent, node));
            }

            for(var neighbour : adj.get(node)) {
                int newNode = neighbour[0];
                int newWt = neighbour[1];
                
                if(vis[newNode] == 0 ) {
                    pq.add(new Node(newNode, node, newWt));
                }
            }
        }

        
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                // Not all vertices were visited, graph is disconnected
                return -1;
            }
        }

        // for(var edge : mst) {
        //     System.out.println(edge.u + " " + edge.v);
        // }

        return sum;
    }

    public static void main(String[] args) {
        
    }
}
