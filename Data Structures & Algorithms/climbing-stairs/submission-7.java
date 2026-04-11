class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return dfs(n, memo);
    }

    private int dfs(int n, int[] memo){
        if(memo[n] != -1){
            return memo[n];
        }

        if(n == 0 || n == 1){
            return 1;
        }

        memo[n] = dfs(n-1, memo) + dfs(n-2, memo);
        return memo[n];
    }
}
