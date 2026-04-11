class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+2];
        Arrays.fill(memo, -1);
        return dfs(n+1, memo);
    }

    private int dfs(int n, int[] memo){
        if(memo[n] == -1){
            if(n <= 1){
                return n;
            }

            memo[n] = dfs(n-1, memo) + dfs(n-2, memo);
        }

        return memo[n];
    }
}
