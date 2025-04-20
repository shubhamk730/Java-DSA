import java.util.LinkedList;

class Pair {
    public int first;
    public int second;
    
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        int n = image.length;
        int m = image[0].length;
        int originalColor = image[sr][sc];

        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        LinkedList<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int i = p.first;
            int j = p.second;

            for(int[] dir : dirs) {
                int newRow = i + dir[0];
                int newCol = j + dir[1];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && image[newRow][newCol] == originalColor) {
                    image[newRow][newCol] = newColor;
                    q.add(new Pair(newRow, newCol));
                }

            }

            image[i][j] = newColor;
        }
        return image;
    }
}


public class FloodFill {
    
}
