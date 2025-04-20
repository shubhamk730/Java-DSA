package shortestpath;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class WaysToArriveDestination {
    

     static int countPaths(int n, List<List<Integer>> roads) {
        // Your code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int[] ways = new int[n];
        int[] dist = new int[n];

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            dist[i] = (int)1e9;
        }

        for(var road : roads) {
            int src = road.get(0);
            int dest = road.get(1);
            int weight = road.get(2);

            adj.get(src).add(new Pair(dest, weight));
            adj.get(dest).add(new Pair(src, weight));            
        }

        ways[0] = 1;
        dist[0] = 0;
        int mod = (int)1e9 + 7;
        PriorityQueue<Pair> q = new PriorityQueue<>();  
        q.add(new Pair(0, 0));

        while(!q.isEmpty()) {
            int node = q.peek().node;
            int wt = q.peek().weight;
            q.poll();

            for(var neighbour : adj.get(node)) {
                int newNode = neighbour.node;
                int dWt = neighbour.weight;
                if(wt + dWt < dist[newNode]) {
                    dist[newNode] = wt + dWt;
                    ways[newNode] = 1;
                    q.add(new Pair(newNode, wt + dWt));
                } else if (wt + dWt == dist[newNode]) {
                    ways[newNode] = (ways[node] + ways[newNode])%mod;
                }
            }
        }

        return ways[n-1]%mod;
    }

}
