package toposort;
import java.util.ArrayDeque;
import java.util.ArrayList;

// Kahn's Algo
// Compute In-Degrees: Count incoming edges for each node.

// Initialize Queue: Push all nodes with in-degree 0 into a queue.

// Process Nodes (BFS): Remove a node from the queue, add it to the result, and reduce the in-degree of its neighbors.

// Enqueue New Zero In-Degree Nodes: If a neighbor’s in-degree becomes 0, push it into the queue.

// Check for Cycles: If the result list size is less than V, a cycle exists (no valid topological order).

public class TopologicalSortBFSKahns {
    
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        int n = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        int[] inDegree = new int[n];

        for(int i = 0; i < n; i++) {
            for(var neighbour : adj.get(i)) {
                inDegree[neighbour]++;
            }
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.pollFirst();
            ans.add(node);

            for(var neighbour : adj.get(node)) {
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        // Cycle detection: If not all nodes are processed, return an empty list
        if (ans.size() < n) return new ArrayList<>();

        return ans;
    }

    public static void main(String[] args) {
        
    }
}
