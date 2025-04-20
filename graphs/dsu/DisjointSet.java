package dsu;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    
    public List<Integer> parent;
    public List<Integer> rank;
    public List<Integer> size;

    public DisjointSet(int n) {
        parent = new ArrayList<>();
        rank = new ArrayList<>();
        size = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }

    public int findUPar(int n) {
        if(n == parent.get(n)) {
            return n;
        }
        int up = findUPar(parent.get(n));
        parent.set(n, up);
        return up;
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v) return;

        int rank_u = rank.get(ulp_u);
        int rank_v = rank.get(ulp_v);

        if(rank_u < rank_v) {
            parent.set(ulp_u, ulp_v);
        } else if( rank_v < rank_u) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u) + 1);
        }   
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v) return;

        int size_u = size.get(ulp_u);
        int size_v = size.get(ulp_v);

        if(size_u < size_v) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }   
    }
}
