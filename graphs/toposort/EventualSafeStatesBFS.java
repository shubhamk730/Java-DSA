package toposort;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// using kahn's algorithms
public class EventualSafeStatesBFS {

    // terminal node is a node which has indegree of 0, so reverse all edges as question requires outdegree 0 as terminal node
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        // code here
        List<List<Integer>> revGraph = new ArrayList<>();
        int[] indegree = new int[V];
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < V; i++) {
            revGraph.add(new ArrayList<>());
        }

        for(int i = 0; i < V; i++) {
            for(int neighbour : adj.get(i)) {
                indegree[i]++;
                revGraph.get(neighbour).add(i);
            }
        }


        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for(var neighbour : revGraph.get(node)) {
                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }

        Collections.sort(ans);

        return ans;
    }

    public static void main(String[] args) {
        int V = 7;
        int E = 7;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int[][] edges = {
            {0, 1},
            {0, 2},
            {1, 2},
            {1, 3},
            {3, 0},
            {4, 5},
            {2, 5}
        };

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        EventualSafeStatesBFS obj = new EventualSafeStatesBFS();
        List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);

        System.out.println("Safe Nodes: " + safeNodes);
    }
}
