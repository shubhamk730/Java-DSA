import java.util.ArrayList;
import java.util.Scanner;

public class CreateGraph {
    
    public ArrayList<ArrayList<Integer>> getGraph() {
        int n, m;
        
        Scanner scn = new Scanner(System.in);
        
        System.out.println("Enter number of nodes: ");
        n = scn.nextInt();
        
        System.out.println("Enter number of edges");
        m = scn.nextInt();
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < m; i++) {
            System.out.println("Enter the nodes between which edge exists (u & v)");
            int u = scn.nextInt();
            int v = scn.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        scn.close();
        
        return graph;

    }

}
