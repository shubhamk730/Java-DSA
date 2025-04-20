package mst;

public class ConnectingGraph {
    
    public int Solve(int n, int[][] edges) {
        // Code 
        int ans = Integer.MAX_VALUE;
        int freeEdges = 0;
        int cnt = 0;
        DisjointSet ds = new DisjointSet(n);
        for(var edge: edges) {
            int u = edge[0];
            int v = edge[1];
            if(ds.findUPar(u) != ds.findUPar(v)) {
                ds.unionByRank(u, v);
            } else {
                freeEdges++;
            }
        }
    
        for(int i = 0; i < n; i++) {
            if(ds.findUPar(i) == i) cnt++;
        }

        return freeEdges >= cnt - 1 ? cnt - 1 : -1;
    }

}
