// class Solution {
//     public int numIslands(char[][] grid) {
//         // Code here
//         int n =grid.length;
//         int m =grid[0].length;
        
//         int cnt = 0;
        
//         for(int i = 0; i < n; i++) {
//             for(int j = 0; j < m; j++) {
//                 if(grid[i][j] == '1'){ 
//                     dfs(i, j, n, m, grid);
//                     cnt++;  
//                 }
//             }
//         }
        
//         return cnt;
        
//     }
    
//     public void dfs(int i, int j, int n, int m, char[][] grid) {
//         if((i < 0) || (j < 0) || (i >= n) || (j >= m) || grid[i][j] != '1') return;
        
//         grid[i][j] = '2';
        
//         dfs(i-1,j,n,m,grid);
//         dfs(i-1,j+1,n,m,grid);
//         dfs(i-1,j-1,n,m,grid);
        
//         dfs(i,j-1,n,m,grid);
//         dfs(i,j+1,n,m,grid);
        
//         dfs(i+1,j-1,n,m,grid);
//         dfs(i+1,j,n,m,grid);
//         dfs(i+1,j+1,n,m,grid);
        
//         return;
//     }
// }
// public class NumberofIslands {
    
// }
