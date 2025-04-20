import java.util.ArrayList;

public class DFS {
    
    public static void dfs(ArrayList<ArrayList<Integer>> graph, int node, int[] visited, ArrayList<Integer> ans) {
        if(visited[node] > 0) return;

        ans.add(node);
        visited[node] = 1;
        for(var n : graph.get(node)) {
            dfs(graph, n, visited, ans);
        }
    }

    public static void main(String[] args) {
        CreateGraph cg = new CreateGraph();
        ArrayList<ArrayList<Integer>> graph = cg.getGraph();
        ArrayList<Integer> ans = new ArrayList<>();

        int n = graph.size();
        int[] visited = new int[n];

        dfs(graph, 2, visited, ans);

        System.out.println(ans);
    }

}
