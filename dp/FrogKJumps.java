package dp;

public class FrogKJumps {
    

    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        int k = 3;
        int[] dp = new int[n+1];
        if(n == 0) return 0;

        dp[0] = 0;
        for(int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= k; j++) {
                if(i-j >= 0) {
                    int jump = dp[i-j] + Math.abs(heights[i] - heights[i-j]);
                    min = Math.min(min, jump);
                } else {
                    break;
                }
            }
            dp[i] = min;
        }

        return dp[n - 1];
    }


    public static void main(String[] args) {
        
    }


}
