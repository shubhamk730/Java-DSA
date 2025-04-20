import java.util.*;

// Build the Graph → Read n (nodes) and m (edges), initialize an adjacency list, and add edges.
// Initialize → Create a visited array and set cycleFound = false.
// Check All Components → Loop through all nodes; if unvisited, call isCycle().
// BFS for Cycle Detection:
// Start BFS from src, marking it visited.
// For each neighbor:
// If visited and not parent, cycle found (return true).
// If unvisited, mark and enqueue it.
// Print Result → "Cycle Exists: true" if detected, else "Cycle Exists: false".

class Pair {
    public int first;
    public int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class UndirectedCycleDetectionBFS {

    public static void main(String[] args) {
        List<ArrayList<Integer>> graph = new CreateGraph().getGraph();
        int n = graph.size() - 1; // Fix: `graph.size()` is `n+1`, so actual nodes = `n`
        
        boolean cycleFound = false;
        int[] visited = new int[n + 1];

        // Fix: Check all components to handle disconnected graphs
        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0 && isCycle(graph, i, visited)) {
                cycleFound = true;
                break;
            }
        }

        System.out.println("Cycle Exists: " + cycleFound);
    }

    public static boolean isCycle(List<ArrayList<Integer>> graph, int src, int[] visited) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, -1));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int node = p.first;
            int parent = p.second;

            if (visited[node] == 1) return true; 

            visited[node] = 1;

            for (int neighbor : graph.get(node)) {
                if (neighbor != parent && visited[neighbor] == 0) { 
                    q.add(new Pair(neighbor, node));
                }
            }
        }
        return false;
    }
}
