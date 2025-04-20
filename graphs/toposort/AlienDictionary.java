package toposort;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {

    public static String getAlienLanguage(String []dictionary, int k) {
        // Write your code here.
        int[] inDegree = new int[k];

        List<List<Integer>> graph = new ArrayList();

        for(int i = 0; i < k; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < dictionary.length - 1; i++) {
            String curr = dictionary[i];
            String next = dictionary[i+1];

            int x = 0, y = 0;

            while (x < curr.length() && y < next.length()) {
                if((curr.charAt(x) != next.charAt(y))) {
                    int char1 = curr.charAt(x) - 'a';
                    int char2 = next.charAt(y) - 'a';
                    graph.get(char1).add(char2);
                    break;
                } else {
                    x++;
                    y++;
                }
            }
        }

        for(int i = 0; i < k; i++) {

            for(var neighbour : graph.get(i)) {
                inDegree[neighbour]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < k; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }


        StringBuilder stringBuilder = new StringBuilder();

        while (!q.isEmpty()) {
            int node = q.poll();
            stringBuilder.append((char)(node + 'a'));
            

            for(var neighbour : graph.get(node)) {
                inDegree[neighbour]--;

                if(inDegree[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }

        if (stringBuilder.length() < k) return "";

        return stringBuilder.toString();
    }
}
