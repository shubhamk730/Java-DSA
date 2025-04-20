package shortestpath;

// Floyd-Warshall algorithm is used to find the shortest path between all pairs of vertices in a weighted graph. Unlike Dijkstra's algorithm, it can handle negative edge weights and is capable of finding the shortest paths in graphs with negative cycles.
// Unlike Dijkstra and Bellman-Ford, it is not a single-source shortest path algorithm. Instead, it computes the shortest paths between all pairs of vertices in O(V^3) time complexity.
// It uses dynamic programming to iteratively update the shortest path distances between all pairs of vertices.
// The algorithm works by considering all pairs of vertices and checking if the path from vertex i to vertex j can be improved by going through an intermediate vertex k. If it can, the distance is updated.
// The algorithm is typically implemented using a 2D array to store the shortest path distances between all pairs of vertices.
// The algorithm is not suitable for graphs with negative cycles, as it may produce incorrect results.
// The algorithm is not efficient for large graphs, as its time complexity is O(V^3), where V is the number of vertices in the graph.
// It is often used in applications where all-pairs shortest path information is required, such as in network routing, transportation systems, and game development.
// The algorithm can be used to find the shortest path between all pairs of vertices in a directed or undirected graph.

// To detect negative cycle, we have simple logic : for i = 0 to n-1, if mat[i][i] < 0, then there is a negative cycle in the graph.

public class FloydWarshall {

    public void shortestDistance(int[][] mat) {
        // Code here
        // modifying shortest distance at place in the matrix
        
        int n = mat.length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == -1) {
                    mat[i][j] = (int)1e9;
                } 
                if (i == j) {
                    mat[i][j] = 0;
                }
            }
        }

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(mat[i][k] + mat[k][j] < mat[i][j]) {
                        mat[i][j] = mat[i][k] + mat[k][j];
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == (1e9)) {
                    mat[i][j] = -1;
                } 
            }
        }

    }

}
