import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair {
    int num;
    int lvl;

    public Pair(int num, int lvl) {
        this.num = num;
        this.lvl = lvl;
    }
}

public class MinimumMultiplicationsToEnd {
    
    int minimumMultiplications(int[] arr, int start, int end) {
        // Your code here
        final int MOD = 100000;
        int[] dist = new int[MOD];
        Arrays.fill(dist, (int)1e9);

        PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.lvl));
        q.add(new Pair(start, 0));
        dist[start] = 0;

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int num = p.num;
            int lvl = p.lvl;

            if(num == end) {
                return lvl;
            }

            for(var val : arr) {
                int newNum = (val * num)%MOD;
                if(lvl + 1 < dist[newNum]) {
                    dist[newNum] = lvl + 1;
                    q.add(new Pair(newNum, lvl + 1));
                }
            }
        }

        return -1;

    }

}
