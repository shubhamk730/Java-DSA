package shortestpath;

public class CityWithSmallestNeighborsAtDistance {

    int findCity(int n, int m, int[][] edges,int distanceThreshold)
    {
        //code
        int[][] dist = new int[n][n]; 
        
        for(var edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) dist[i][j] = 0;
                else if(dist[i][j] == 0) dist[i][j] = (int)1e9;
            }
        }

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int smallest = Integer.MAX_VALUE;
        int city = -1;
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if(count <= smallest) {
                smallest = count;
                city = i;
            }
        }

        return city;  
    }

    public static void main(String[] args) {
        
    }

}