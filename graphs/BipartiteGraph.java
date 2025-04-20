import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

    private boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] color, int node, int currColor) {
        color[node] = currColor;

        for (int neighbor : adj.get(node)) {
            if (color[neighbor] == 0) { // If unvisited, color with opposite color
                if (!dfs(adj, color, neighbor, 3 - currColor)) { // 1 -> 2, 2 -> 1
                    return false;
                }
            } else if (color[neighbor] == color[node]) { // If same color, not bipartite
                return false;
            }
        }

        return true;
    }
   
    private boolean bfsCheck(ArrayList<ArrayList<Integer>> adj, int[] color, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 1; // Start with color 1

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : adj.get(node)) {
                if (color[neighbor] == 0) { // If unvisited, color it with opposite color
                    color[neighbor] = (color[node] == 1) ? 2 : 1;
                    queue.add(neighbor);
                } else if (color[neighbor] == color[node]) { // If same color, not bipartite
                    return false;
                }
            }
        }
        
        return true;
    }

    public boolean isBipartiteBFS(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int[] color = new int[n]; // 0 = unvisited, 1 = first color, 2 = second color

        // Check all components (handles disconnected graphs)
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) { // If not visited, start BFS
                if (!bfsCheck(adj, color, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int[] color = new int[n]; // 0 = unvisited, 1 = color1, 2 = color2

        for (int i = 0; i < n; i++) {
            if (color[i] == 0) { // If node is unvisited
                if (!dfs(adj, color, i, 1)) { // Start DFS with color 1
                    return false;
                }
            }
        }

        return true;
        
    }
    
    public static void main(String[] args) {
        
    }
}
