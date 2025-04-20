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


public class UndirectedCycleDetectionDFS {

    public static void main(String[] args) {
        List<ArrayList<Integer>> graph = new CreateGraph().getGraph();
        int n = graph.size() - 1; // Fix: `graph.size()` is `n+1`, so actual nodes = `n`
        
        boolean cycleFound = false;
        int[] visited = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0 && isCycleDFS(graph, i, -1, visited)) {
                cycleFound = true;
                break;
            }
        }

        System.out.println("Cycle Exists: " + cycleFound);
    }

    public static boolean isCycleDFS(List<ArrayList<Integer>> graph, int src, int parent, int[] visited) {
        if(visited[src] != 0) return true;

        visited[src] = 1;

        for(var neighbour: graph.get(src)) {
            if(neighbour != parent) {
                boolean isCycle = isCycleDFS(graph, neighbour, src, visited);
                if(isCycle) return true;
            }
        }
        return false;
    }
}
