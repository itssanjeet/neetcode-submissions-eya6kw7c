class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] memo = new int[amount+1];
        Arrays.fill(memo, -1);
        memo[0] = 0;

        int res = dfs(coins, amount, memo);
        return res >= 1e9?-1:res;
    }

    private int dfs(int[] coins, int amount, int[] memo){
        if(memo[amount] != -1){
            return memo[amount];
        }

        int res = (int)1e9 + 1;
        for(int c:coins){
            if(amount - c >= 0){
                res = Math.min(res, 1 + dfs(coins, amount-c, memo));
            }
        }

        memo[amount] = res;
        return res;
    }
}
