package dsu;

import java.util.ArrayList;
import java.util.List;



public class NumberIslands2 {
    public static int[] numOfIslandsII(int n, int m, int[][] q) {
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        int[][] grid = new int[n][m];

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        DisjointSet ds = new DisjointSet(n * m);
        int count = 0;

        for(int k = 0; k < q.length; k++) {
           int i = q[k][0];
           int j = q[k][1];

           if(grid[i][j] == 1) {
            ans.add(count);
            continue;
           }

           grid[i][j] = 1;
           count++;

           for(int d = 0; d < 4; d++) {
            int dr = i + dir[d][0];
            int dc = j + dir[d][1];

            if(dr >= 0 && dr < n && dc >= 0 && dc < m && grid[dr][dc] == 1) {
                int u = i*m + j;
                int v = dr*m + dc;
                if(ds.findUPar(u) != ds.findUPar(v)) {
                    ds.unionBySize(u, v);
                    count--;
                }
            }
           }

           ans.add(count);
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        
    }
}
