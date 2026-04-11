class Solution {
    int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length + 1];
        Arrays.fill(memo, -1);
        
        return Math.min(solve(cost, 0), solve(cost, 1));
    }

    private int solve(int[] cost, int idx){
        if(idx >= cost.length){
            return 0;
        }

        if(memo[idx] != -1){
            return memo[idx];
        }

        int res = solve(cost, idx+1);
        if(idx < cost.length){
            res = Math.min(res, solve(cost, idx+2));
        }

        memo[idx] = res + cost[idx];

        return memo[idx];
    }
}
