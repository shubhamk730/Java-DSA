package dp;

public class FrogJump {
    

    // public static int frogJump(int n, int heights[]) {

    //     // Write your code here..
    //     int[] dp = new int[n+1];
    //     if(n == 0) return 0;

    //     dp[0] = 0;
    //     for(int i = 1; i < n; i++) {
    //         int j1 = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            
    //         int j2 = Integer.MAX_VALUE;
    //         if( i > 1) j2 = dp[i-2] + Math.abs(heights[i] - heights[i - 2]);
    //         dp[i] = Math.min(j1, j2);
    //     }

    //     return dp[n - 1];
    // }

    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        // n -1 jump
        int prev1 = 0;
        // n-2 jump
        int prev2 = 0;
        int curr = 0;
        if(n == 0) return 0;

        for(int i = 1; i < n; i++) {
            int j1 = prev1 + Math.abs(heights[i] - heights[i - 1]);
            int j2 = Integer.MAX_VALUE;
            if(i > 1) {
                j2 = prev2 + Math.abs(heights[i] - heights[i-2]);
            }
            curr = Math.min(j1, j2);
            prev2 = prev1;
            prev1 = curr;
        }

        return curr;
    }


}
