package toposort;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class PreRequisiteTasks {
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        // add your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < m; i++) {
            int t1 = prerequisites.get(i).get(0);
            int t2 = prerequisites.get(i).get(1);
            adj.get(t1).add(t2);
        }


        int[] inDegree = new int[n];
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int task : adj.get(i)) {
                inDegree[task]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for(int task : adj.get(node)) {
                inDegree[task]--;
                if(inDegree[task] == 0) {
                    q.add(task);
                }
            }
            
        }


        return ans.size() == n ? ans.stream().mapToInt(i -> i).toArray() : new int[0];

    }
}
