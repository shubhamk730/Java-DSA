package shortestpath;

import java.util.ArrayList;
import java.util.TreeSet;

class Pair implements Comparable<Pair> {
    int node;
    int weight;

    Pair(int w, int n) {
        this.weight = w;
        this.node = n;
    }

    // Comparator to sort based on weight, and then node to ensure uniqueness
    @Override
    public int compareTo(Pair other) {
        if (this.weight == other.weight)
            return this.node - other.node;
        return this.weight - other.weight;
    }
}

public class DijkstraSet {
    
     public static ArrayList<Integer> dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        TreeSet<Pair> set = new TreeSet<>();
        ArrayList<Integer> dist = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            dist.add((int)1e9);
        }

        dist.set(S, 0);
        set.add(new Pair(0, S));

        while (!set.isEmpty()) {
            Pair current = set.pollFirst(); // Get and remove the minimum pair
            int node = current.node;
            int d = current.weight;

            for (ArrayList<Integer> neighbor : adj.get(node)) {
                int adjNode = neighbor.get(0);
                int edgeWeight = neighbor.get(1);

                if (d + edgeWeight < dist.get(adjNode)) {
                    // If the neighbor is already in set with older distance, remove it
                    Pair oldPair = new Pair(dist.get(adjNode), adjNode);
                    set.remove(oldPair);

                    dist.set(adjNode, d + edgeWeight);
                    set.add(new Pair(dist.get(adjNode), adjNode));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        
    }
}
