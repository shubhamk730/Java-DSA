package shortestpath;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Tuple {
    int sr;
    int sc;
    int effort;

    public Tuple(int sr, int sc, int effort) {
        this.sr = sr;
        this.sc = sc;
        this.effort = effort;
    }

}

public class MinimumEffortPath {
 
    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        // code here
        int n = rows;
        int m = columns;
        int efforts[][] = new int[n][m];
        
        for(int i =0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                efforts[i][j] = (int)1e9;
            }
        }

        efforts[0][0] = 0;

        Tuple t  = new Tuple(0, 0, 0);
        PriorityQueue<Tuple> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.effort));
        q.add(t);

        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while(!q.isEmpty()) {
            Tuple ele = q.poll();
            int row = ele.sr;
            int col = ele.sc;
            int effort = ele.effort;

            if (row == n - 1 && col == m - 1) return effort;

            for(var dir : dirs) {
                int dRow = row + dir[0];
                int dCol = col + dir[1];

                if(dRow >= 0 && dRow < n && dCol >= 0 && dCol < m ) {
                    int currentDiff = (int)Math.abs(heights[row][col] - heights[dRow][dCol]);
                    int maxEffort = Math.max(currentDiff, effort);

                    if(maxEffort < efforts[dRow][dCol]) {
                        efforts[dRow][dCol] = maxEffort;
                        q.add(new Tuple(dRow, dCol, maxEffort));
                    }

                }
            }


        }


        return 0;
    }

}
