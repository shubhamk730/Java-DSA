package mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Edge implements Comparable<Edge> {
    int u, v, wt;

    public Edge(int u, int v, int wt) {
        this.u = u;
        this.v = v;
        this.wt = wt;
    }

    @Override
    public int compareTo(Edge other) {
        return this.wt - other.wt;
    }
}

public class Kruskal {
    
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        ArrayList<Edge> edges = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            for(var edge : adj.get(i)) {
                int v = edge[0];
                int wt = edge[1];
                edges.add(new Edge(i, v, wt));
            }
        }

        Collections.sort(edges);

        DisjointSet ds = new DisjointSet(V);
        int sum = 0;
        ArrayList<Edge> mst = new ArrayList<>();
        for(Edge e : edges) {
            int u = e.u;
            int v = e.v;
            int wt = e.wt;

            if(ds.findUPar(u) != ds.findUPar(v)) {
                ds.unionByRank(u, v);
                sum += wt;
                mst.add(e);
            }
        }
        return sum;
    }


}
