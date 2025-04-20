package dsu;

import java.util.HashSet;
import java.util.Set;

public class MaxConnected {

    public int MaxConnection(int grid[][]) {
        // Your code here
        int ans = 0;

        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);

        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                for(var dir : dirs) {
                    int delRow = i + dir[0];
                    int delCol = j + dir[1];

                    if(delRow >= 0 && delRow < n && delCol >= 0 && delCol < n && grid[delRow][delCol] == 1) {
                        int u = i*n + j;
                        int v = delRow*n + delCol;

                        if(ds.findUPar(u) != ds.findUPar(v)) {
                            ds.unionBySize(u, v);
                        }
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                if(grid[i][j] == 1) continue;

                Set<Integer> components = new HashSet<>();
                for(var dir : dirs) {
                    int delRow = i + dir[0];
                    int delCol = j + dir[1];

                    if(delRow >= 0 && delRow < n && delCol >= 0 && delCol < n && grid[delRow][delCol] == 1) {
                        components.add(ds.findUPar(delRow*n + delCol));
                    }
                }
                int size = 0;
                for(var s : components) {
                    size += ds.size.get(s);
                }
                ans = Math.max(ans, size + 1);

            }
        }

        for(int c = 0; c < n*n; c++) {
            ans = Math.max(ans, ds.size.get(ds.findUPar(c)));
        }
        

        return ans;
    }

}
