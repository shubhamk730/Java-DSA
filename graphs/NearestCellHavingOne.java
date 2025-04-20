import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class NearestCellHavingOne {
     //Function to find distance of nearest 1 in the grid for each cell.

    public static int[][] nearest(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] ans = new int[n][m];
        int[][] vis = new int[n][m];
        Queue<int[]> q = new ArrayDeque<>();


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    ans[i][j] = 0;
                    vis[i][j] = 1;
                    q.add(new int[]{i,j});
                }
            }
        }

        int level = 1;
        int[][] dirs = {{-1,0}, {0, -1}, {1,0}, {0,1}};

        while (!q.isEmpty()) {
            int size = q.size();
            for(int k = 0; k < size; k++) {
                int[] cell = q.poll();
                int sr = cell[0]; 
                int sc = cell[1];

                for(var dir: dirs) {
                    int i = sr + dir[0];
                    int j = sc + dir[1];

                    if(i < n && i >= 0 && j < m && j >= 0 && vis[i][j] == 0) {
                        vis[i][j] = 1;
                        ans[i][j] = level;
                        q.add(new int[]{i, j});
                    }

                }
            }
            level++;
        }

        return ans;
    }

    public static void testNearest() {
        int[][] grid = {
            {0, 0, 0},
            {0, 1, 0},
            {1, 0, 0}
        };

        int[][] result = nearest(grid);

        System.out.println("Output:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        testNearest();
    }
}
