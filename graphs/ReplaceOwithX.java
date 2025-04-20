import java.util.Arrays;

public class ReplaceOwithX {
    static int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; // Global direction array

    static void dfs(char[][] mat, int[][] vis, int sr, int sc, int n, int m) {
        if (sr < 0 || sr >= n || sc < 0 || sc >= m || mat[sr][sc] == 'X' || vis[sr][sc] == 1) {
            return;
        }

        vis[sr][sc] = 1; // Mark the cell as visited

        for (var dir : dirs) {
            dfs(mat, vis, sr + dir[0], sc + dir[1], n, m);
        }
    }

    static char[][] fill(char mat[][]) {
        int n = mat.length, m = mat[0].length;
        int[][] vis = new int[n][m];

        // **Step 1: Mark 'O' regions connected to boundary using DFS**
        for (int i = 0; i < n; i++) {
            if (mat[i][0] == 'O' && vis[i][0] == 0) dfs(mat, vis, i, 0, n, m);
            if (mat[i][m - 1] == 'O' && vis[i][m - 1] == 0) dfs(mat, vis, i, m - 1, n, m);
        }

        for (int j = 0; j < m; j++) {
            if (mat[0][j] == 'O' && vis[0][j] == 0) dfs(mat, vis, 0, j, n, m);
            if (mat[n - 1][j] == 'O' && vis[n - 1][j] == 0) dfs(mat, vis, n - 1, j, n, m);
        }

        // **Step 2: Replace all unvisited 'O' with 'X'**
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && mat[i][j] == 'O') {
                    mat[i][j] = 'X';
                }
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        char[][] mat = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };

        char[][] result = fill(mat);

        System.out.println("Final Matrix:");
        for (char[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
