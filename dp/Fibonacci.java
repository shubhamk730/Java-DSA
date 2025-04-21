package dp;

public class Fibonacci {

    public void fn(int n, int[] mem) {
        if(n <= 1) return;

        if(mem[n] != 0) return;
        fn(n - 1, mem);
        fn(n - 2, mem);
        mem[n] = mem[n - 1] + mem[n - 2];
    }

    public int nthFibonacci(int n) {
        // code here
        // memoization
        // int[] mem = new int[n + 1];
        // mem[0] = 0;
        // mem[1] = 1;

        // fn(n, mem);
        // return mem[n-1];


        // tabulation
        // if(n <= 1) return n;

        // int[] dp = new int[n+1];
        // dp[0] = 0;
        // dp[1] = 1;

        // for(int i = 2; i <= n; i++) {
        //     dp[i] = dp[i - 1] + dp[i - 2];
        // }
        // return dp[n];

        // space optimization
        if(n <= 1) return n;
        int prev1 = 0;
        int prev2 = 1;
        int curr = 0;
        for(int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev1 = prev2;
            prev2 = curr;
        }
        return curr;
    
    }

    
    public static void main(String[] args) {
        
    }
}
