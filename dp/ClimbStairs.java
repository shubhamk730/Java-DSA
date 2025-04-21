package dp;

public class ClimbStairs {
    static int countWays(int n) {
        // add your code here
        // add your code here
        if(n <= 2) return n;
        if(n == 3) return 4;
        int prev1 = 1;
        int prev2 = 2;
        int prev3 = 4;
        int curr = 0;
        for(int i = 4; i <= n; i++) {
            curr = prev1 + prev2 + prev3;
            prev1 = prev2;
            prev2 = prev3;
            prev3 = curr;
        }

        return curr;
    }
}
