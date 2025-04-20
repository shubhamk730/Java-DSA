package shortestpath;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    public int node;
    public int weight;

    public Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Pair other) {
        if (this.weight == other.weight)
            return this.node - other.node;
        return this.weight - other.weight;
    } 
}

class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

// Dijkstra does not work with negative edhge weights
public class DijkstraPQ {

    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        // Write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < adj.size(); i++) {
            ans.add((int)1e9);
        }

        Pair p = new Pair(src, 0);

        pq.add(p);
        ans.set(src, 0);

        while(!pq.isEmpty()) {
            int node = pq.peek().node;
            int weight  =pq.peek().weight;
            pq.poll();

            for(var neighbour : adj.get(node)) {
                if(weight + neighbour.second < ans.get(neighbour.first)) {
                    ans.set(neighbour.first, weight + neighbour.second);
                    pq.add(new Pair(neighbour.first, ans.get(neighbour.first)));
                }
            }

        }

        return ans;
    }
    
    public static void main(String[] args) {

    }

}
