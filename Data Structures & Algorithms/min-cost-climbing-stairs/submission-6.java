class Solution {
    int[] dp = null;
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length+1];
        // Arrays.fill(memo, -1);
        dp[0] = 0;
        dp[1] = 0;
        for(int i=2; i<= cost.length; i++){
            dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2] + cost[i-2]);
        }

        return dp[cost.length];
        // return Math.min(dfs(cost, 0), dfs(cost, 1));
    }

    // private int dfs(int[] cost, int i){
    //     if(i >= cost.length){
    //         return 0;
    //     }

    //     if(memo[i] != -1){
    //         return memo[i];
    //     }

    //     memo[i] = cost[i] + Math.min(dfs(cost, i+1), dfs(cost, i+2));
    //     return memo[i];
    // }    
}
