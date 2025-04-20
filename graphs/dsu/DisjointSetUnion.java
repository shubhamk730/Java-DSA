package dsu;

import java.util.ArrayList;
import java.util.List;


class DisjointSet {

    List<Integer> parent;
    List<Integer> rank;
    List<Integer> size;

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


public class DisjointSetUnion {
    

    public static void main(String[] args) {
        // DSU has 2 main functions 
        // 1. Find - find the parent of a node
        // 2. Union - join two sets together
        // 3. Path compression - optimize the find function
        // Union can be of two types
        // 1. Union by rank - always attach the smaller tree under the larger tree
        // 2. Union by size - always attach the smaller tree under the larger tree
        
        // Union by rank Union(u,v)
        // 1. Find ultimate parent of u & v, pu & pv
        // 2. Find rank of pu and pv
        // 3. Connect smaller rank to larger rank always

        DisjointSet dsu = new DisjointSet(7);

        // Initially, each element is its own parent
        System.out.println("Initial state:");
        for (int i = 0; i < 7; i++) {
            System.out.println("Element: " + i + ", Expected Parent: " + i + ", Actual Parent: " + dsu.findUPar(i));
        }

        // Perform unions
        System.out.println("\nPerforming union operations:");
        dsu.unionByRank(0, 1);
        dsu.unionByRank(1, 2);
        dsu.unionByRank(3, 4);
        dsu.unionByRank(4, 5);
        dsu.unionByRank(5, 6);

        // Check ultimate parents after unions
        System.out.println("\nAfter unions:");
        System.out.println("Expected Parent of 0, 1, 2: Same");
        System.out.println("Actual Parent of 0: " + dsu.findUPar(0));
        System.out.println("Actual Parent of 1: " + dsu.findUPar(1));
        System.out.println("Actual Parent of 2: " + dsu.findUPar(2));

        System.out.println("Expected Parent of 3, 4, 5, 6: Same");
        System.out.println("Actual Parent of 3: " + dsu.findUPar(3));
        System.out.println("Actual Parent of 4: " + dsu.findUPar(4));
        System.out.println("Actual Parent of 5: " + dsu.findUPar(5));
        System.out.println("Actual Parent of 6: " + dsu.findUPar(6));

        // Check that 0-2 and 3-6 are in different sets
        System.out.println("\nExpected: 0-2 and 3-6 are in different sets");
        System.out.println("Actual: " + (dsu.findUPar(0) != dsu.findUPar(3)));

        // Union the two sets
        System.out.println("\nUnion of sets containing 2 and 3:");
        dsu.unionByRank(2, 3);

        // Now all elements should have the same ultimate parent
        System.out.println("\nAfter union of all sets:");
        int ultimateParent = dsu.findUPar(0);
        for (int i = 0; i < 7; i++) {
            System.out.println("Element: " + i + ", Expected Parent: " + ultimateParent + ", Actual Parent: " + dsu.findUPar(i));
        }

        
    }

}
