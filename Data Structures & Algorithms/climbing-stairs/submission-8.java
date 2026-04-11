class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }

    // private int dfs(int n, int[] memo){
    //     if(memo[n] != -1){
    //         return memo[n];
    //     }

    //     if(n == 0 || n == 1){
    //         return 1;
    //     }

    //     memo[n] = dfs(n-1, memo) + dfs(n-2, memo);
    //     return memo[n];
    // }
}
