import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {
        CreateGraph cg = new CreateGraph();
        ArrayList<ArrayList<Integer>> graph = cg.getGraph();

        int n = graph.size();
        int[] visited = new int[n];
        Queue<Integer> q = new LinkedList<>();

        int startingNode = 1; // can take this input as well
        q.add(startingNode);
        visited[1] = 1;

        while(!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            
            for(var num : graph.get(node)) {
                if(visited[num] == 0) {
                    visited[num] = 1;
                    q.add(num);
                }
            }
        }

    }

}