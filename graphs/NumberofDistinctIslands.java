import java.util.*;

public class NumberofDistinctIslands {

    static String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }

    static void dfs(int[][] grid, int[][] vis, List<String> points,int i, int j, int sr, int sc, int n, int m) {
        if(i < 0 || i > n-1 || j < 0 || j > m - 1 || grid[i][j] == 0) return;

        int[][] dirs ={{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        vis[i][j] = 1;

        points.add(toString(i - sr, j -sc));

        for(var dir: dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == 0 && grid[nr][nc] == 1) {
                dfs(grid, vis, points, nr, nc, sr, sc, n, m);
            }

        }

    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Set<List<String>> ans = new HashSet<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(vis[i][j] == 0 && grid[i][j] == 1) {
                    List<String> points = new ArrayList<>();
                    dfs(grid, vis, points, i, j, i, j, n, m);
                    ans.add(points); 
                }
            }
        }

        
        return ans.size();
    }
    
    public static void main(String[] args) {
        
    }
}
