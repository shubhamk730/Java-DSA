package shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

// class Pair {
//     public int node;
//     public int weight;

//     public Pair(int node, int weight) {
//         this.node = node;
//         this.weight = weight;
//     }
// }


public class WeightedUndirected {
    
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        List<List<Pair>> graph = new ArrayList<>();
        LinkedList<Integer> ans = new LinkedList<>();
        int[] parent = new int[n+1];
        List<Integer> dist = new ArrayList<>();


        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            dist.add((int)1e9);
            parent[i] = i;
        }

        for(int i = 0; i < m; i++) {
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            int wt = edges[i][2];

            graph.get(n1).add(new Pair(n2, wt));
            graph.get(n2).add(new Pair(n1, wt));
        }

        PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        q.add(new Pair(1, 0));

        dist.set(1, 0);

        while(!q.isEmpty()) {
            Pair current = q.poll();
            int node = current.node;
            int weight = current.weight;


            for(var neighbour : graph.get(node)) {
                int wt = neighbour.weight;
                int ng = neighbour.node;

                if(weight + wt < dist.get(ng)) {
                    parent[ng] = node;
                    dist.set(ng, wt + weight);
                    q.add(new Pair(ng,  weight + wt));
                }
            }

        }

        if(dist.get(n) == (int)1e9) {
            return new ArrayList<>(Arrays.asList(-1));
        } else {
            int node = n;
            while(parent[node] != node) {
                ans.addFirst(node);
                node = parent[node];
            }
            ans.addFirst(node);
        }

        return ans;
    }
    
    public static void main(String[] args) {
        WeightedUndirected solver = new WeightedUndirected();

        int n = 5, m = 6;
        int[][] edges = {
            {1, 2, 2},
            {1, 3, 4},
            {2, 3, 1},
            {2, 4, 7},
            {3, 5, 3},
            {4, 5, 1}
        };

        List<Integer> path = solver.shortestPath(n, m, edges);
        System.out.println("Shortest Path from 1 to " + n + ": " + path);
        
    }
}
